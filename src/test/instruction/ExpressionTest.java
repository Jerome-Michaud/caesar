/**
 * 
 */


package test.instruction;

import static instruction.TypeVariable.*;
import static instruction.Operateur.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import instruction.Affectation;
import instruction.Condition;
import instruction.Expression;
import instruction.Operation;
import instruction.VariableConstante;
import instruction.VariableModifiable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import traduction.VisiteurNXC;
import traduction.VisiteurTraduction;

/**
 * @author m1022
 *
 */
public class ExpressionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	//TODO automatiser
	@Test
	public void testComposeExpression() throws Exception{
		/* Expression
		 * e=(((a+b)>1)||((c*d)<8.2))
		 */
		VariableModifiable e = new VariableModifiable(BOOL,"e","");
		VariableModifiable a = new VariableModifiable(INT,"a","");
		VariableModifiable b = new VariableModifiable(INT,"b","");
		VariableModifiable c = new VariableModifiable(FLOAT,"c","");
		VariableModifiable d = new VariableModifiable(FLOAT,"d","");
		VariableConstante const1 = new VariableConstante(INT,"","1");
		VariableConstante const2 = new VariableConstante(FLOAT,"","8.2");
		
		Expression expr = new Affectation(// =
				e,
				new Condition(// ||
						OU,
						new Condition(// >
								SUPERIEUR,
								new Operation(// +
										ADDITION,
										a,
										b
										),
								const1
								),
						new Condition(// <
								INFERIEUR,
								new Operation(// *
										MULIPLICATION,
										c, 
										d
										),
								const2
								)
						)
				);
		VisiteurTraduction trad = new VisiteurNXC();
		trad.reset();
		trad.visiter((Affectation)expr);
		assertTrue(expr.toString().equals("e=(((a+b)>1)||((c*d)<8.2))"));
		System.out.println(trad.getTraduction());
		assertTrue(trad.getTraduction().equals("e = (((a + b) > 1) || ((c * d) < 8.2))"));

	};

}

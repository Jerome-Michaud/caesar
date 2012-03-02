/**
 * 
 */


package test.instruction;

import static instruction.TypeVariable.*;
import static instruction.TypeOperation.*;
import instruction.Affectation;
import instruction.Expression;
import instruction.Operation;
import instruction.VariableConstante;
import instruction.VariableModifiable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	@Test
	public void testComposeExpression() throws Exception{
		/* Expression
		 * e = ((a+b)>1)||(c*d<8.2)
		 */
		VariableModifiable e = new VariableModifiable(BOOL,"c","");
		VariableModifiable a = new VariableModifiable(INT,"a","");
		VariableModifiable b = new VariableModifiable(INT,"b","");
		VariableModifiable c = new VariableModifiable(FLOAT,"c","");
		VariableModifiable d = new VariableModifiable(FLOAT,"d","");
		VariableConstante const1 = new VariableConstante(INT,"","1");
		VariableConstante const2 = new VariableConstante(FLOAT,"","8.2");
		
		Expression expr = new Affectation(// =
				e,
				new Operation(// ||
						ADD,
						new Operation(// >
								SUPERIERE,
								new Operation(// +
										ADD,
										a,
										b
										),
								const1
								),
						new Operation(// <
								INFERIERE,
								new Operation(// *
										MUL,
										c, 
										d
										),
								const2
								)
						)
				);
		System.out.println(expr);

	};

}

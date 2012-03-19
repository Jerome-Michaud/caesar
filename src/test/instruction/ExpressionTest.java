/**
 * 
 */


package test.instruction;

import static instruction.TypeVariable.*;
import static instruction.Operateur.*;
import static org.junit.Assert.assertTrue;
import instruction.Affectation;
import instruction.Condition;
import instruction.Expression;
import instruction.Instruction;
import instruction.InstructionIf;
import instruction.InstructionTache;
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

	static Expression expression;
	static InstructionTache tache;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Setup d'expression
		
		VariableModifiable e = new VariableModifiable(BOOL,"e","");
		VariableModifiable a = new VariableModifiable(INT,"a","");
		VariableModifiable b = new VariableModifiable(INT,"b","");
		VariableModifiable c = new VariableModifiable(FLOAT,"c","");
		VariableModifiable d = new VariableModifiable(FLOAT,"d","");
		VariableConstante const1 = new VariableConstante(INT,"","1");
		VariableConstante const2 = new VariableConstante(FLOAT,"","8.2");
		
		Condition cond = new Condition(// ||
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
				);
		
		expression = new Affectation(// =
				e,
				cond
				);
		
		//Setup d'une tache
		
		InstructionIf instrIf1 = new InstructionIf(cond);
		InstructionIf instrIf2 = new InstructionIf(cond);
		
		tache = new InstructionTache();
		tache.insererFin((Instruction)expression);
		instrIf1.insererFin(instrIf2);
		tache.insererFin(instrIf1);
		tache.insererFin((Instruction)expression);
		
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
		 * e=(((a+b)>1)||((c*d)<8.2))
		 */
		
		VisiteurTraduction trad = new VisiteurNXC();
		trad.reset();
		trad.visiter((Affectation)expression);
		assertTrue(expression.toString().equals("e=(((a+b)>1)||((c*d)<8.2))"));
//		System.out.println(trad.getTraduction());
		assertTrue(trad.getTraduction().equals("e = (((a + b) > 1) || ((c * d) < 8.2))"));

	};
	
	@Test
	public void testComposeTache(){
		System.out.println(tache.toString());
	}

}

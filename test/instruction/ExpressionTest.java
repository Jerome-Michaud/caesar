package instruction;

import static instruction.TypeVariable.*;
import static instruction.Operateur.*;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import traduction.VisiteurNXC;
import traduction.VisiteurTraduction;

public class ExpressionTest {

	static Expression expression;
	static InstructionTache tache;

	/**
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		VariableModifiable e = new VariableModifiable(BOOL, "e", "");
		VariableModifiable a = new VariableModifiable(INT, "a", "");
		VariableModifiable b = new VariableModifiable(INT, "b", "");
		VariableModifiable c = new VariableModifiable(FLOAT, "c", "");
		VariableModifiable d = new VariableModifiable(FLOAT, "d", "");
		VariableConstante const1 = new VariableConstante(INT, "", "1");
		VariableConstante const2 = new VariableConstante(FLOAT, "", "8.2");

		Condition cond = new Condition(// ||
				OU,
				new Condition(// >
				SUPERIEUR,
				new Operation(// +
				ADDITION,
				a,
				b),
				const1),
				new Condition(// <
				INFERIEUR,
				new Operation(// *
				MULIPLICATION,
				c,
				d),
				const2));
		expression = new Affectation(// =
				e,
				cond, false);
	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComposeExpression() throws Exception {
		VisiteurTraduction trad = VisiteurNXC.getInstance();
		trad.reset();
		trad.visiter((Affectation) expression);
		assertTrue(expression.toString().equals("e=(((a+b)>1)||((c*d)<8.2))"));

		assertTrue(trad.getTraduction().equals("e = (((a + b) > 1) || ((c * d) < 8.2))"));
	}
;
}
package instruction;

import static instruction.Operateur.ADDITION;
import static instruction.Operateur.INFERIEUR;
import static instruction.Operateur.MULIPLICATION;
import static instruction.Operateur.OU;
import static instruction.Operateur.SUPERIEUR;
import static instruction.TypeVariable.BOOL;
import static instruction.TypeVariable.FLOAT;
import static instruction.TypeVariable.INT;

import modeles.DicoVars;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import traduction.VisiteurNXC;
import traduction.VisiteurTraduction;

public class InstructionTest {

	Expression expression;
	Condition cond;
	static InstructionStructure n1;
	static InstructionStructure i1;
	static VisiteurTraduction trad;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// Creer une tache , avec la creation d'une variable et son affectation

		VariableModifiable var = new VariableModifiable(TypeVariable.INT,
				"VariableModifiable", "");
		DicoVars dico = DicoVars.getInstance();
		dico.ajouter(var);

		System.out.println(dico.getLesvariables()[0].toString());

		i1 = new InstructionTache();
		InstructionDeclaration i2 = new InstructionDeclaration();
		InstructionDeclarationAffectation i3 = new InstructionDeclarationAffectation();
		i1.inserer(0, i2);
		i1.inserer(1, i3);
		i2.setMembre(var);
		i3.setMembre(var, new VariableConstante(TypeVariable.INT,
				"variableConstante", "10"));

		// Creation d'une expression

		VariableModifiable e = new VariableModifiable(BOOL, "e", "");
		VariableModifiable a = new VariableModifiable(INT, "a", "");
		VariableModifiable b = new VariableModifiable(INT, "b", "");
		VariableModifiable c = new VariableModifiable(FLOAT, "c", "");
		VariableModifiable d = new VariableModifiable(FLOAT, "d", "");
		VariableConstante const1 = new VariableConstante(INT, "", "1");
		VariableConstante const2 = new VariableConstante(FLOAT, "", "8.2");

		Condition cond = new Condition(// ||
				OU, new Condition(// >
				SUPERIEUR, new Operation(// +
				ADDITION, a, b), const1), new Condition(// <
				INFERIEUR, new Operation(// *
				MULIPLICATION, c, d), const2));

		Expression expression = new Affectation(// =
				e, cond, false);

		InstructionIf instrIf1 = new InstructionIf(cond);
		InstructionIf instrIf2 = new InstructionIf(cond);

		instrIf1.insererFin(instrIf2);
		i1.insererFin(instrIf1);
		i1.insererFin((Instruction) expression);

		// Creer une tache et la remplir de quelques instructions

		n1 = new InstructionTache();
		Instruction n2 = new InstructionMoteurRotate(Moteur.A, expression);
		Instruction n3 = new InstructionMoteurOff(Moteur.B);
		Instruction n4 = new InstructionMoteurMov(Moteur.C, expression);
		n1.inserer(0, n2);
		n1.inserer(1, n3);
		n1.inserer(2, n4);

		// Creation d'un visiteur NXC
		trad = VisiteurNXC.getInstance();

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
		VariableModifiable e = new VariableModifiable(BOOL, "e", "");
		VariableModifiable a = new VariableModifiable(INT, "a", "");
		VariableModifiable b = new VariableModifiable(INT, "b", "");
		VariableModifiable c = new VariableModifiable(FLOAT, "c", "");
		VariableModifiable d = new VariableModifiable(FLOAT, "d", "");
		VariableConstante const1 = new VariableConstante(INT, "", "1");
		VariableConstante const2 = new VariableConstante(FLOAT, "", "8.2");

		cond = new Condition(// ||
				OU, new Condition(// >
				SUPERIEUR, new Operation(// +
				ADDITION, a, b), const1), new Condition(// <
				INFERIEUR, new Operation(// *
				MULIPLICATION, c, d), const2));

		expression = new Affectation(// =
				e, cond, false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	// @Test
	public void testComposeInstruction() throws Exception {

		System.out.println(n1);

		System.out.println(i1);

	}

	;

	@Test
	public void testVisiteurNXC() throws Exception {

		VariableModifiable e = new VariableModifiable(BOOL, "e", "");
		VariableModifiable a = new VariableModifiable(INT, "a", "");
		VariableModifiable b = new VariableModifiable(INT, "b", "");
		VariableModifiable c = new VariableModifiable(FLOAT, "c", "");
		VariableModifiable d = new VariableModifiable(FLOAT, "d", "");
		VariableConstante const1 = new VariableConstante(INT, "", "10");
		VariableConstante const2 = new VariableConstante(FLOAT, "", "8.2");

		cond = new Condition(// ||
				OU, new Condition(// >
				SUPERIEUR, new Operation(// +
				ADDITION, a, b), const1), new Condition(// <
				INFERIEUR, new Operation(// *
				MULIPLICATION, c, d), const2));

		expression = new Affectation(// =
				e, cond, false);

		// trad.reset();
		// trad.visiter((InstructionTache)n1);

		// System.out.println(trad.getTraduction());

		VariableModifiable var = new VariableModifiable(TypeVariable.INT,
				"VariableModifiable", "");
		DicoVars dico = DicoVars.getInstance();
		dico.ajouter(var);
		InstructionStructure i1 = new InstructionTache();
		InstructionDeclaration i2 = new InstructionDeclaration();
		InstructionDeclarationAffectation i3 = new InstructionDeclarationAffectation();
		i1.insererFin(i2);
		i1.insererFin(i3);
		i2.setMembre(var);
		i3.setMembre(var, new VariableConstante(TypeVariable.INT,
				"variableConstante", "10"));
		// System.out.println(i1);

		// Creer un ifelse , un while , un dowhile dans une tache

		InstructionStructure a1 = new InstructionTache();
		InstructionIfElse a2 = new InstructionIfElse(cond);
		InstructionDoWhile a3 = new InstructionDoWhile(cond);
		InstructionWhile a4 = new InstructionWhile(cond);

		// OnRev, OnFwd ,repeat(), wait(), off, temps courant, for, 
		InstructionMoteurMov iMotAvancer = new InstructionMoteurMov(Moteur.B, const1);
		InstructionMoteurMov iMotReculer = new InstructionMoteurMov(Moteur.C, const1, true);
		InstructionRepeat iRepeat = new InstructionRepeat(
				new VariableModifiable(TypeVariable.INT, "r", "10"));
		InstructionAttente iWait = new InstructionAttente(
				new VariableModifiable(TypeVariable.INT, "g", "10"));
		InstructionFor iFor = new InstructionFor(new Affectation(new VariableModifiable(
				TypeVariable.FLOAT, "i", "1"), new VariableConstante(
				TypeVariable.FLOAT, "i", "1"), false), cond, new Affectation(
				new VariableModifiable(TypeVariable.FLOAT, "i", "1"),
				new Operation(Operateur.ADDITION, new VariableModifiable(
				TypeVariable.FLOAT, "i", "1"), new VariableConstante(
				TypeVariable.FLOAT, "i", "1")), false));
		InstructionTempsCourant iTemps = new InstructionTempsCourant();
		InstructionMoteurOff iOff = new InstructionMoteurOff(Moteur.B);


		a1.insererFin(a2);

		a2.insererFin(i2);
		a2.insererFin(i3);

		a2.insererFinElse(i2);
		a2.insererFinElse(i3);

		a3.insererDebut(iMotReculer);
		a3.insererDebut(iMotAvancer);

		a1.insererFin(a3);
		a1.insererFin(a4);
		a1.insererFin(iRepeat);
		a1.insererFin(iWait);
		a1.insererFin(iFor);
		iFor.insererFin(iRepeat);
		iFor.inserer(InstructionStructure.POSITION_FIN_CODE, iTemps);
		iFor.inserer(InstructionStructure.POSITION_DEBUT_CODE, iOff);
		iRepeat.insererFin(iWait);
		iRepeat.insererDebut(iWait);
		// System.out.println(a1);

		trad.setIdentationTabulation(false);
		trad.reset();
		trad.visiter((InstructionTache) a1);

		System.out.println(trad.getTraduction());

	}
;

}
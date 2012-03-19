package test.instruction;

import instruction.*;


import static instruction.Operateur.ADDITION;
import static instruction.Operateur.INFERIEUR;
import static instruction.Operateur.MULIPLICATION;
import static instruction.Operateur.OU;
import static instruction.Operateur.SUPERIEUR;
import static instruction.TypeVariable.BOOL;
import static instruction.TypeVariable.FLOAT;
import static instruction.TypeVariable.INT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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
public class InstructionTest {

	static InstructionStructure n1;
	static InstructionStructure i1;
	static VisiteurTraduction trad;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			
		//Creer une tache et la remplir de quelques instructions
		
		n1 = new InstructionTache();
		Instruction n2 = new InstructionMoteurRotate();
		Instruction n3 = new InstructionMoteurOff();
		Instruction n4 = new InstructionMoteurMov();
		n1.inserer(0,n2);
		n1.inserer(1,n3);
		n1.inserer(2,n4);
		
		//Creer une tache , avec la creation d'une variable et son affectation 
		
		VariableModifiable var = new VariableModifiable(TypeVariable.INT,"VariableModifiable","");
		DicoVars dico = DicoVars.getInstance();
		dico.ajouter(var );
		i1 = new InstructionTache();
		InstructionDeclaration i2 = new InstructionDeclaration () ;
		InstructionDeclarationAffectation i3 = new InstructionDeclarationAffectation ();
		i1.inserer(0,i2);
		i1.inserer(1,i3);
		i2.setMembre(var);
		i3.setMembre(var , new VariableConstante(TypeVariable.INT , "variableConstante",  "10"));
		
		//Creation d'une expression
		
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
		
		Expression expression = new Affectation(// =
				e,
				cond
				);
		
		InstructionIf instrIf1 = new InstructionIf(cond);
		InstructionIf instrIf2 = new InstructionIf(cond);

		instrIf1.insererFin(instrIf2);
		i1.insererFin(instrIf1);
		i1.insererFin((Instruction) expression);
		
		
		//Creation d'un visiteur NXC 
		trad = new VisiteurNXC();
		
		
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
	
	//@Test
	public void testComposeInstruction() throws Exception{
	
		System.out.println(n1);
			
		System.out.println(i1);

	};
	
	@Test
	public void testVisiteurNXC() throws Exception{
	
		trad.reset();
		trad.visiter((InstructionTache)n1);
		
		System.out.println(trad.getTraduction());
		
		trad.reset();
		trad.visiter((InstructionTache)i1);
		
		System.out.println(trad.getTraduction());

	};
	
	

}
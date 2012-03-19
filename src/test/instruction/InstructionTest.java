package test.instruction;

import instruction.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author m1022
 *
 */
public class InstructionTest {

	static InstructionStructure n1;
	static InstructionStructure i1;
	
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
	public void testComposeInstruction() throws Exception{
		
		System.out.println(n1);
			
		System.out.println(i1);

	};

}
package caesar.interpreteur;

import static org.junit.Assert.*;
import jscratch.interpreteur.MonteurNXTIM;
import jscratch.interpreteur.MonteurProgramme;
import nxtim.instruction.IElementProgramme;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.Variable;

import org.junit.Test;

public class MonteurNXTIMTest {

	@Test
	public void testTacheVide() {
		MonteurNXTIM monteur = new MonteurNXTIM();
		final String nomTache = "tache";
		monteur.tache(nomTache, 0);
		IElementProgramme elem = monteur.getModele();
		
		assertTrue("Classe de l'élément racine incorrect.", elem instanceof InstructionTache);
		
		InstructionTache tache = (InstructionTache) elem;
		assertEquals("Nom de la tâche incorrect.", nomTache, tache.getNom());
		assertEquals("Nombre d'instructions incorrectes dans le corp de la tâche.", 0, tache.getEnfants().size());
	}

	@Test
	public void testTacheUneInstruction() {
		MonteurNXTIM monteur = new MonteurNXTIM();
		final String nomTache = "tache";
		final String nomVariable = "var";
		monteur.declaration("int", nomVariable);
		monteur.tache(nomTache, 1);
		IElementProgramme elem = monteur.getModele();
		
		assertTrue("Classe de l'élément racine incorrect.", elem instanceof InstructionTache);
		
		InstructionTache tache = (InstructionTache) elem;
		assertEquals("Nom de la tâche incorrect.", nomTache, tache.getNom());
		assertEquals("Nombre d'instructions incorrectes dans le corp de la tâche.", 1, tache.getEnfants().size());
	}

	@Test
	public void testTachePlusieursInstructions() {
		MonteurNXTIM monteur = new MonteurNXTIM();
		final String nomTache = "tache";
		final String nomVariable1 = "var1";
		final String nomVariable2 = "var2";
		final String nomVariable3 = "var3";
		monteur.declaration("int", nomVariable1);
		monteur.declaration("char", nomVariable2);
		monteur.declaration("float", nomVariable3);
		monteur.tache(nomTache, 3);
		IElementProgramme elem = monteur.getModele();
		
		assertTrue("Classe de l'élément racine incorrect.", elem instanceof InstructionTache);
		
		InstructionTache tache = (InstructionTache) elem;
		assertEquals("Nom de la tâche incorrect.", nomTache, tache.getNom());
		assertEquals("Nombre d'instructions incorrectes dans le corp de la tâche.", 3, tache.getEnfants().size());
		
		InstructionDeclaration instr = (InstructionDeclaration) tache.getEnfants().get(0);
		Variable var = (Variable) instr.getMembre();
		assertEquals("Première variable déclarée incorrecte", nomVariable1, var.getNom());

		instr = (InstructionDeclaration) tache.getEnfants().get(1);
		var = (Variable) instr.getMembre();
		assertEquals("Deuxième variable déclarée incorrecte", nomVariable2, var.getNom());

		instr = (InstructionDeclaration) tache.getEnfants().get(2);
		var = (Variable) instr.getMembre();
		assertEquals("Troisième variable déclarée incorrecte", nomVariable3, var.getNom());
	}
}

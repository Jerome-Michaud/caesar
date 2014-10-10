package caesar.traduction;

import static org.junit.Assert.*;
import jscratch.traduction.VisiteurNXC;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.TypeElement;
import nxtim.instruction.VariableConstante;
import nxtim.instruction.VariableModifiable;

import org.junit.Test;

public class VisiteurNXCTest {

	@Test
	public void testTraduireTache() {
		InstructionTache tache = new InstructionTache("Tache");
		VisiteurNXC visiteur = VisiteurNXC.getInstance();
		tache.accepte(visiteur);
		assertEquals("Traduction d'un tâche vide incorrecte.", "task Tache(){\n}\n", visiteur.getTraduction());

		visiteur.reset();
		tache.insererDebut(new InstructionDeclaration(new VariableModifiable(TypeElement.INT, "i")));
		tache.accepte(visiteur);
		assertEquals("Traduction d'une tâche incorrecte.", "task Tache(){\n    int i;\n}\n", visiteur.getTraduction());
	}

}

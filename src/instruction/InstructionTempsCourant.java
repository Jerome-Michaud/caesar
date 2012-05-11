package instruction;

import traduction.VisiteurTraduction;

/**
 * Instruction donnant le temps écoulé depuis le lancement du programme.
 */
public class InstructionTempsCourant implements Instruction {

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(final VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}
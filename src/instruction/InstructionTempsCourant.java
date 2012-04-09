package instruction;

import traduction.VisiteurTraduction;
/**
 * Instruction donnant le temps écoulé depuis le lancement du programme.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionTempsCourant implements Instruction{

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}

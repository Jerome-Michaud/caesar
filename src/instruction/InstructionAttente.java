package instruction;

import traduction.VisiteurTraduction;

public class InstructionAttente implements Instruction {

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

package instruction;

import traduction.VisiteurTraduction;

public class InstructionTempsCourant implements Instruction{

	@Override
	public Categorie getCategorie() {
		// TODO getCategorie() pour InstructionTempsCourant
		return null;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
		
	}

}

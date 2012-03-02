package instruction;

import traduction.VisiteurTraduction;

public class InstructionRepeat extends InstructionInconditionelle{
	@Override
	public Categorie getCategorie() {
		return Categorie.CONTROL;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}

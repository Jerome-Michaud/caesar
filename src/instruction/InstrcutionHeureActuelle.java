package instruction;

import traduction.VisiteurTraduction;

//TODO nom InstrcutionHeureActuelle ?
public class InstrcutionHeureActuelle extends InstructionTerminale {

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

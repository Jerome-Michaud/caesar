package instruction;

//TODO nom InstrcutionHeureActuelle ?
public class InstrcutionHeureActuelle extends InstructionTerminale {

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

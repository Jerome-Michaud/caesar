package instruction;

public class InstructionAttente extends InstructionTerminale {

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

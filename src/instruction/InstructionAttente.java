package instruction;

public class InstructionAttente extends InstructionInconditionelle {

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

package instruction;

public class InstructionTempsCourant extends InstructionTerminale{

	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
		
	}

}

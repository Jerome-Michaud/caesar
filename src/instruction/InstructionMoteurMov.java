package instruction;

public class InstructionMoteurMov extends InstructionMoteurCmd{

	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
		
	}
	
}

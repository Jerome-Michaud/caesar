package instruction;

public class InstructionMoteurOff extends InstructionMoteurCmd{

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

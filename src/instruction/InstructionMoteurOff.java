package instruction;

import traduction.VisiteurTraduction;

public class InstructionMoteurOff extends InstructionMoteurCmd{

	public InstructionMoteurOff(Moteur moteur) {
		super(moteur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	
		
	}
	public String toString()
	{
		return "moteurOn("+moteur+")" ;
	}
	


}

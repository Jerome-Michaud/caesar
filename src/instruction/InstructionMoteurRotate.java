package instruction;

import traduction.VisiteurTraduction;

public class InstructionMoteurRotate extends InstructionMoteurCmd{
	
	protected Expression exp;
	
	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		// TODO Auto-generated method stub
		
	}
	public String toString()
	{
		return "moteurOn()";
	}
	public void setExpression ( Expression exp){
		this.exp = exp;
	}
}

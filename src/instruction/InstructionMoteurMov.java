package instruction;

import traduction.VisiteurTraduction;

public class InstructionMoteurMov extends InstructionMoteurCmd{

	protected boolean reverse;
	protected Expression exp;
	
	public InstructionMoteurMov(Moteur moteur, Expression exp, boolean reverse)
	{
		super(moteur);
		this.exp = exp;
		this.reverse = reverse;
	}
	
	public InstructionMoteurMov(Moteur moteur, Expression exp)
	{
		super(moteur);
		this.exp = exp;
		this.reverse = false;
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
	
	public boolean isReverse()
	{
		return reverse;
	}
	
	public String toString()
	{
		return "moteurMov("+moteur+")";
	}
	
	public void setExpression (Expression exp){
		this.exp = exp;
	}
	
	public Expression getExpression(){
		return exp;
	}
	
}

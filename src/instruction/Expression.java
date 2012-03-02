package instruction;

public interface Expression {

	public void setMembreDroit(Expression expression);
	public void setMembreGauche(Expression expression);
	void acceptVisiteur(VisiteurTraduction v);
	
}

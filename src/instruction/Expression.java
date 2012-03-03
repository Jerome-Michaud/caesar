package instruction;

import traduction.VisiteurTraduction;

public interface Expression {

	public void setMembreDroit(Expression expression);
	public void setMembreGauche(Expression expression);
	void accepte(VisiteurTraduction v);
	public String toString();
	
}

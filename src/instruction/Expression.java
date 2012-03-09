package instruction;

import traduction.VisiteurTraduction;

public interface Expression {

	void accepte(VisiteurTraduction v);
	public String toString();
	
}

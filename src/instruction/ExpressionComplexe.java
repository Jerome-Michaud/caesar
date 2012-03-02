package instruction;

import traduction.VisiteurTraduction;

public abstract class ExpressionComplexe implements Expression{

	protected Expression membreDroit;
	protected Expression membreGauche;
	protected TypeOperation typeOperation;
	
	public ExpressionComplexe(TypeOperation typeOperation, Expression membreDroit, Expression membreGauche) {
		this.membreDroit = membreDroit;
		this.membreGauche = membreGauche;
		this.typeOperation = typeOperation;
	}

	@Override
	public void setMembreDroit(Expression expression) {
		membreDroit = expression;
	}
	
	@Override
	public void setMembreGauche(Expression expression) {
		membreGauche = expression;
	}
	


	@Override
	public String toString() {
		if (this instanceof Affectation)
			return (membreGauche.toString()+typeOperation+membreDroit);
		return "("+membreGauche+typeOperation+membreDroit+")";
	}

}

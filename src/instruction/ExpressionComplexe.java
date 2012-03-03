package instruction;

public abstract class ExpressionComplexe implements Expression {

	protected Expression membreDroit;
	protected Expression membreGauche;
	protected TypeOperation typeOperation;

	public ExpressionComplexe(TypeOperation typeOperation,
			Expression membreGauche, Expression membreDroit) {
		this.typeOperation = typeOperation;
		this.membreGauche = membreGauche;
		this.membreDroit = membreDroit;
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
			return (membreGauche.toString() + typeOperation + membreDroit);
		return "(" + membreGauche + typeOperation + membreDroit + ")";
	}

}

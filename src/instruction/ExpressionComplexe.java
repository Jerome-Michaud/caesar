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

	/**
	 * Modifit le membre droit.
	 * @param expression l'expression à mettre en membre droit
	 */
	public void setMembreDroit(Expression expression) {
		membreDroit = expression;
	}

	/**
	 * Modifit le membre gauche.
	 * @param expression l'expression à mettre en membre gauche
	 */
	public void setMembreGauche(Expression expression) {
		membreGauche = expression;
	}

	@Override
	public String toString() {
		return "(" + membreGauche + typeOperation + membreDroit + ")";
	}

}

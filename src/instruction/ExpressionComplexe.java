package instruction;

public abstract class ExpressionComplexe implements Expression {

	public ExpressionComplexe() {
		super();
	}

	private Expression membreDroit;
	private Expression membreGauche;
	private Operateur operateur;

	public ExpressionComplexe(Operateur operation, Expression membreGauche,
			Expression membreDroit) {
		this.operateur = operation;
		this.membreGauche = membreGauche;
		this.membreDroit = membreDroit;
	}

	public ExpressionComplexe(Operateur operation) {
		this.operateur =  operation;
	}

	/**
	 * Modifie le membre droit.
	 * 
	 * @param expression
	 *            l'expression à mettre en membre droit
	 */
	public void setMembreDroit(Expression expression) {
		membreDroit = expression;
	}

	/**
	 * Modifie le membre gauche.
	 * 
	 * @param expression
	 *            l'expression à mettre en membre gauche
	 */
	public void setMembreGauche(Expression expression) {
		membreGauche = expression;
	}
	
	public Expression getMembreGauche() {
		return this.membreGauche;
	}
	
	public Expression getMembreDroit() {
		return this.membreDroit;
	}
	
	public Operateur getOperateur() {
		return this.operateur;
	}

	@Override
	public String toString() {
		return "(" + membreGauche + operateur + membreDroit + ")";
	}

}

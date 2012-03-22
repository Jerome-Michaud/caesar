package instruction;
/**
 * Expression composée de deux autres expressions
 * avec lesquelles effectuer une opération.
 * Utilise le design pattern Composite.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public abstract class ExpressionComplexe implements Expression {

	private Expression membreDroit;
	private Expression membreGauche;
	private Operateur operateur;
	
	/**
	 * Crée une expression vide, le contenu devra être fourni plus tard.
	 */
	public ExpressionComplexe() {
		super();
	}

	/**
	 * Crée une expression complexe.
	 * @param operation l'opérateur de l'expression
	 * @param membreGauche l'expression à gauche de l'opérateur
	 * @param membreDroit l'expression à droite de l'opérateur
	 */
	public ExpressionComplexe(Operateur operation, Expression membreGauche,
			Expression membreDroit) {
		this.operateur = operation;
		this.membreGauche = membreGauche;
		this.membreDroit = membreDroit;
	}

	/**
	 * Crée une expression complexe dont seul l'opérateur est défini,
	 * les membres devront être fournis plus tard.
	 * @param operation l'opérateur de l'expression
	 */
	public ExpressionComplexe(Operateur operation) {
		this.operateur =  operation;
	}

	/**
	 * Modifie le membre droit.
	 * @param expression l'expression à mettre en membre droit
	 */
	public void setMembreDroit(Expression expression) {
		membreDroit = expression;
	}

	/**
	 * Modifie le membre gauche.
	 * @param expression l'expression à mettre en membre gauche
	 */
	public void setMembreGauche(Expression expression) {
		membreGauche = expression;
	}
	
	/**
	 * Accède au membre gauche.
	 * @return le membre gauche.
	 */
	public Expression getMembreGauche() {
		return this.membreGauche;
	}
	
	/**
	 * Accède au membre droit.
	 * @return le membre droit.
	 */
	public Expression getMembreDroit() {
		return this.membreDroit;
	}
	
	/**
	 * Accède à l'opérateur.
	 * @return l'opérateur.
	 */
	public Operateur getOperateur() {
		return this.operateur;
	}

	@Override
	public String toString() {
		return "(" + membreGauche + operateur + membreDroit + ")";
	}
}

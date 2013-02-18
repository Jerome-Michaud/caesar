package nxtim.instruction;

/**
 * Cette instruction définit une incrémentation de 1 (
 * @since 1.0
 * @version 1.0
 */
public class InstructionIncrementation implements Instruction {

	/**
	 * L'expression à incrementer.
	 */
	private Expression expression;
	
	/**
	 * <code>true</code> si l'incrémentation est avant (++x).
	 */
	private boolean avant;
	
	/**
	 * <code>true</code> si l'incrémentation est positive (++).
	 */
	private boolean positive;
	
	/**
	 * Constructeur par défaut de <code></code>. L'incrémentation est du type x++.
	 * 
	 * @param expression l'expression
	 * @param positive <code>true</code> si l'incrémentation est positive, <code>false</code> sinon
	 */
	public InstructionIncrementation(final Expression expression, final boolean positive) {
		this.expression = expression;
		this.positive = positive;
		this.avant = false;
	}
	
	/**
	 * Constructeur par défaut de <code>InstructionIncrementation</code>.
	 * 
	 * @param expression l'expression (variable pour l'instant)
	 * @param positive <code>true</code> si l'incrémentation est positive, <code>false</code> sinon
	 * @param avant true si l'incrémentation est avant (++x), false sinon (x++)
	 */
	public InstructionIncrementation(final Expression expression, final boolean positive, final boolean avant) {
		this(expression, positive);
		this.avant = avant;
	}

	/**
	 * Permet de modifier l'expression.
	 * 
	 * @param la nouvelle expression
	 */
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	/**
	 * Permet de récupérer l'expression.
	 * 
	 * @return l'expression
	 */
	public Expression getExpression() {
		return this.expression;
	}

	/**
	 * Permet de savoir si l'incrementation est avant ou après.
	 * 
	 * @return <code>true</code> si l'incrémentation est avant, <code>false</code> sinon
	 */
	public boolean isAvant() {
		return this.avant;
	}
	
	/**
	 * Permet de savoir si l'incrementation est positive ou négative
	 * 
	 * @return <code>true</code> si l'incrémentation est positive, <code>false</code> sinon
	 */
	public boolean isPositive() {
		return this.positive;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.EXPRESSIONS;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	public Object getOperateur() {
		if (positive) {
			return Operateur.INCREMENTATION_PLUS;
		}
		else {
			return Operateur.INCREMENTATION_MOINS;
		}
	}
}
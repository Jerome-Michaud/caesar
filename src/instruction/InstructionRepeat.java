package instruction;

/**
 * Boucle de répétition.
 */
public class InstructionRepeat extends InstructionInconditionelle {

	/**
	 * L'instruction donnant le nombre de répétition.
	 */
	private Expression expression;

	/**
	 * Crée une boucle de répétition vide sans précision du nombre de répétition.<br/>
	 * L'expression donnant ce nombre vaut <code>null</code>.
	 */
	public InstructionRepeat() {
		super();
	}

	/**
	 * Crée une boucle de répétition vide.
	 *
	 * @param expr l'expression donnant le nombre de répétition
	 */
	public InstructionRepeat(final Expression expr) {
		super();
		this.expression = expr;
	}

	/**
	 * Accède à l'expression donnant le nombre de répétition.
	 *
	 * @return l'expression
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * Modifie l'expression donnant le nombre de répétition.
	 *
	 * @param expr la nouvelle expression
	 */
	public void setExpression(final Expression expr) {
		this.expression = expr;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.CONTROL;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}

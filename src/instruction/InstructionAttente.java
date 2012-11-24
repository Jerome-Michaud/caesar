package instruction;

/**
 * Cette instruction permet de mettre en attente le programme pendant un certain temps.
 */
public class InstructionAttente implements Instruction {

	/**
	 * L'expression donnant le temps d'attente.
	 */
	private Expression expression;

	/**
	 * Créé une instruction d'attente non initialisé.<br/>
	 * L'expression donnant le temps d'attente à pour valeur <code>null</code>.
	 */
	public InstructionAttente() {
		super();
	}

	/**
	 * Créé une instruction d'attente.
	 *
	 * @param expression l'expression donnant le temps d'attente.
	 */
	public InstructionAttente(final Expression expression) {
		super();
		this.expression = expression;
	}

	/**
	 * Accède à l'expression donnant le temps d'attente.
	 *
	 * @return l'expression.
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * Modifie l'expression donnant le temps d'attente.
	 *
	 * @param expr la nouvelle expression.
	 */
	public void setExpression(final Expression expr) {
		this.expression = expr;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(final VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}
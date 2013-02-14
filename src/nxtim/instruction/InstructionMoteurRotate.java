package nxtim.instruction;

/**
 * Instruction de rotation d'un moteur.
 */
public class InstructionMoteurRotate extends InstructionMoteurCmd {

	/**
	 * L'expression donnant la valeur de rotation.
	 */
	private Expression expression;

	/**
	 * Crée une instruction de rotation d'un moteur non initialisée.
	 */
	public InstructionMoteurRotate() {
		super();
	}

	/**
	 * Crée une instruction de rotation d'un moteur.
	 *
	 * @param moteur le moteur sur lequel effectuer la rotation
	 * @param exp l'expression donnant la valeur de la rotation
	 */
	public InstructionMoteurRotate(final Moteur moteur, final Expression exp) {
		super(moteur);
		this.expression = exp;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	/**
	 * Modifie l'expression donnant la valeur de la rotation.
	 *
	 * @param exp la nouvelle expression
	 */
	public void setExpression(final Expression exp) {
		this.expression = exp;
	}

	/**
	 * Accède à l'expression donnant la valeur de la rotation.
	 *
	 * @return l'expression
	 */
	public Expression getExpression() {
		return expression;
	}

	@Override
	public String toString() {
		return "moteurOn()";
	}
}
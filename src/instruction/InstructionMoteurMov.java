package instruction;

import traduction.VisiteurTraduction;

/**
 * Instruction de mouvement pour un moteur.
 */
public class InstructionMoteurMov extends InstructionMoteurCmd {

	/**
	 * Définit le sens du moteur.
	 */
	private boolean reverse;
	/**
	 * L'expression donnant la valeur de rotation.
	 */
	private Expression exp;

	/**
	 * Crée une instruction de mouvement d'un moteur non initialisée.
	 */
	public InstructionMoteurMov() {
		super();
	}

	/**
	 * Crée une instruction de mouvement d'un moteur.
	 *
	 * @param moteur le moteur concerné
	 * @param exp l'expression donnant la valeur du mouvement
	 * @param reverse booléen inversant le sens du mouvement si la valeur est <code>true</code>
	 */
	public InstructionMoteurMov(final Moteur moteur, final Expression exp, final boolean reverse) {
		super(moteur);
		this.exp = exp;
		this.reverse = reverse;
	}

	/**
	 * Crée une instruction de mouvement d'un moteur.<br/>
	 * Le sens du mouvement n'est pas inversé.
	 *
	 * @param moteur le moteur concerné
	 * @param exp l'expression donnant la valeur du mouvement
	 */
	public InstructionMoteurMov(final Moteur moteur, final Expression exp) {
		this(moteur, exp, false);
	}

	@Override
	public void accepte(final VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

	/**
	 * Modifie le sens du mouvement.
	 *
	 * @param reverse Si <code>true</code>, le mouvement est inversé
	 */
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	/**
	 * Permet de savoir si le mouvement est inversé.
	 *
	 * @return <code>true</code> si le mouvement est inversé, sinon <code>false</code>.
	 */
	public boolean isReverse() {
		return reverse;
	}

	/**
	 * Modifie l'expression de la valeur du mouvement.
	 *
	 * @param exp la nouvelle expression
	 */
	public void setExpression(final Expression exp) {
		this.exp = exp;
	}

	/**
	 * Accède à l'expression donnant la valeur du mouvement.
	 *
	 * @return l'expression
	 */
	public Expression getExpression() {
		return exp;
	}

	@Override
	public String toString() {
		return "moteurMov(" + getMoteur() + ")";
	}
}
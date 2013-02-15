package nxtim.instruction;

/**
 * Instruction pour un moteur.
 */
public abstract class InstructionMoteurCmd implements Instruction {

	/**
	 * Le moteur.
	 */
	private Moteur moteur;

	/**
	 * Crée une instruction un moteur non initialisée.<br/>
	 * Le moteur à pour valeur
	 * <code>null</code>.
	 */
	public InstructionMoteurCmd() {
		super();
		moteur = null;
	}

	/**
	 * Crée une instruction pour un moteur.
	 *
	 * @param moteur le moteur concerné
	 */
	public InstructionMoteurCmd(final Moteur moteur) {
		this.moteur = moteur;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.MOTEURS;
	}

	/**
	 * Modifie le moteur concerné par l'instruction.
	 *
	 * @param moteur le nouveau moteur
	 */
	public void setMoteur(final Moteur moteur) {
		this.moteur = moteur;
	}

	/**
	 * Accède au moteur concerné par l'instruction.
	 *
	 * @return le moteur
	 */
	public Moteur getMoteur() {
		return moteur;
	}
}
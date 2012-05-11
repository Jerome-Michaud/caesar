package instruction;

import traduction.VisiteurTraduction;

/**
 * Instruction d'arrêt d'un moteur.
 */
public class InstructionMoteurOff extends InstructionMoteurCmd {

	/**
	 * Crée une instruction d'arrêt d'un moteur non initialisée.
	 */
	public InstructionMoteurOff() {
		super(null);
	}

	/**
	 * Crée une instruction d'arrêt d'un moteur.
	 *
	 * @param moteur le moteur à arrêter
	 */
	public InstructionMoteurOff(final Moteur moteur) {
		super(moteur);
	}

	@Override
	public void accepte(final VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

	@Override
	public String toString() {
		return "moteurOn(" + getMoteur() + ")";
	}
}

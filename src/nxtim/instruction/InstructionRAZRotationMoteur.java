package nxtim.instruction;

/**
 * Instruction de remise à zéro du compteur de rotations d'un moteur.
 * 
 * @author Adrien DUROY
 */
public class InstructionRAZRotationMoteur extends InstructionMoteurCmd {

	/**
	 * Créé une instruction de remise à zéro du compteur de rotations d'un moteur.
	 */
	public InstructionRAZRotationMoteur() {
		super();
	}
	
	/**
	 * Créé une instruction de remise à zéro du compteur de rotations d'un moteur.
	 * 
	 * @param m le moteur à remettre à zéro.
	 */
	public InstructionRAZRotationMoteur(Moteur m) {
		super(m);
	}
	
	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
	
}

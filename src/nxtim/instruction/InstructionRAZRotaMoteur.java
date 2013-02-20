package nxtim.instruction;

/**
 * Instruction de remise à zéro du compteur de rotations d'un moteur.
 * 
 * @author Adrien DUROY
 */
public class InstructionRAZRotaMoteur extends InstructionMoteurCmd {

	/**
	 * Créé une instruction de remise à zéro du compteur de rotations d'un moteur.
	 */
	public InstructionRAZRotaMoteur() {
		super();
	}
	
	/**
	 * Créé une instruction de remise à zéro du compteur de rotations d'un moteur.
	 * 
	 * @param m le moteur à remettre à zéro.
	 */
	public InstructionRAZRotaMoteur(Moteur m) {
		super(m);
	}
	
	@Override
	public void accepte(VisiteurElementProg visiteur) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}

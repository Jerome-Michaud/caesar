package instruction;
/**
 * Instruction pour un moteur.
 * @author Adrien DUROY, Bastien AUBRY
 */
public abstract class InstructionMoteurCmd implements Instruction {

	private Moteur moteur;

	/**
	 * Crée une instruction un moteur non initialisée. Le moteur à pour valeur null.
	 */
	public InstructionMoteurCmd() {
		super();
		moteur = null;
	}

	/**
	 * Crée une instruction pour un moteur.
	 * @param moteur le moteur concerné
	 */
	public InstructionMoteurCmd(Moteur moteur){
		this.moteur = moteur;
	}
	
	/**
	 * Modifie le moteur concerné par l'instruction.
	 * @param moteur le nouveau moteur
	 */
	public void setMoteur(Moteur moteur){
			this.moteur = moteur;
	}
	
	/**
	 * Accède au moteur concerné par l'instruction.
	 * @return le moteur
	 */
	public Moteur getMoteur(){
		return moteur;
	}
}

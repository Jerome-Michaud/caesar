package nxtim.instruction;
/**
 * Instruction associant un capteur à un slot du robot.
 * 
 * @author Adrien DUROY
 */
public class InstructionDeclarationCapteur implements Instruction {

	private Capteur capteur;
	private CapteurSlot capteurSlot;

	/**
	 * Crée une déclaration vide pour le slot A.
	 */
	public InstructionDeclarationCapteur() {
		super();
		capteur = null;
		capteurSlot = CapteurSlot.A;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.CAPTEURS;
	}

	/**
	 * Modifie le capteur de la déclaration.
	 * 
	 * @param capteur le nouveau capteur
	 */
	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}

	@Override
	public String toString() {
		return " Instruction Declaration " + capteurSlot.toString() + " " + capteur.toString();
	}

	/**
	 * Accède au capteur de la déclaration.
	 * 
	 * @return le capteur ou null si n'a pas été précisé.
	 */
	public Capteur getCapteur() {
		return capteur;
	}

	/**
	 * Modifie le slot de la déclaration.
	 * 
	 * @param capteurSlot le nouveau slot
	 */
	public void setCapteurSlot(CapteurSlot capteurSlot) {
		this.capteurSlot = capteurSlot;
	}

	/**
	 * Donne le slot de la déclaration.
	 * 
	 * @return le slot
	 */
	public CapteurSlot getCapteurSlot() {
		return capteurSlot;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}

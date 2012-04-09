package instruction;

import traduction.VisiteurTraduction;
/**
 * Variable constante représentant un capteur.
 * @author Adrien DUROY, Bastien AUBRY
 */
public class VariableCapteur extends VariableConstante {
	private CapteurSlot capteurSlot ;
	
	/**
	 * Crée une variable constante pour le capteur du slot A.
	 */
	public VariableCapteur() {
		super(TypeVariable.INT, "", CapteurSlot.A.toString());
		capteurSlot = CapteurSlot.A;
	}
	
	/**
	 * Crée une variable constante pour capteur.
	 * @param capteurSlot le slot du capteur.
	 */
	public VariableCapteur(CapteurSlot capteurSlot) {
		super(TypeVariable.INT, "", CapteurSlot.A.toString());
		this.capteurSlot = capteurSlot;
	}
	
	/**
	 * Modifie le slot du capteur.
	 * @param capteurSlot le nouveau slot
	 */
	public void setCapteur(CapteurSlot capteurSlot) {
		this.capteurSlot = capteurSlot;
		this.setValeur(capteurSlot.toString());
	}
	
	/**
	 * Accède au slot du capteur.
	 * @return le slot
	 */
	public CapteurSlot getCapteurSlot(){
		return capteurSlot;
	}
	
	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}
}
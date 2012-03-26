package instruction;

import traduction.VisiteurTraduction;

public class VariableCapteur extends VariableConstante {
	/**
	 * Crée une variable constante pour capteur.
	 * @param type Le type de la variable
	 * @param nom Le nom de la variable
	 * @param valeur La valeur initiale de la variable
	 */
	
	private CapteurSlot capteurSlot ;
	
	public VariableCapteur() {
		super(TypeVariable.INT, "", CapteurSlot.A.toString());
		capteurSlot = CapteurSlot.A;
		
	}
	public VariableCapteur(CapteurSlot capteurSlot) {
		super(TypeVariable.INT, "", CapteurSlot.A.toString());
		this.capteurSlot = capteurSlot;
		
	}
	
	public void setCapteur ( CapteurSlot capteurSlot){
		this.capteurSlot = capteurSlot;
		this.setValeur(capteurSlot.toString());
	}
	
	public CapteurSlot getCapteurSlot(){
		return capteurSlot;
	}
	
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}
	
	
	
	
 

}



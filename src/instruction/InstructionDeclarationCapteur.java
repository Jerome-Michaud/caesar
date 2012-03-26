package instruction;

import traduction.VisiteurTraduction;

public class InstructionDeclarationCapteur implements Instruction{

	private Capteur capteur;
	private CapteurSlot capteurSlot;

	public InstructionDeclarationCapteur() {
		super();
	}
	
	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public void setCapteur ( Capteur capteur ){
		this.capteur=  capteur;
	}
	
	public String toString()
	{
		return " Instruction Declaration "+capteurSlot.toString() +" "+capteur.toString();
	}
	
	public Capteur getCapteur()
	{
		return capteur;
	}

	public void setCapteurSlot ( CapteurSlot capteurSlot ){
		this.capteurSlot=  capteurSlot;
	}
	
	public CapteurSlot getCapteurSlot()
	{
		return capteurSlot;
	}


	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	


}

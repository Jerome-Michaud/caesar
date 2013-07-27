package nxtim.instruction;

/**
 * Expression donnant la valeur courante d'un capteur à partir de son slot.
 * @author Adrien DUROY
 */
public class ValeurCapteur implements Expression {
	/**
	 * Le capteur dont on souhaite connaître la valeur.
	 */
	private CapteurSlot slot;
	
	/**
	 * Crée une expression de récupération de la valeur d'un capteur.
	 * @param slot le slot du capteur.
	 */
	public ValeurCapteur(CapteurSlot slot) {
		this.slot = slot;
	}
	
	@Override
	public Categorie getCategorie() {
		return Categorie.CAPTEURS;
	}

	@Override
	public void accepte(VisiteurElementProg v) {
		v.visiter(this);
	}
	
	/**
	 * Donne le slot à lire.
	 * @return 
	 */
	public CapteurSlot getSlot() {
		return slot;
	}
	
	/**
	 * Modifie le slot à lire.
	 * 
	 * @param slot le slot du capteur 
	 */
	public void setSlot(CapteurSlot slot) {
		this.slot = slot;
	}

	@Override
	public TypeElement getType() {
		return TypeElement.INT;
	}

	@Override
	public boolean isBooleenne() {
		return false;
	}
}

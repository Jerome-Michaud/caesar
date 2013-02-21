package nxtim.instruction;

import java.util.EnumMap;
import java.util.Map;

/**
 * Instruction de configuration des capteurs.
 * 
 * @author Adrien DUROY
 */
public class InstructionConfigCapteurs implements Instruction {
	private Map<CapteurSlot, Capteur> configs;
	
	/**
	 * Créé une instruction de configuration des capteurs.
	 */
	public InstructionConfigCapteurs() {
		configs = new EnumMap<CapteurSlot, Capteur>(CapteurSlot.class);
	}
	
	/**
	 * Donne le capteur configuré sur un slot.
	 * 
	 * @param slot le slot.
	 * @return le capteur associé au slot ou <code>null</code> si aucun capteur n'y est associé.
	 */
	public Capteur getCapteurAuSlot(CapteurSlot slot) {
		return configs.get(slot);
	}
	
	/**
	 * Supprime l'association d'un slot à un capteur.
	 * 
	 * @param slot le slot qui ne doit pu être associé à un capteur. 
	 */
	public void removeCapteurAuSlot(CapteurSlot slot) {
		configs.remove(slot);
	}
	
	/**
	 * Modifie le capteur associé à un slot.
	 * 
	 * @param slot le slot conserné par la modification.
	 * @param capteur le nouveau capteur à lui associer.
	 */
	public void setCapteurAuSlot(CapteurSlot slot, Capteur capteur) {
		if(capteur == null)
			removeCapteurAuSlot(slot);
		else
			configs.put(slot, capteur);
	}
	
	@Override
	public Categorie getCategorie() {
		return Categorie.CAPTEURS;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}

package nxtim.instruction;

import jscratch.helpers.LangueHelper;
import jscratch.parametrages.langue.VariableLangue;

/**
 * Cette énumération correspond aux différents capteurs.
 */
public enum Capteur {

	/**
	 * Aucun capteur.
	 */
	NONE,
	/**
	 * Capteur de collision.
	 */
	TOUCH,
	/**
	 * Capteur de couleur.
	 */
	COLOR,
	/**
	 * Capteur de distance.
	 */
	ULTRASONIC,
	/**
	 * Capteur de luminosité.
	 */
	LIGHT;

	@Override
	public String toString() {
		switch (this) {
			case NONE:
				return LangueHelper.getInstance().get(VariableLangue.CAPT_NONE).toUpperCase();
			case TOUCH:
				return LangueHelper.getInstance().get(VariableLangue.CAPT_TOUCH).toUpperCase();
			case COLOR:
				return LangueHelper.getInstance().get(VariableLangue.CAPT_COLOR).toUpperCase();
			case ULTRASONIC:
				return LangueHelper.getInstance().get(VariableLangue.CAPT_ULTRASONIC).toUpperCase();
			case LIGHT:
				return LangueHelper.getInstance().get(VariableLangue.CAPT_LIGHT).toUpperCase();
			default:
				return null;
		}
	}
}

package nxtim.instruction;

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
				return "NONE";
			case TOUCH:
				return "TOUCH";
			case COLOR:
				return "COLOR";
			case ULTRASONIC:
				return "SONIC";
			case LIGHT:
				return "LIGHT";
			default:
				return null;
		}
	}
}
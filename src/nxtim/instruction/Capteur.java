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
				return "RIEN";
			case TOUCH:
				return "CONTACT";
			case COLOR:
				return "COULEUR";
			case ULTRASONIC:
				return "DISTANCE";
			case LIGHT:
				return "LUMIERE";
			default:
				return null;
		}
	}
}
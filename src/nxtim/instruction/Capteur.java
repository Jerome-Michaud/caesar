package nxtim.instruction;

/**
 * Cette énumération correspond aux différents capteurs.
 */
public enum Capteur {

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
			case TOUCH:
				return "Capteur touch";
			case COLOR:
				return "Capteur color";
			case ULTRASONIC:
				return "Capteur ultrasonic";
			case LIGHT:
				return "Capteur light";
			default:
				return null;
		}
	}
}
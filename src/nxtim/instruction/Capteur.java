package nxtim.instruction;

/**
 * Cette énumération correspond aux différents capteurs.
 */
public enum Capteur {

	/**
	 * Pression.
	 */
	TOUCH;

	@Override
	public String toString() {
		switch (this) {
			case TOUCH:
				return "Capteur touch";
			default:
				return null;
		}
	}
}
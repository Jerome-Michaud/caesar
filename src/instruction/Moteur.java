package instruction;

/**
 * Cette énumération regroupe les différents moteurs.
 */
public enum Moteur {

	/**
	 * Les moteurs.
	 */
	A, B, C;

	@Override
	public String toString() {
		switch (this) {
			case A:
				return "A";
			case B:
				return "B";
			case C:
				return "C";
			default:
				break;
		}
		return null;
	}
}
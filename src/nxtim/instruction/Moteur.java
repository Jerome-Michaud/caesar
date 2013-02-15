package nxtim.instruction;

/**
 * Cette énumération regroupe les différents moteurs et les différentes combinaisons de moteurs.
 */
public enum Moteur {

	/**
	 * Le moteur A.
	 */
	A,
	/**
	 * Le moteur B.
	 */
	B,
	/**
	 * Le moteur C.
	 */
	C,
	/**
	 * Le moteur A avec le moteur B.
	 */
	AB,
	/**
	 * Le moteur A avec le moteur C.
	 */
	AC,
	/**
	 * Le moteur B avec le moteur C.
	 */
	BC;

	@Override
	public String toString() {
		switch (this) {
			case A:
				return "A";
			case B:
				return "B";
			case C:
				return "C";
			case AB:
				return "AB";
			case AC:
				return "AC";
			case BC:
				return "BC";
			default:
				break;
		}
		return null;
	}
}
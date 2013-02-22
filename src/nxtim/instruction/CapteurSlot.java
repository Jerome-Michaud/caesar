package nxtim.instruction;

/**
 * Cette énumération correspond aux différents slots capteurs.
 */
public enum CapteurSlot {

	/**
	 * Les slots des différents capteurs.
	 */
	A, B, C, D;

	@Override
	public String toString() {
		switch (this) {
			case A:
				return "Port 1";
			case B:
				return "Port 2";
			case C:
				return "Port 3";
			case D:
				return "Port 4";
			default:
				return null;
		}
	}
}

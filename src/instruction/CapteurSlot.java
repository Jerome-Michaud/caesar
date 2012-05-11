package instruction;

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
				return "Slot A";
			case B:
				return "Slot B";
			case C:
				return "Slot C";
			case D:
				return "Slot D";
			default:
				return null;
		}
	}
}

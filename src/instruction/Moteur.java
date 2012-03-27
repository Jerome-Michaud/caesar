package instruction;

import java.util.Collections;

/**
 * Cette énumération correspond aux différents moteurs
 *
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public enum Moteur {

	A, B, C;

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

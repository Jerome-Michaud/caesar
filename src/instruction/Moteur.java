package instruction;

/**
 * Cette énumération correspond aux différents moteurs
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public enum Moteur {
	A,B,C,D;

	public String toString(){
		switch (this){
		case A : return "Moteur A";
		case B : return "Moteur B";
		case C : return "Moteur C";
		case D : return "Moteur D";
		}
		return null;
	}
}


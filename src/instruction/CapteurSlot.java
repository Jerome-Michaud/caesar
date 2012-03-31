package instruction;

/**
 * Cette énumération correspond aux différents slot capteurs.
 * @author Bastien AUBRY
 */
public enum CapteurSlot {
	A,B,C,D;

	public String toString(){
		switch (this){
		case A : return "Slot A";
		case B : return "Slot B";
		case C : return "Slot C";
		case D : return "Slot D";
		}
		return null;
	}
}

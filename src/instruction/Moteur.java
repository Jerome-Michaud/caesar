package instruction;

public enum Moteur {A,B,C,D;

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


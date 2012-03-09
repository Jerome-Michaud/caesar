package instruction;

public enum TypeOperation {

	//ADDITION,SUBSTRACTION,MULTIPLICATION,DIVISION,CONJONCTION,DISJONCTION,NEGATION
	AFF,ADD,SUB,MUL,DIV,ET,OU,NON,XOR,SUPERIEUR,INFERIEUR,EGALE;
	
	public String toString(){
		switch (this) {
		case AFF:
			return "=";
		case ADD:
			return "+";
		case SUB:
			return "-";
		case MUL:
			return "*";
		case DIV:
			return "/";
		case ET:
			return "&&";
		case OU:
			return "||";
		case NON:
			return "~";
		case XOR:
			return "^";
		case SUPERIEUR:
			return ">";
		case INFERIEUR:
			return "<";
		case EGALE:
			return "==";	
		default:
			return "";
		}
	}
	
}

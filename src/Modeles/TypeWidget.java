package Modeles;

public enum TypeWidget {

	INSTRUCTION, IF, WHILE, NEGATION, TACHE, DOWHILE, IFELSE, MOTEURMOVFWD, MOTEURMOVREV, MOTEUROFF, REPEAT, FOR, WAIT;

	public String toString() {
		switch (this) {
			case INSTRUCTION:
				return "Instruction";
			case NEGATION:
				return "Négation";
			case IF:
				return "If";
			case WHILE:
				return "While";
			case TACHE:
				return "Tâche";
			case DOWHILE:
				return "Do ... While";
			case IFELSE:
				return "If ... Else";
			case MOTEURMOVFWD:
				return "Moteur avance";
			case MOTEURMOVREV:
				return "Moteur recule";
			case MOTEUROFF:
				return "Moteur off";
			case REPEAT:
				return "Repeat";
			case FOR:
				return "For";
			case WAIT:
				return "Wait";
			default:
				return null;
		}
	}
}

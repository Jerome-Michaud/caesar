package Modeles;

public enum TypeWidget {

	INSTRUCTION, IF, WHILE, NEGATION, TACHE, DOWHILE, IFELSE;

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
			default:
				return null;
		}
	}
}

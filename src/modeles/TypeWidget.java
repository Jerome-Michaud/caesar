package modeles;

public enum TypeWidget {

	/**
	 * Les différents types de widget.
	 */
	INSTRUCTION, IF, WHILE, NEGATION, TACHE, DOWHILE, IFELSE, MOTEURMOVFWD, MOTEURMOVREV, MOTEUROFF, REPEAT, FOR, WAIT, VARIABLE, EXPRESSION, SETVALUEVARIABLE;

	@Override
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
			case VARIABLE:
				return "Variable";
			case SETVALUEVARIABLE:
				return "SetValueVariable";
			case EXPRESSION:
				return "Expression";


			default:
				return null;
		}
	}
}
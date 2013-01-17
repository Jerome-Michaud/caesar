package jscratch.vue.widget.modele;

public enum TypeModeleWidget {

	/**
	 * Les différents types de widget.
	 */
	INSTRUCTION, IF, WHILE, NEGATION, TACHE, DOWHILE, IFELSE, MOTEURMARCHE, TEMPSCOURANT, MOTEUROFF, REPEAT, FOR, WAIT, VARIABLE, SETVALUEVARIABLE, EXPRESSION_LOGIQUE, EXPRESSION_ARITHMETIQUE;

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
		case MOTEURMARCHE:
			return "Moteur marche";
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
			return "Set Value Variable";
		case EXPRESSION_LOGIQUE:
			return "Expression Logique";  
		case EXPRESSION_ARITHMETIQUE:
			return "Expression Arithmetique";
		case TEMPSCOURANT:
			return "Temps Courant";
		default:
			return null;
		}
	}
}

package jscratch.vue.widgets.modeles;

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
			return "Si";
		case WHILE:
			return "TantQue";
		case TACHE:
			return "Tache";
		case DOWHILE:
			return "FaireTantQue";
		case IFELSE:
			return "SiSinon";
		case MOTEURMARCHE:
			return "MoteurMarche";
		case MOTEUROFF:
			return "MoteurArret";
		case REPEAT:
			return "Repeter";
		case FOR:
			return "Pour";
		case WAIT:
			return "Attendre";
		case VARIABLE:
			return "Variable";
		case SETVALUEVARIABLE:
			return "AffecterA";
		case EXPRESSION_LOGIQUE:
			return "ExpressionLogique";  
		case EXPRESSION_ARITHMETIQUE:
			return "ExpressionArithmetique";
		case TEMPSCOURANT:
			return "TempsCourant";
		default:
			return null;
		}
	}
}
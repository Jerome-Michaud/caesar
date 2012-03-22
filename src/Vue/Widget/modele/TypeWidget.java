/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Widget.modele;

/**
 *
 * @author quentin
 */
public enum TypeWidget {

    INSTRUCTION, IF, WHILE, NEGATION, DOWHILE, IFELSE, TACHE;

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
	    case DOWHILE:
	    return "DoWhile";
	    case IFELSE:
		return "IfElse";
	    case TACHE:
		return "Tache";
	    default:
		return null;
	}
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Widget;

/**
 *
 * @author quentin
 */
public enum TypeWidget {

    INSTRUCTION, IF, WHILE, NEGATION;

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
	    default:
		return null;
	}
    }
}

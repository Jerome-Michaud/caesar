/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.tools;

/**
 *
 * @author Quentin
 */
public enum TypeAction {

    DESSUS, DESSOUS, ACCROCHE, INTERNE, RIEN;

    public int toInt() {
        switch (this) {
            case DESSUS:
                return 1;
            case DESSOUS:
                return 0;
            case ACCROCHE:
                return 2;
            case INTERNE:
                return 3;
            default:
                return -1;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case DESSUS:
                return "1";
            case DESSOUS:
                return "0";
            case ACCROCHE:
                return "2";
            case INTERNE:
                return "3";
            default:
                return "Erreur";
        }
    }
}

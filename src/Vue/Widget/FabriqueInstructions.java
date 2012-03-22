/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue.Widget;

/**
 *
 * @author Bastien
 */
public class FabriqueInstructions {

    public Widget creerWidgetInstruction(){
        return new WidgetInstruction(new ModeleWidget());
    }
    
    public Widget creerWidgetIf(){
        return new WidgetTexte(new ModeleWidget(), 10, 10);
    }

}

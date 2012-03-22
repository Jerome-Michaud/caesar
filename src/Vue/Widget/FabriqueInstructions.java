/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue.Widget;

import Vue.Widget.modele.IfWidget;
import Vue.Widget.modele.ModeleWidget;
import Vue.Widget.modele.WhileWidget;

/**
 *
 * @author Bastien
 */
public class FabriqueInstructions {

    public Widget creerWidgetWhile(){
        return new WidgetInstruction(new WhileWidget());
    }
    
    public Widget creerWidgetIf(){
        return new WidgetTexte(new IfWidget(), 10, 10);
    }

}

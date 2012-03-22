package Vue.Widget;

import Vue.Widget.modele.IfWidget;
import Vue.Widget.modele.WhileWidget;

public class FabriqueInstructions {

    public Widget creerWidgetWhile(){
        return new Widget(new WhileWidget());
    }
    
    public Widget creerWidgetIf(){
        return new WidgetTexte(new IfWidget(), 10, 10);
    }

}

package Vue.Widget;

import Vue.Widget.Texte.WidgetTexte;
import java.util.LinkedList;
import java.util.List;

public class WidgetDeroulantCompose extends WidgetTexte {
    private List<Widget> lesFils;
    
    public WidgetDeroulantCompose(ModeleWidget modele, int x, int y) {
	super(modele, x, y);
	this.lesFils = new LinkedList<Widget>();
    }
    
    public boolean ajouterWidget(Widget widget){
        return this.lesFils.add(widget);
    }

    public boolean supprimerWidget(Widget widget){
        return this.lesFils.remove(widget);
    }
}

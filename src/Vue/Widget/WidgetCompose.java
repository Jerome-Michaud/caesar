package Vue.Widget;

import java.util.LinkedList;
import java.util.List;

public class WidgetCompose extends Widget {
    private List<Widget> lesFils;
    
    public WidgetCompose(ModeleWidget comp){
        super(comp);
	this.lesFils = new LinkedList<Widget>();
    }

    public boolean ajouterWidget(Widget widget){
        return this.lesFils.add(widget);
    }

    public boolean supprimerWidget(Widget widget){
        return this.lesFils.remove(widget);
    }

}

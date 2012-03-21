package Vue.Widget.Texte;

import Vue.Tools.IntegerTextField;
import Vue.Widget.ModeleWidget;
import Vue.Widget.Widget;

public class WidgetTexte extends Widget {
    private IntegerTextField zone;
    
    public WidgetTexte(ModeleWidget modele, int xTexte, int yTexte) {
	super(modele);
	this.setLayout(null);
	
	this.zone = new IntegerTextField();
	this.zone.setBounds(xTexte, yTexte, 20, 20);
	this.add(this.zone);
    }
    
    
    public int getValeur() {
	return this.zone.getInt();
    }
    
    public void setValeur(int v) {
	this.zone.setInt(v);
    }
}

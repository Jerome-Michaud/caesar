package Vue.Categories;

import Vue.Interface.PanelWidget;
import Vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieInstruction extends BoutonCategorie {
		
	public BoutonCategorieInstruction() {
		super(new ModeleCategorie("Instructions", Color.BLUE));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetInstruction());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetTache());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(Color.BLUE);
		}
	}
}

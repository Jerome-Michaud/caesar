package vue.categories;

import vue.Interface.PanelWidget;
import vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieInstruction extends BoutonCategorie {
		
	public BoutonCategorieInstruction() {
		super(new ModeleCategorie("Instructions", new Color(0,61,245)));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetTache());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetWait());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(0,61,245));
		}
	}
}

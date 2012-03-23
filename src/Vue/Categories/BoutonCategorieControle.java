package Vue.Categories;

import Vue.Interface.PanelWidget;
import Vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieControle extends BoutonCategorie {

	public BoutonCategorieControle() {
		super(new ModeleCategorie("Contrôle", Color.YELLOW));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetWhile());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetDoWhile());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIf());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIfElse());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(Color.YELLOW);
		}
	}
}

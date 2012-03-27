package Vue.Categories;

import Vue.Interface.PanelWidget;
import Vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieControle extends BoutonCategorie {

	public BoutonCategorieControle() {
		super(new ModeleCategorie("Contrôle", new Color(255,153,0)));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetFor());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetRepeat());
		//
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetWhile());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetDoWhile());
		//
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIf());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIfElse());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(255,153,0));
		}
	}
}

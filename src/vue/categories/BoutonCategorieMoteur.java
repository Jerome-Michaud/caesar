package vue.categories;

import vue.ginterface.PanelWidget;
import vue.widget.Widget;

import java.awt.Color;

public class BoutonCategorieMoteur extends BoutonCategorie {

	public BoutonCategorieMoteur() {
		super(new ModeleCategorie("Moteur", new Color(51,153,0)));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurMovFwd());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurMovRev());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurOff());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(51,153,0));
		}
	}
}

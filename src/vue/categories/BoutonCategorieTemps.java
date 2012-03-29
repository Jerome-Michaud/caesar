package vue.categories;

import vue.widget.Widget;

import java.awt.Color;

public class BoutonCategorieTemps extends BoutonCategorie {

	public BoutonCategorieTemps() {
		super(new ModeleCategorie("Temps", new Color(0,179,214)));
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(0,179,214));
		}
	}
}

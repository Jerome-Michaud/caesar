package Vue.Categories;

import Vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieMoteur extends BoutonCategorie {

	public BoutonCategorieMoteur() {
		super(new ModeleCategorie("Moteur", Color.GREEN));
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(Color.GREEN);
		}
	}
}

package Vue.Categories;

import Vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieAffichage extends BoutonCategorie {

	public BoutonCategorieAffichage() {
		super(new ModeleCategorie("Affichage", Color.RED));
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(Color.RED);
		}
	}
}

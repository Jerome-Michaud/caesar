package Vue.Categories;

import Vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieIO extends BoutonCategorie {

	public BoutonCategorieIO() {
		super(new ModeleCategorie("I/O", Color.ORANGE));
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(Color.ORANGE);
		}
	}
}

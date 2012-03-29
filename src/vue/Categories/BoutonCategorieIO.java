package vue.Categories;

import vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieIO extends BoutonCategorie {

	public BoutonCategorieIO() {
		super(new ModeleCategorie("I/O", new Color(102,51,204)));
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(102,51,204));
		}
	}
}

package vue.Categories;

import vue.Widget.Widget;
import java.awt.Color;

public class BoutonCategorieAffichage extends BoutonCategorie {


	
	public BoutonCategorieAffichage() {
		
		super(new ModeleCategorie("Affichage",new Color(204,51,0)));
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(204,51,0));
		}
	}
}

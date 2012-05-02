package vue.categories;

import vue.widget.Widget;
import java.awt.Color;
/**
 * Classe permettant l'instanciation du bouton catégorie "Affichage".
 * 
 * @since 1.0
 * @version 1.0
 */
public class BoutonCategorieAffichage extends BoutonCategorie {
	public BoutonCategorieAffichage() {
		
		super(new ModeleCategorie("Affichage", new Color(204, 51, 0)));
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(204, 51, 0));
		}
	}
}

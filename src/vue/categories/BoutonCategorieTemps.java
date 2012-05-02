package vue.categories;

import vue.widget.Widget;
import java.awt.Color;
/**
 * Classe permettant l'instanciation du bouton catégorie "Temps".
 * 
 * @since 1.0
 * @version 1.0
 */
public class BoutonCategorieTemps extends BoutonCategorie {
	public BoutonCategorieTemps() {
		super(new ModeleCategorie("Temps", new Color(0, 179, 214)));
		
		for(Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(0, 179, 214));
		}
	}
}

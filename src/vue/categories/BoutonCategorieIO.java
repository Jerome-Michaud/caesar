package vue.categories;

import vue.widget.Widget;
import java.awt.Color;
/**
 * Classe permettant l'instanciation du bouton catégorie "Entrée/Sortie".
 * 
 * @since 1.0
 * @version 1.0
 */
public class BoutonCategorieIO extends BoutonCategorie {

	public BoutonCategorieIO() {
		super(new ModeleCategorie("I/O", new Color(102, 51, 204)));
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(102, 51, 204));
		}
	}
}

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

	/**
	 * Quantité des différentes couleurs.
	 */
	private static final int ROUGE = 204, VERT = 51, BLEU = 0;

	/**
	 * Définit le bouton catégorie
	 * <code>Affichage</code>.
	 */
	public BoutonCategorieAffichage() {

		super(new ModeleCategorie("Affichage", new Color(ROUGE, VERT, BLEU)));

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}

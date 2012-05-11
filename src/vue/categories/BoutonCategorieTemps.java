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

	/**
	 * Quantité des différentes couleurs.
	 */
	private static final int ROUGE = 0, VERT = 179, BLEU = 214;

	/**
	 * Définit le bouton catégorie
	 * <code>Temps</code>.
	 */
	public BoutonCategorieTemps() {
		super(new ModeleCategorie("Temps", new Color(ROUGE, VERT, BLEU)));

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}
package vue.categories;

import vue.widget.Widget;
import java.awt.Color;

/**
 * Classe permettant l'instanciation du bouton catégorie "Entrée/Sortie".
 *
 * @since 1.0
 * @version 1.0
 */
public class BoutonCategorieCapteur extends BoutonCategorie {

	/**
	 * Quantité des différentes couleurs.
	 */
	private static final int ROUGE = 102, VERT = 51, BLEU = 204;

	/**
	 * Définit le bouton catégorie
	 * <code>I/O</code>.
	 */
	public BoutonCategorieCapteur() {
		super(new ModeleCategorie("Capteurs", new Color(ROUGE, VERT, BLEU)));

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}

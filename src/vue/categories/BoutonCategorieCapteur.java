package vue.categories;

import nxtim.instruction.Categorie;

/**
 * Classe permettant l'instanciation du bouton catégorie "Entrée/Sortie".
 *
 * @since 1.0
 * @version 1.0
 */
public class BoutonCategorieCapteur extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>I/O</code>.
	 */
	public BoutonCategorieCapteur() {
		super(new ModeleCategorie(Categorie.CAPTEURS));
	}
}

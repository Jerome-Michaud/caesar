package vue.categories;

import nxtim.instruction.Categorie;

/**
 * Classe permettant l'instanciation du bouton catégorie "Temps".
 *
 * @since 1.0
 * @version 1.0
 */
public class BoutonCategorieTemps extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>Temps</code>.
	 */
	public BoutonCategorieTemps() {
		super(new ModeleCategorie(Categorie.TEMPS));
	}
}
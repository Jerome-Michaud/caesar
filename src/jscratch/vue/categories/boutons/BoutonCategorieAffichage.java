package jscratch.vue.categories.boutons;

import jscratch.vue.categories.ModeleCategorie;
import nxtim.instruction.Categorie;

/**
 * Classe permettant l'instanciation du bouton catégorie "Affichage".
 *
 * @since 1.0
 * @version 1.0
 */
public class BoutonCategorieAffichage extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>Affichage</code>.
	 */
	public BoutonCategorieAffichage() {
		super(new ModeleCategorie(Categorie.AFFICHAGE));
	}

	@Override
	public int getNbColonnes() {
		return 1;
	}
}

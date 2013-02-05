package jscratch.vue.categories.boutons;

import jscratch.vue.categories.ModeleCategorie;
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

	@Override
	public int getNbColonnes() {
		return 1;
	}

	@Override
	public void ajouterWidgets() {
		
	}
}

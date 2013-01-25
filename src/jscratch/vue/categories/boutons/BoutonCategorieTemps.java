package jscratch.vue.categories.boutons;

import jscratch.modeles.DicoWidgetsCategories;
import jscratch.vue.categories.ModeleCategorie;
import jscratch.vue.ginterface.GUI;
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
		
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.TEMPS, GUI.getPanelWidget().getFabrique().creerWidgetWait());
	}

	@Override
	public int getNbColonnes() {
		return 1;
	}
}
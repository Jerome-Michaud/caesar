package jscratch.vue.categories.boutons;

import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.vue.categories.ModeleCategorie;
import jscratch.vue.ginterface.principales.GUI;
import nxtim.instruction.Categorie;
import nxtim.instruction.Operateur;

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
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.CAPTEURS, GUI.getPanelWidget().getFabrique().creerWidgetCapteur());
	}
}

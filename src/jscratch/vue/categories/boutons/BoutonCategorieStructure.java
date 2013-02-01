package jscratch.vue.categories.boutons;

import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.vue.categories.ModeleCategorie;
import nxtim.instruction.Categorie;
import jscratch.vue.ginterface.principales.GUI;

/**
 * Classe permettant l'instanciation du bouton catégorie "Contôles".
 *
 * @since 1.0
 * @version 1.0
 */
public class BoutonCategorieStructure extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>Contrôle</code>.
	 */
	public BoutonCategorieStructure() {
		super(new ModeleCategorie(Categorie.STRUCTURES));

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetTache());
		
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetRepeat());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetFor());
		
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetWhile());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetDoWhile());

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetIf());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetIfElse());
	}

	@Override
	public int getNbColonnes() {
		return 1;
	}
}

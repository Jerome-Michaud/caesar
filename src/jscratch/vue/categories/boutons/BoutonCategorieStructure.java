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
	}

	@Override
	public int getNbColonnes() {
		return 1;
	}

	@Override
	public void ajouterWidgets() {
		DicoWidgetsCategories d = DicoWidgetsCategories.getInstance();
		d.ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetTache());
		
		d.ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetRepeat());
		d.ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetFor());
		
		d.ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetWhile());
		d.ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetDoWhile());

		d.ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetIf());
		d.ajouterWidget(Categorie.STRUCTURES, GUI.getPanelWidget().getFabrique().creerWidgetIfElse());
	}
}

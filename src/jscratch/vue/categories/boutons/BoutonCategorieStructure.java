package jscratch.vue.categories.boutons;

import jscratch.modeles.DicoWidgetsCategories;
import jscratch.vue.categories.ModeleCategorie;
import nxtim.instruction.Categorie;
import jscratch.vue.ginterface.GUI;

/**
 * Classe permettant l'instanciation du bouton catégorie "Contôles".
 *
 * @since 1.0
 * @version
 * Historique des versions :<br />
 * <ul>
 * <li>
 * 1.0 : 6 widgets disponibles :
 * <ul>
 * <li>For</li>
 * <li>Repeat</li>
 * <li>While</li>
 * <li>Do ... While</li>
 * <li>If</li>
 * <li>If ... Else</li>
 * <ul>
 * </li>
 * <ul>
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

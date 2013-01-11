package vue.categories;

import modeles.DicoWidgetsCategories;
import nxtim.instruction.Categorie;
import vue.ginterface.GUI;

/**
 * Classe permettant l'instanciation du bouton catégorie "Instructions".
 *
 * @since 1.0
 * @version
 * Historique des versions :<br />
 * <ul>
 * <li>
 * 1.0 : 2 widgets disponibles :
 * <ul>
 * <li>Tâche</li>
 * <li>Attendre</li>
 * <ul>
 * </li>
 * <ul>
 */
public class BoutonCategorieInstruction extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>Instructions</code>.
	 */
	public BoutonCategorieInstruction() {
		super(new ModeleCategorie(Categorie.INSTRUCTION));

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.INSTRUCTION, GUI.getPanelWidget().getFabrique().creerWidgetTache());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.INSTRUCTION, GUI.getPanelWidget().getFabrique().creerWidgetWait());
	}
}
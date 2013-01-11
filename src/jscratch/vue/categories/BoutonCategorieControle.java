package jscratch.vue.categories;

import jscratch.modeles.DicoWidgetsCategories;
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
public class BoutonCategorieControle extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>Contrôle</code>.
	 */
	public BoutonCategorieControle() {
		super(new ModeleCategorie(Categorie.CONTROLE));

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.CONTROLE, GUI.getPanelWidget().getFabrique().creerWidgetFor());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.CONTROLE, GUI.getPanelWidget().getFabrique().creerWidgetRepeat());

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.CONTROLE, GUI.getPanelWidget().getFabrique().creerWidgetWhile());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.CONTROLE, GUI.getPanelWidget().getFabrique().creerWidgetDoWhile());

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.CONTROLE, GUI.getPanelWidget().getFabrique().creerWidgetIf());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.CONTROLE, GUI.getPanelWidget().getFabrique().creerWidgetIfElse());
	}
}

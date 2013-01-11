package jscratch.vue.categories;

import jscratch.vue.categories.complexe.ModeleCategorieVariable;

import jscratch.modeles.DicoWidgetsCategories;
import nxtim.instruction.Categorie;
import jscratch.vue.ginterface.GUI;

/**
 *
 * @author zubair
 */
public class BoutonCategorieVariable extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>Instructions</code>.
	 */
	public BoutonCategorieVariable() {
		super(new ModeleCategorieVariable(Categorie.VARIABLES));

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.VARIABLES, GUI.getPanelWidget().getFabrique().creerWidgetVariableSetValue());
	}
}

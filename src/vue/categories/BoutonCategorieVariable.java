package vue.categories;

import vue.categories.complexe.ModeleCategorieVariable;

import modeles.DicoWidgetsCategories;
import nxtim.instruction.Categorie;
import vue.ginterface.GUI;

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

package jscratch.vue.categories.boutons;

import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.helpers.PropertiesHelper;
import jscratch.vue.categories.ModeleCategorie;
import jscratch.vue.ginterface.principales.GUI;

import nxtim.instruction.Categorie;

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
		super(new ModeleCategorie(Categorie.VARIABLES));
		
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.VARIABLES, GUI.getPanelWidget().getFabrique().creerWidgetVariableSetValue());
	}

	@Override
	public int getNbColonnes() {
		return 2;
	}
}

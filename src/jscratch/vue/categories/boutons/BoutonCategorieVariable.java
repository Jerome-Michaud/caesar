package jscratch.vue.categories.boutons;

import jscratch.modeles.DicoWidgetsCategories;
import jscratch.vue.categories.ModeleCategorie;
import jscratch.vue.ginterface.GUI;

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

package jscratch.vue.categories.boutons;

import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.vue.categories.ModeleCategorie;
import nxtim.instruction.Categorie;
import nxtim.instruction.Operateur;

import jscratch.vue.ginterface.principales.GUI;

/**
 *
 * @author zubier, houda
 */
public class BoutonCategorieExpression extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>Instructions</code>.
	 */
	public BoutonCategorieExpression() {
		super(new ModeleCategorie(Categorie.EXPRESSIONS));
	}

	@Override
	public int getNbColonnes() {
		return 2;
	}

	@Override
	public void ajouterWidgets() {
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetIncPlus());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetIncMoins());
		
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.ADDITION));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.DIVISION));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.MULTIPLICATION));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.SOUSTRACTION));
		
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.OU));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPEGAL));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPERIEUR));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.INFERIEUR));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.ET));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.EGALITE));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.INFEGAL));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSIONS, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPEGAL));
	}
}

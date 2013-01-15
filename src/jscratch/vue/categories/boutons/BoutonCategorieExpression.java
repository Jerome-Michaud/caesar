package jscratch.vue.categories.boutons;

import jscratch.modeles.DicoWidgetsCategories;
import jscratch.vue.categories.ModeleCategorie;
import nxtim.instruction.Categorie;
import nxtim.instruction.Operateur;

import jscratch.vue.ginterface.GUI;

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
		super(new ModeleCategorie(Categorie.EXPRESSION));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.ADDITION));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.DIVISION));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.MULIPLICATION));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.SOUSTRACTION));

		/*
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.OU, null));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPEGAL, null));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPERIEUR, null));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.INFERIEUR, null));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.ET, null));

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.EGALITE, null));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.INFEGAL, null));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPEGAL, null));
		*/
		
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.OU));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPEGAL));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPERIEUR));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.INFERIEUR));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.ET));

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.EGALITE));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.INFEGAL));
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.EXPRESSION, GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPEGAL));
	}

	@Override
	public int getNbColonnes() {
		return 2;
	}
}

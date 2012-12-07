/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.categories;

import java.awt.Color;

import vue.ginterface.GUI;
import vue.ginterface.PanelWidget;
import vue.widget.Widget;

/**
 *
 * @author zubier, houda 
 */
public class BoutonCategorieExpression extends BoutonCategorie {
	/**
	 * Quantité des différentes couleurs.
	 */
	private static final int ROUGE = 255, VERT = 189, BLEU = 0;

	/**
	 * Définit le bouton catégorie
	 * <code>Instructions</code>.
	 */
	public BoutonCategorieExpression() {
		super(new ModeleCategorie("Expression", new Color(ROUGE, VERT, BLEU)));


		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionSum());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionSubtraction());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionMultiplication());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionDivision());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionModulus());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionOR());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionAND());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionEqualTO());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionNEqualTO());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionOperatorSup());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionOperatorInf());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionOperatorSupEqual());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionOperatorInfEqual());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}

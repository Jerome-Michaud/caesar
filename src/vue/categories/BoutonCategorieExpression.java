package vue.categories;

import java.awt.Color;
import nxtim.instruction.Operateur;

import vue.ginterface.GUI;
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



		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.ADDITION));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.DIVISION));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.MULIPLICATION));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionArithmetic(Operateur.SOUSTRACTION));

		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.OU));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPEGAL));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPERIEUR));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.INFERIEUR));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.ET));

		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.EGALITE));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.INFEGAL));
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetExpressionLogical(Operateur.SUPEGAL));

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}

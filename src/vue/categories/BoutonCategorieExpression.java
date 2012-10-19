/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.categories;

import java.awt.Color;
import vue.ginterface.PanelWidget;
import vue.widget.Widget;

/**
 *
 * @author zubi
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

		/*this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetTache());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetWait());*/

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}

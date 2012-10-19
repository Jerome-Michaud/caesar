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
public class BoutonCategorieVariable extends BoutonCategorie {
    /**
	 * Quantité des différentes couleurs.
	 */
	private static final int ROUGE = 212, VERT = 82, BLEU = 144;

	/**
	 * Définit le bouton catégorie
	 * <code>Instructions</code>.
	 */
	public BoutonCategorieVariable() {
		super(new ModeleCategorie("Variable", new Color(ROUGE, VERT, BLEU)));


		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetVariable());

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}

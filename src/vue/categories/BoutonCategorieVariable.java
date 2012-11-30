/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.categories;

import vue.categories.complexe.ModeleCategorieVariable;
import java.awt.Color;
import vue.ginterface.GUI;
import vue.widget.Widget;

/**
 *
 * @author zubair
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
		super(new ModeleCategorieVariable("Variable", new Color(ROUGE, VERT, BLEU)));

	}
}

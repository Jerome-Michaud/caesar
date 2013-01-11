package vue.categories;

import vue.categories.complexe.ModeleCategorieVariable;
import instruction.IElementProgramme;
import instruction.Variable;

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

		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetVariableSetValue());
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}

	}

	/**
	 * Supprime une varaible widget
	 *
	 * @param variableWidget
	 */
	public void supprimerWidgetVariable(String variableWidget) {
		Widget wid = null;
		for (Widget w : this.getLesWidgets()) {
			IElementProgramme elem = w.getElementProgramme();

			if (elem instanceof Variable) {
				Variable var = (Variable) elem;
				if (var.getNom().equals(variableWidget)) {
					wid = w;
				}
			}
		}
		this.getLesWidgets().remove(wid);
		this.getLesWidgets().remove(variableWidget);
		GUI.getPanelWidget().setLesWidgets(this.getLesWidgets());

	}
}

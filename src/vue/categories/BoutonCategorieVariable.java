/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.categories;

import vue.categories.complexe.ModeleCategorieVariable;
import instruction.Variable;

import java.awt.Color;
import vue.ginterface.GUI;
import vue.widget.Widget;
import vue.widget.modele.VariableWidget;

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
	/**
	 * Supprime une varaible widget
	 * @param variableWidget
	 */
	public void supprimerWidgetVariable(String variableWidget){
		Widget wid = null;
		for(Widget w: this.getLesWidgets()){
			Variable var = (Variable)w.getElementProgramme();
			if(var.getNom().equals(variableWidget)){
				wid = w;
			}
		}
		this.getLesWidgets().remove(wid);
		this.getLesWidgets().remove(variableWidget);
		GUI.getPanelWidget().setLesWidgets(this.getLesWidgets());
		
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue.Categories;

import Vue.Interface.PanelWidget;
import java.awt.Color;

/**
 *
 * @author quentin
 */
public class BoutonCategorieControle extends BoutonCategorie {

	public BoutonCategorieControle() {
		super(new ModeleCategorie("Contrôle", Color.YELLOW));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetWhile());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetDoWhile());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIf());
		//this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIfElse());
	}
}

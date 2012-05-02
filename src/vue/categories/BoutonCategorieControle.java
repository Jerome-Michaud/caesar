package vue.categories;

import vue.ginterface.PanelWidget;
import vue.widget.Widget;
import java.awt.Color;
/**
 * Classe permettant l'instanciation du bouton catégorie "Contôles".
 *
 * @since 1.0
 * @version 
 * Historique des versions :<br />
 * <ul>
 *    <li>
 *            1.0 : 6 widgets disponibles :
 *            <ul>
 *                    <li>For</li>
 *                    <li>Repeat</li>
 *                    <li>While</li>
 *                    <li>Do ... While</li>
 *                    <li>If</li>
 *                    <li>If ... Else</li>
 *            <ul>
 *    </li>
 * <ul>
 */
public class BoutonCategorieControle extends BoutonCategorie {
	public BoutonCategorieControle() {
		super(new ModeleCategorie("Contrôles", new Color(255, 153, 0)));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetFor());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetRepeat());
		//
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetWhile());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetDoWhile());
		//
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIf());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIfElse());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(255,153,0));
		}
	}
}

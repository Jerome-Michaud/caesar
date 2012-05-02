package vue.categories;

import vue.ginterface.PanelWidget;
import vue.widget.Widget;
import java.awt.Color;
/**
 * Classe permettant l'instanciation du bouton catégorie "Instructions".
 *
 * @since 1.0
 * @version 
 * Historique des versions :<br />
 * <ul>
 *    <li>
 *            1.0 : 2 widgets disponibles :
 *            <ul>
 *                    <li>Tâche</li>
 *                    <li>Attendre</li>
 *            <ul>
 *    </li>
 * <ul>
 */
public class BoutonCategorieInstruction extends BoutonCategorie {
	public BoutonCategorieInstruction() {
		super(new ModeleCategorie("Instructions", new Color(0, 61, 245)));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetTache());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetWait());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(0, 61, 245));
		}
	}
}
package vue.categories;

import vue.ginterface.PanelWidget;
import vue.widget.Widget;
import java.awt.Color;
/**
 * Classe permettant l'instanciation du bouton catégorie "Moteur".
 *
 * @since 1.0
 * @version 
 * Historique des versions :<br />
 * <ul>
 *    <li>
 *            1.0 : 3 widgets disponibles :
 *            <ul>
 *                    <li>Avancer</li>
 *                    <li>Reculer</li>
 *                    <li>Arrêter</li>
 *            <ul>
 *    </li>
 * <ul>
 */
public class BoutonCategorieMoteur extends BoutonCategorie {

	public BoutonCategorieMoteur() {
		super(new ModeleCategorie("Moteur", new Color(51, 153, 0)));
		
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurMovFwd());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurMovRev());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurOff());
		
		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(51, 153, 0));
		}
	}
}

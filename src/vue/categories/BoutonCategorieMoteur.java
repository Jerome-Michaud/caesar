package vue.categories;

import vue.ginterface.PanelWidget;
import vue.widget.Widget;
import java.awt.Color;

/**
 * Classe permettant l'instanciation du bouton catégorie "Moteur".
 *
 * @since 1.0
 * @version
 * Historique des versions :
 * <ul>
 * <li>
 * 1.0 : 3 widgets disponibles :
 * <ul>
 * <li>Avancer</li>
 * <li>Reculer</li>
 * <li>Arrêter</li>
 * <ul>
 * </li>
 * <ul>
 */
public class BoutonCategorieMoteur extends BoutonCategorie {

	/**
	 * Quantité des différentes couleurs.
	 */
	private static final int ROUGE = 51, VERT = 153, BLEU = 0;

	/**
	 * Définit le bouton catégorie
	 * <code>Moteur</code>.
	 */
	public BoutonCategorieMoteur() {
		super(new ModeleCategorie("Moteur", new Color(ROUGE, VERT, BLEU)));

		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurMovFwd());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurMovRev());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetMoteurOff());

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}
package vue.categories;

import vue.widget.Widget;
import java.awt.Color;
import vue.ginterface.GUI;

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
	private static final int ROUGE = 133, VERT = 205, BLEU = 68;

	/**
	 * Définit le bouton catégorie
	 * <code>Moteur</code>.
	 */
	public BoutonCategorieMoteur() {
		super(new ModeleCategorie("Moteur", new Color(ROUGE, VERT, BLEU)));

		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetMoteurMovFwd());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetMoteurMovRev());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetMoteurOff());

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}
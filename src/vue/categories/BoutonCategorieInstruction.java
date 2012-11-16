package vue.categories;

import vue.widget.Widget;
import java.awt.Color;
import vue.ginterface.GUI;

/**
 * Classe permettant l'instanciation du bouton catégorie "Instructions".
 *
 * @since 1.0
 * @version
 * Historique des versions :<br />
 * <ul>
 * <li>
 * 1.0 : 2 widgets disponibles :
 * <ul>
 * <li>Tâche</li>
 * <li>Attendre</li>
 * <ul>
 * </li>
 * <ul>
 */
public class BoutonCategorieInstruction extends BoutonCategorie {

	/**
	 * Quantité des différentes couleurs.
	 */
	private static final int ROUGE = 0, VERT = 107, BLEU = 242;

	/**
	 * Définit le bouton catégorie
	 * <code>Instructions</code>.
	 */
	public BoutonCategorieInstruction() {
		super(new ModeleCategorie("Instructions", new Color(ROUGE, VERT, BLEU)));

		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetTache());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetWait());

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}
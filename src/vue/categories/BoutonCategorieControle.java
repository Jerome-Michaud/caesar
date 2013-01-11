package vue.categories;

import vue.widget.Widget;
import java.awt.Color;
import vue.ginterface.GUI;

/**
 * Classe permettant l'instanciation du bouton catégorie "Contôles".
 *
 * @since 1.0
 * @version
 * Historique des versions :<br />
 * <ul>
 * <li>
 * 1.0 : 6 widgets disponibles :
 * <ul>
 * <li>For</li>
 * <li>Repeat</li>
 * <li>While</li>
 * <li>Do ... While</li>
 * <li>If</li>
 * <li>If ... Else</li>
 * <ul>
 * </li>
 * <ul>
 */
public class BoutonCategorieControle extends BoutonCategorie {

	/**
	 * Quantité des différentes couleurs.
	 */
	private static final int ROUGE = 230, VERT = 126, BLEU = 77;

	/**
	 * Définit le bouton catégorie
	 * <code>Contrôle</code>.
	 */
	public BoutonCategorieControle() {
		super(new ModeleCategorie("Contrôles", new Color(ROUGE, VERT, BLEU)));

		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetFor());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetRepeat());

		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetWhile());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetDoWhile());

		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetIf());
		this.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetIfElse());

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}

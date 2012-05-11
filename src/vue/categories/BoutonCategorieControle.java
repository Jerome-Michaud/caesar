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
	private static final int ROUGE = 255, VERT = 153, BLEU = 0;
	
	/**
	 * Définit le bouton catégorie <code>Contrôle</code>.
	 */
	public BoutonCategorieControle() {
		super(new ModeleCategorie("Contrôles", new Color(ROUGE, VERT, BLEU)));

		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetFor());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetRepeat());
		//
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetWhile());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetDoWhile());
		//
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIf());
		this.ajouterUnWidget(PanelWidget.getInstance().getFabrique().creerWidgetIfElse());

		for (Widget w : this.getLesWidgets()) {
			w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
		}
	}
}

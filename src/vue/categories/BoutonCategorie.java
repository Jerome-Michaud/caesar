package vue.categories;

import vue.ginterface.PanelTypeWidget;
import vue.ginterface.PanelWidget;
import vue.widget.Widget;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;

/**
 * Classe permettant de définir les différents comportements des boutons catégories.
 *
 * @since 1.0
 * @version 1.0
 */
public abstract class BoutonCategorie extends JComponent {

	/**
	 * Liste des widgets disponibles dans la catégorie.
	 */
	private List<Widget> lesWidgets;
	/**
	 * @see Vue.Categories.ModeleCategorie
	 */
	private ModeleCategorie modele;
	/**
	 * La police de caractère.
	 */
	private Font font;
	/**
	 * La couleur de fond.
	 */
	private Color fond;
	/**
	 * La position par défaut du bouton.
	 */
	private Point defaultPos;
	/**
	 * L'état du bouton <code>true</code> si activé.
	 */
	private boolean active = false;
	/**
	 * La quantité de couleur pour le changement de couleur.
	 */
	private static final int QUANTITE_COULEUR = 141;
	
	/**
	 * La taille de la police.
	 */
	private static final int TAILLE = 12;

	@Override
	public void paintComponent(final Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.modele.getCouleur());
		g2d.fillPolygon(this.modele.getFormeCouleur());
		g2d.setColor(this.fond);
		g2d.fillPolygon(this.modele.getFormeTexte());
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(this.modele.getFormeCouleur());
		g2d.drawPolygon(this.modele.getFormeTexte());
		g2d.setColor(Color.WHITE);
		g2d.setFont(this.font);
		g2d.drawString(this.modele.getMessage(), 15, 17);
		super.paintComponent(g);
	}

	/**
	 * Définit le bouton de catégorie.
	 * 
	 * @param modele le modèle du bouton
	 */
	public BoutonCategorie(final ModeleCategorie modele) {
		this.font = new Font("TimesRoman", Font.PLAIN, TAILLE);
		this.modele = modele;
		this.fond = Color.LIGHT_GRAY;
		this.setFont(this.font);
		this.setFocusable(true);
		this.setOpaque(false);
		this.setForme();
		this.lesWidgets = new LinkedList<Widget>();

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(final MouseEvent e) {
				super.mouseEntered(e);
				sourisEntree();
			}

			@Override
			public void mouseExited(final MouseEvent e) {
				super.mouseExited(e);
				sourisSortie();
			}

			@Override
			public void mouseReleased(final MouseEvent e) {
				super.mouseReleased(e);
				sourisRelachee();
			}

			@Override
			public void mousePressed(final MouseEvent e) {
				super.mousePressed(e);
				sourisAppuyee();
			}
		});
	}

	/**
	 * Calcul les bounds du composant en fonction du polygone gris.
	 *
	 * @since 1.0
	 */
	private void setForme() {
		int maxX = 0;
		for (Integer i : this.modele.getFormeTexte().xpoints) {
			maxX = Math.max(maxX, i);
		}

		int maxY = 0;
		for (Integer i : this.modele.getFormeTexte().ypoints) {
			maxY = Math.max(maxY, i);
		}

		this.setBounds(0, 0, maxX + 1, maxY + 1);
		this.setPreferredSize(new Dimension(maxX, maxY));
	}

	/**
	 * Comportement lorsque la souris est sur le bouton.
	 *
	 * @since 1.0
	 */
	private void sourisEntree() {
		if (!active) {
			this.fond = new Color(QUANTITE_COULEUR, QUANTITE_COULEUR, QUANTITE_COULEUR);
			this.repaint();
		}
	}

	/**
	 * Comportement lorsque la souris sort du bouton.
	 *
	 * @since 1.0
	 */
	private void sourisSortie() {
		if (!active) {
			this.fond = Color.LIGHT_GRAY;
			this.repaint();
		}
	}

	/**
	 * Comportement lors du relachement du clic.
	 *
	 * @since 1.0
	 */
	private void sourisRelachee() {
		this.setLocation(this.defaultPos);

		if (!active) {

			for (BoutonCategorie b : PanelTypeWidget.getInstance().getLesCategories()) {
				b.font = new Font("TimesRoman", Font.PLAIN, TAILLE);
				b.fond = Color.LIGHT_GRAY;
				b.active = false;
				b.repaint();
			}
			this.font = new Font("TimesRoman", Font.BOLD, TAILLE);
			this.active = true;
			this.fond = Color.DARK_GRAY;
			PanelWidget.getInstance().setLesWidgets(this.lesWidgets);
		}
	}

	/**
	 * Comportement lors du clic avec la souris.
	 *
	 * @since 1.0
	 */
	private void sourisAppuyee() {
		this.defaultPos = new Point(this.getLocation());
		Point p = this.getLocation();
		p.x++;
		p.y++;
		this.setLocation(p);
	}

	/**
	 * Définit si la catégorie est active ou non.
	 *
	 * @param b <code>true</code> si la catégorie est active, sinon <code>false</code>
	 */
	public void setActive(final boolean b) {
		this.active = b;
	}

	/**
	 * Récupérer les widgets de la catégorie.
	 *
	 * @return la liste des widgets de cette catégorie
	 */
	public List<Widget> getLesWidgets() {
		return this.lesWidgets;
	}

	/**
	 * Ajouter un widget dans la catégorie.
	 *
	 * @param widget le widget à ajouter dans la catégorie
	 */
	protected void ajouterUnWidget(final Widget widget) {
		this.lesWidgets.add(widget);
	}
}
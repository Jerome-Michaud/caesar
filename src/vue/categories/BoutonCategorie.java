package vue.categories;

import vue.Interface.PanelTypeWidget;
import vue.Interface.PanelWidget;
import vue.widget.Widget;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
/**
 * Classe permattant de définir les différents comportements des boutons catégories.
 * 
 * @since 1.0
 * @version 1.0
 */
public abstract class BoutonCategorie extends JComponent {

	private List<Widget> lesWidgets;
	/**
	 * @see Vue.Categories.ModeleCategorie
	 */
	private ModeleCategorie modele;
	private Font font;
	private Color fond;
	private Point defaultPos;
	private boolean active = false;

	@Override
	public void paintComponent(Graphics g) {
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

	public BoutonCategorie(ModeleCategorie modele) {
		this.font = new Font("TimesRoman", Font.PLAIN, 12);
		this.modele = modele;
		this.fond = Color.LIGHT_GRAY;
		this.setFont(this.font);
		this.setFocusable(true);
		this.setOpaque(false);
		this.setForme();
		this.lesWidgets = new LinkedList<Widget>();

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				sourisEntree();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				sourisSortie();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				sourisRelachee();
			}

			@Override
			public void mousePressed(MouseEvent e) {
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
			this.fond = new Color(141, 141, 141);
			this.repaint();
		}
	}
	/**
	 * Comportement lorsque la souris sortdu bouton.
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
				b.font = new Font("TimesRoman", Font.PLAIN, 12);
				b.fond = Color.LIGHT_GRAY;
				b.active = false;
				b.repaint();
			}
			this.font = new Font("TimesRoman", Font.BOLD, 12);
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
	 * @since 1.0
	 * 
	 * @param b true si la catégorie est active.
	 */
	public void setActive(boolean b) {
		this.active = b;
	}
	/**
	 * @since 1.0
	 * 
	 * @return La liste des widgets de cette catégorie.
	 */
	public List<Widget> getLesWidgets() {
		return this.lesWidgets;
	}
	/**
	 * @since 1.0
	 * 
	 * @param widget Le widget à ajouter dans la catégorie.
	 */
	protected void ajouterUnWidget(Widget widget) {
		this.lesWidgets.add(widget);
	}
}
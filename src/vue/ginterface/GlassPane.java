package vue.ginterface;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Permet de créer l'objet de type GlassPane.
 * @author Bastien
 * @since 1.0
 * @version 1.0
 */
public class GlassPane extends JPanel {
	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 */
	private static final GlassPane instance = new GlassPane();
	private Point pointLigne;
	public static final int EPAISSEUR_LIGNE = 5;
	private int longueurLigne;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (pointLigne != null) {
			g2d.setStroke(new BasicStroke(EPAISSEUR_LIGNE));
			g2d.drawLine(pointLigne.x, pointLigne.y, pointLigne.x + longueurLigne, pointLigne.y);
		}
	}

	private GlassPane() {
		this.pointLigne = null;
		this.longueurLigne = 0;
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
	}
	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de GlassPane.
	 */
	public static GlassPane getInstance() {
		return instance;
	}
	/**
	 * @since 1.0
	 * 
	 * @param pointLigne Le nouveau point pour l'affichage de la ligne de fusion.
	 */
	public void setPointLigneSurEcran(Point pointLigne) {
		if (pointLigne != null) {
			SwingUtilities.convertPointFromScreen(pointLigne, this);
		}
		this.pointLigne = pointLigne;
	}
	/**
	 * @since 1.0
	 * 
	 * @param epaisseur L'épaisseur voulue pour le trait de fusion.
	 */
	public void setLongueurLigne(int epaisseur) {
		this.longueurLigne = epaisseur;
	}
}

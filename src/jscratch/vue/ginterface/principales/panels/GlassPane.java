package jscratch.vue.ginterface.principales.panels;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import jscratch.helpers.ImagesHelper;

/**
 * Permet de créer l'objet de type GlassPane.
 *
 * @author Bastien
 * @since 1.0
 * @version 1.0
 */
public final class GlassPane extends JPanel implements Observer {

	/**
	 * L'instance unique du GlassPane.
	 */
	private static final GlassPane instance = new GlassPane();
	private Point pointLigne;
	private Rectangle rectFusion;
	public static final int EPAISSEUR_LIGNE = 5;
	public static final int EPAISSEUR_RECT = 3;
	public static final int MARGE_RECT = 5;
	private int longueurLigne;
	private boolean drawRemoveImage;
	private Point deleteIconPosition;
	private Image deleteImage;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if (drawRemoveImage) {
			g2d.drawImage(deleteImage, this.deleteIconPosition.x, this.deleteIconPosition.y, null);
		}
	}

	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (pointLigne != null) {
			g2d.setStroke(new BasicStroke(EPAISSEUR_LIGNE));
			g2d.drawLine(pointLigne.x, pointLigne.y, pointLigne.x + longueurLigne, pointLigne.y);
		}
		if (rectFusion != null) {
			g2d.setStroke(new BasicStroke(EPAISSEUR_RECT));
			g2d.drawRoundRect(rectFusion.x, rectFusion.y, rectFusion.width, rectFusion.height, 5, 5);
		}
	}

	/**
	 * @since 1.0
	 */
	private GlassPane() {
		this.pointLigne = null;
		this.rectFusion = null;
		this.longueurLigne = 0;
		this.deleteImage = ImagesHelper.getImage("cross-circle-big.png");
		this.setDeleteIconPosition(null);
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
	}

	/**
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
	 * @param pointLigne Le nouveau point pour l'affichage de la ligne de
	 * fusion.
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
	 * @param rectFusion Le nouveau rectangle à dessiner sur le glasspane
	 */
	public void setRectFusion(Rectangle rectFusion) {
		this.rectFusion = rectFusion;
	}

	/**
	 * @since 1.0
	 *
	 * @param epaisseur L'épaisseur voulue pour le trait de fusion.
	 */
	public void setLongueurLigne(int epaisseur) {
		this.longueurLigne = epaisseur;
	}

	@Override
	public void update(Observable o, Object o1) {
		this.repaint();
	}

	public void setDeleteIconPosition(Point pt) {
		this.drawRemoveImage = (pt != null);
		this.deleteIconPosition = pt;

	}
}

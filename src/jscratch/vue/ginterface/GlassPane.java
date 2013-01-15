package jscratch.vue.ginterface;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import jscratch.vue.tools.Variables;

/**
 * Permet de créer l'objet de type GlassPane.
 *
 * @author Bastien
 * @since 1.0
 * @version 1.0
 */
public class GlassPane extends JPanel implements Observer {

	/**
	 * Le logger du GlassPane.
	 */
	private static final Logger logger = Logger.getLogger(GlassPane.class.getName());
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

	private GlassPane() {
		logger.setLevel(Variables.LEVEL_DES_LOGGERS);

		this.pointLigne = null;
		this.rectFusion = null;
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
	protected static GlassPane getInstance() {
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
		logger.info("Observateur : Mise à jour du PanelCodeGraphique");
		this.repaint();
	}
}
package jscratch.controleur.sim;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.List;
import jscratch.modeles.sim.ColorValue;
import jscratch.modeles.sim.Map;
import jscratch.modeles.sim.Robot;
import jscratch.modeles.sim.collision.ObstacleShape;

/**
 * Controller de la map.
 *
 * @since 1.0
 * @version 1.0
 */
public class MapController {

	/**
	 * Le model de la map
	 */
	private Map map;

	/**
	 * Constructeur
	 *
	 * @param m le model de la map
	 */
	public MapController(Map m) {
		this.map = m;
	}

	/**
	 *
	 * @param robot
	 * @return
	 */
	public boolean positionPossible(Robot robot) {
		for (ObstacleShape obs : map.getObstacles()) {
			for (Point2D p : robot.getPoints()) {
				if (obs.getShape().contains(p)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Savoir si un point est dans un obstacle
	 *
	 * @param point le point
	 * @return vrai si le point est contenu dans un obstacle, faux sinon
	 */
	public boolean pointInObstacle(Point2D point) {
		for (ObstacleShape obs : map.getObstacles()) {
			if (obs.getShape().contains(point)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Récupérer la couleur d'un point dans la map pour le capteur de couleur
	 *
	 * @param point le point dans la map
	 * @return la couleur la plus proche dans ColorValue
	 */
	public ColorValue getColorValue(Point2D point) {
		Color color = new Color(map.getImageMap().getRGB((int) point.getX(), (int) point.getY()));
		return ColorValue.getSimilarColor(color);
	}

	/**
	 * Récupérer la distance entre un obstacle et le robot
	 *
	 * @param point le point dans la map
	 * @return la couleur la plus proche dans ColorValue
	 */
	public Integer getDistanceSonic(List<Point2D> listPoint) {
		return null;
	}

	/**
	 * Récupérer la couleur RGB d'un point dans la map
	 *
	 * @param point le point dans la map
	 * @return la couleur
	 */
	public Color getColorRGB(Point2D point) {
		return new Color(map.getImageMap().getRGB((int) point.getX(), (int) point.getY()));
	}

	/**
	 * Test si le déplacement du robot est bien dans la map
	 *
	 * @param point le point à tester
	 * @return vrai si le point est à l'intérieur de la map
	 */
	public boolean pointDeplacementRobot(Point2D point) {
		if (point.getX() < 0 || point.getX() >= map.getTailleX() - 34 || point.getY() < 0 || point.getY() >= map.getTailleY() - 40) {
			return false;
		} else {
			return true;
		}
	}
}
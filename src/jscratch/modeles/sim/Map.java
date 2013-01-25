package jscratch.modeles.sim;

import java.awt.image.BufferedImage;
import java.util.List;

import jscratch.modeles.sim.collision.ObstacleShape;


/**
 * Classe qui représente la map
 * @author Guillaume Delorme
 *
 */
public class Map {
	/**
	 * Image de fond de la map
	 */
	private BufferedImage imageMap;
	
	private List<ObstacleShape> obstacles;
	
	public Map(BufferedImage imageMap, List<ObstacleShape> obstacles) {
		super();
		this.imageMap = imageMap;
		this.obstacles = obstacles;
	}

	public BufferedImage getImageMap() {
		return imageMap;
	}

	public List<ObstacleShape> getObstacles() {
		return obstacles;
	}	
}

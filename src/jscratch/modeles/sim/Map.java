package jscratch.modeles.sim;

import java.awt.image.BufferedImage;
import java.util.List;

import jscratch.modeles.sim.collision.CouleurObstacle;
import jscratch.modeles.sim.collision.ObstacleRectangle;
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
	private int tailleX;
	private int tailleY;
	
	private List<ObstacleShape> obstacles;
	
	public Map(BufferedImage imageMap, List<ObstacleShape> obstacles) {
		super();
		this.imageMap = imageMap;
		this.obstacles = obstacles;
		
		int tailleLimite = 10;
		tailleX = imageMap.getWidth();
		tailleY = imageMap.getHeight();

		// bord haut
		obstacles.add(new ObstacleRectangle(-tailleLimite, -tailleLimite, tailleX + tailleLimite * 2, tailleLimite, CouleurObstacle.BLACK.getCouleur()));
		// bord gauche
		obstacles.add(new ObstacleRectangle(-tailleLimite, -tailleLimite, tailleLimite, tailleLimite * 2 + tailleY, CouleurObstacle.BLACK.getCouleur()));
		// bord droite
		obstacles.add(new ObstacleRectangle(tailleX, -tailleLimite, tailleLimite, tailleLimite * 2 + tailleY, CouleurObstacle.BLACK.getCouleur()));	
		// bord bas
		obstacles.add(new ObstacleRectangle(-tailleLimite, tailleY, tailleLimite * 2 + tailleX, tailleLimite, CouleurObstacle.BLACK.getCouleur()));

	}

	public BufferedImage getImageMap() {
		return imageMap;
	}

	public List<ObstacleShape> getObstacles() {
		return obstacles;
	}

	public int getTailleX() {
		return tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}	
}

package jscratch.vue.sim;

import java.awt.Graphics;
import java.awt.Graphics2D;

import jscratch.modeles.sim.Map;
import jscratch.modeles.sim.collision.ObstacleShape;



/**
 * Classe qui gère le rendu de la map
 * @author Guillaume Delorme
 *
 */
public class MapRenderer implements Renderer {
	/**
	 * La map à afficher 
	 */
	private Map map;
		
	public MapRenderer(Map map) {
		super();
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see view.Renderer#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; 
		
		g2d.drawImage(map.getImageMap(), 0, 0, null);
		
		for (ObstacleShape os : map.getObstacles()) {
			g2d.setColor(os.getColor());
			g2d.fill(os.getShape());
		}
	}

}

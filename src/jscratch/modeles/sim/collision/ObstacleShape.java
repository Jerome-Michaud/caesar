package jscratch.modeles.sim.collision;

import java.awt.Color;
import java.awt.Shape;


/**
 * Classe qui représente un obstacle
 * @author Guillaume Delorme
 * @author Nicolas Detan
 *
 */
public abstract class ObstacleShape {
	protected Shape shape;
	protected Color color;
		
	public ObstacleShape() {}
	
	public ObstacleShape(Color color) {
		this.color = color;
	}

	public Shape getShape() {
		return shape;
	}

	public Color getColor() {
		return color;
	}
	
	
}

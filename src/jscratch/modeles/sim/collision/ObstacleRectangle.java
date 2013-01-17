package jscratch.modeles.sim.collision;

import java.awt.Color;
import java.awt.Rectangle;

import org.w3c.dom.Element;

/**
 * Classe qui représente un obstacle rectangle
 * @author Guillaume Delorme
 * @author Nicolas Detan
 *
 */
public class ObstacleRectangle extends ObstacleShape {

	public ObstacleRectangle(Element element) {
		super();
		shape = new Rectangle(Integer.parseInt(element.getAttribute("x")), 
				Integer.parseInt(element.getAttribute("y")), 
				Integer.parseInt(element.getAttribute("width")), 
				Integer.parseInt(element.getAttribute("height")));
		
		Color c = Color.getColor(element.getAttribute("color"));
				
		if (c != null) {
			color = c;
		} else {
			color = Color.BLACK;
		}
	}
	
	public ObstacleRectangle(int x, int y, int width, int height, Color color) {
		super(color);
		
		shape = new Rectangle(x, y, width, height);
	}
}

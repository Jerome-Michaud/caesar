package jscratch.modeles.sim.collision;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import org.w3c.dom.Element;

/**
 * Classe qui représente un obstacle ellipse
 * @author Guillaume Delorme
 *
 */
public class ObstacleEllipse extends ObstacleShape {

	public ObstacleEllipse(Element element) {
		super();
		shape = new Ellipse2D.Double(Integer.parseInt(element.getAttribute("x")), 
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
	
	public ObstacleEllipse(int x, int y, int width, int height, Color color) {
		super(color);
		
		shape = new Ellipse2D.Double(x, y, width, height);
	}
}

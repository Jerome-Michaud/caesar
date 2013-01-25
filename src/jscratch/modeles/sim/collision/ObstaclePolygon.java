package jscratch.modeles.sim.collision;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

import jscratch.utils.sim.XMLUtils;

import org.w3c.dom.Element;


/**
 * Classe qui représente un obstacle polygon
 * @author Guillaume Delorme
 *
 */
public class ObstaclePolygon extends ObstacleShape {

	public ObstaclePolygon(Element element) {
		super();
		
		Polygon polygon = new Polygon();
		
		for (Element e : XMLUtils.getChildren(element, "point")) {
			polygon.addPoint(Integer.parseInt(e.getAttribute("x")), 
					Integer.parseInt(e.getAttribute("y")));
		}
		
		shape = polygon;
				
		Color c = Color.getColor(element.getAttribute("color"));
				
		if (c != null) {
			color = c;
		} else {
			color = Color.BLACK;
		}
	}
	
	public ObstaclePolygon(List<Point> points, Color color) {
		super(color);
		
		Polygon polygon = new Polygon();
		
		for (Point p : points)
			polygon.addPoint(p.x, p.y);
		
		shape = polygon;
	}
}

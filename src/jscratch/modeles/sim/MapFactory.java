package jscratch.modeles.sim;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import jscratch.helpers.ErreurHelper;

import jscratch.modeles.sim.collision.CouleurObstacle;
import jscratch.modeles.sim.collision.ObstacleEllipse;
import jscratch.modeles.sim.collision.ObstaclePolygon;
import jscratch.modeles.sim.collision.ObstacleRectangle;
import jscratch.modeles.sim.collision.ObstacleShape;
import jscratch.utils.sim.XMLUtils;

import org.w3c.dom.Element;

/**
 * Factory pour la création des maps
 * @author Guillaume Delorme
 * @author Nicolas Detan
 */
public class MapFactory {

	/**
	 * Création d'une map depuis un fichier XML
	 * @param xmlFile
	 * @return la map créée
	 */
	public static Map createMapFromXML(File xmlFile) {				
		// Lecture du fichier XML
		Element racine = null;
		try {
			racine = XMLUtils.getDocumentRoot(xmlFile);
		} catch (Exception e) {
			ErreurHelper.afficher(e);
		}

		// Chargement de l'image
		Element imageElement = XMLUtils.getChild(racine, "image");

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(XMLUtils.getValue(imageElement)));
		} catch (Exception e) {
			ErreurHelper.afficher(e);
		}

		// Création de la liste d'obstacle
		List<ObstacleShape> listeObstacle = new ArrayList<ObstacleShape>();
		Element obstacles = XMLUtils.getChild(racine, "obstacles");
		
		if (obstacles != null) {
			for (Element e : XMLUtils.getChildren(obstacles)) {
				if (e.getNodeName().equals("rectangle")) {			
					listeObstacle.add(new ObstacleRectangle(e));
				}
				else if (e.getNodeName().equals("ellipse")) {
					listeObstacle.add(new ObstacleEllipse(e));
				}
				else if (e.getNodeName().equals("polygon")) {
					listeObstacle.add(new ObstaclePolygon(e));
				}
			}
		}			
		return new Map(image, listeObstacle);
	}
}
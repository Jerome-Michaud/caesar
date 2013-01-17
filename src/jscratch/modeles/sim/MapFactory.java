package jscratch.modeles.sim;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

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
		Element racine;
		try {
			racine = XMLUtils.getDocumentRoot(xmlFile);
		} catch (Exception e) {
			System.err.println("Erreur lors du chargement du fichier XML de la map : " + e.getMessage());
			return null;
		}

		// Chargement de l'image
		Element imageElement = XMLUtils.getChild(racine, "image");

		BufferedImage image;
		try {
			image = ImageIO.read(new File(XMLUtils.getValue(imageElement)));
		} catch (Exception e) {
			System.err.println("Erreur lors du chargement de l'image de la map : " + e.getMessage());
			return null;
		}

		// Création de la liste d'obstacle
		List<ObstacleShape> listeObstacle = new ArrayList<ObstacleShape>();
		Element obstacles = XMLUtils.getChild(racine, "obstacles");
		
		if (obstacles != null) {
			for (Element e : XMLUtils.getChildren(obstacles)) {
				if (e.getNodeName().equals("rectangle"))				
					listeObstacle.add(new ObstacleRectangle(e));
				if (e.getNodeName().equals("ellipse"))				
					listeObstacle.add(new ObstacleEllipse(e));
				if (e.getNodeName().equals("polygon"))				
					listeObstacle.add(new ObstaclePolygon(e));
			}
		}

		int tailleLimite = 10;
		int tailleX = image.getWidth();
		int tailleY = image.getHeight();

		// bord haut
		listeObstacle.add(new ObstacleRectangle(-tailleLimite, -tailleLimite, tailleX + tailleLimite * 2, tailleLimite, Color.BLACK));
		// bord gauche
		listeObstacle.add(new ObstacleRectangle(-tailleLimite, -tailleLimite, tailleLimite, tailleLimite * 2 + tailleY, Color.BLACK));
		// bord droite
		listeObstacle.add(new ObstacleRectangle(tailleX, -tailleLimite, tailleLimite, tailleLimite * 2 + tailleY, Color.BLACK));	
		// bord bas
		listeObstacle.add(new ObstacleRectangle(-tailleLimite, tailleY, tailleLimite * 2 + tailleX, tailleLimite, Color.BLACK));

		return new Map(image, listeObstacle);
	}
}
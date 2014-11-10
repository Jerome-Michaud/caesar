/*
Copyright (C) Université du Maine (2013)

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier.

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant
donné sa spécificité de logiciel libre, qui peut le rendre complexe à
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement,
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.modeles.sim;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import jscratch.helpers.ErreurHelper;
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
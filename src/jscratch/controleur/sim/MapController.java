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
package jscratch.controleur.sim;

import java.awt.Color;
import java.awt.geom.Point2D;
import jscratch.modeles.sim.ColorValue;
import jscratch.modeles.sim.Map;
import jscratch.modeles.sim.Robot;
import jscratch.modeles.sim.collision.ObstacleShape;

/**
 * Controller de la map.
 *
 * @since 1.0
 * @version 1.0
 */
public class MapController {

	/**
	 * Le model de la map
	 */
	private Map map;

	/**
	 * Constructeur
	 *
	 * @param m le model de la map
	 */
	public MapController(Map m) {
		this.map = m;
	}

	/**
	 * Teste si il est possible de déplacer le robot à une position donnée
	 * @param robot le robot sur la position à tester
	 * @return true si la position est possible
	 */
	public boolean positionPossible(Robot robot) {
		for (ObstacleShape obs : map.getObstacles()) {
			for (Point2D p : robot.getPoints()) {
				if (obs.getShape().contains(p)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Savoir si un point est dans un obstacle
	 *
	 * @param point le point
	 * @return vrai si le point est contenu dans un obstacle, faux sinon
	 */
	public boolean pointInObstacle(Point2D point) {
		for (ObstacleShape obs : map.getObstacles()) {
			if (obs.getShape().contains(point)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Récupérer la couleur d'un point dans la map pour le capteur de couleur
	 *
	 * @param point le point dans la map
	 * @return la couleur la plus proche dans ColorValue
	 */
	public ColorValue getColorValue(Point2D point) {
		Color color = new Color(map.getImageMap().getRGB((int) point.getX(), (int) point.getY()));
		return ColorValue.getSimilarColor(color);
	}

	/**
	 * Récupérer la couleur RGB d'un point dans la map
	 *
	 * @param point le point dans la map
	 * @return la couleur
	 */
	public Color getColorRGB(Point2D point) {
		return new Color(map.getImageMap().getRGB((int) point.getX(), (int) point.getY()));
	}

	/**
	 * Test si le déplacement du robot est bien dans la map
	 *
	 * @param point le point à tester
	 * @return vrai si le point est à l'intérieur de la map
	 */
	public boolean pointDeplacementRobot(Point2D point) {
		if (point.getX() < 0 || point.getX() >= map.getTailleX() - 34 || point.getY() < 0 || point.getY() >= map.getTailleY() - 40) {
			return false;
		} else {
			return true;
		}
	}
}
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
				
		color = CouleurObstacle.fromString(element.getAttribute("color")).getCouleur();
	}
	
	public ObstaclePolygon(List<Point> points, Color color) {
		super(color);
		
		Polygon polygon = new Polygon();
		
		for (Point p : points)
			polygon.addPoint(p.x, p.y);
		
		shape = polygon;
	}
}

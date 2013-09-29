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

import java.awt.geom.Point2D;
import java.util.List;
import jscratch.controleur.sim.MapController;
import nxtim.instruction.Capteur;

/**
 * Capteur de détection de distance
 * 
 * @since 1.0
 * @version 1.0
 */
public class UltraSonicSensor extends Sensor<Integer> {

	private List<Point2D> listPoint;
	private double distance;
	private Point2D pointFinal;
	private Robot robot;

	public UltraSonicSensor(SensorPort port, MapController mapC, double x,
			double y, double orientation,double distance,Robot robot) {
		super(port, mapC, x, y, orientation);
		this.distance = distance;
		this.robot = robot;
		this.pointFinal = new Point2D.Double();
		update();
	}

	/**
	 * @return le positionFinal
	 */
	public Point2D getPointFinal() {
		return pointFinal;
	}

	@Override
	public void update() {
		// Mise à jour de la position du point Final - point permettant de former la droite du laser
		double x1 = position.getX() + (distance) * Math.cos(orientation + robot.getOrientation());
		double y1 = position.getY() + (distance) * Math.sin(orientation + robot.getOrientation());

		pointFinal.setLocation(x1, y1);

		double x, y;

		double dx = pointFinal.getX() - position.getX();
		double dy = pointFinal.getY() - position.getY();

		int distanceObs = -1;
		int nbPoints = 0;

		if (position.getX() < pointFinal.getX()) {
			for(x = position.getX(); x < pointFinal.getX(); x++)
			{
				nbPoints++;
				y = position.getY() + dy * (x - position.getX()) / dx;
				if (mapC.pointInObstacle(new Point2D.Double(x, y)) && distanceObs == -1) {
					distanceObs = nbPoints;
				}
			}
		} else {
			for(x = position.getX(); x > pointFinal.getX(); x--)
			{
				nbPoints++;
				y = position.getY() + dy * (x - position.getX()) / dx;
				if (mapC.pointInObstacle(new Point2D.Double(x, y)) && distanceObs == -1) {
					distanceObs = nbPoints;
				}
			}
		}

		if (distanceObs == -1) {
			value = 255;
		}
		else {
			value = (distanceObs * 255)/ nbPoints;
		}
	}

	/**
	 * @return le distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance le distance à définir
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}


	/**
	 * @return le listPoint
	 */
	public List<Point2D> getListPoint() {
		return listPoint;
	}

	@Override
	public String toString() {
		return "<strong>" + Capteur.ULTRASONIC.toString() + " (" + port + ") :</strong> " + value;
	}
}

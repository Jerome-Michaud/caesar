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
import java.util.ArrayList;
import java.util.List;

import jscratch.controleur.sim.MapController;

/**
 * Classe qui représente le robot
 *
 * @author Guillaume Delorme
 *
 */
public class Robot {

	/**
	 * La position du robot en X
	 */
	private double x;
	/**
	 * La position du robot en Y
	 */
	private double y;
	/**
	 * L'orientation/angle du robot en degrés (entre 0 et 360)
	 */
	private double orientation;
	/**
	 * Longueur du robot
	 */
	private int longueur;
	/**
	 * Largeur du robot
	 */
	private int largeur;
	/**
	 * Rayon des roues
	 */
	private double rayon;
	/**
	 * Entre-axe des roues
	 */
	private double L = 80;
	/**
	 * Liste des moteurs
	 */
	private List<Motor> motors;
	/**
	 * Liste des capteurs
	 */
	private List<Sensor<? extends Object>> sensors;
	/**
	 * Ecart entre les roues
	 */
	private double ecartEntreRoues;
	/**
	 * Rayon des roues
	 */
	private double rayonRoues;
	/**
	 * Point central du robot
	 */
	private Point2D pointCentral;
	/**
	 * Tableau des points de collisions
	 */
	private Point2D[] listPoints;

	public Robot(MapController mapC) {
		super();

		this.x = 200;
		this.y = 200;
		this.orientation = 0;
		this.rayon = 5;

		this.L = 1;

		ecartEntreRoues = 69;
		rayonRoues = 5;

		this.sensors = new ArrayList<Sensor<? extends Object>>(4);
		// TODO TEST: Supprimer les adds et gérer via le panneau de control	
		this.sensors.add(new ColorSensor(SensorPort.S1, mapC, 10, 10, 0));
		this.sensors.add(new UltraSonicSensor(SensorPort.S2, mapC, 33, 0, 0, 200, this));
		this.sensors.add(new LightSensor(SensorPort.S3, mapC, 10, 10, 0));
		this.sensors.add(new TouchSensor(SensorPort.S4, mapC, 40, 0, 0));

		this.motors = new ArrayList<Motor>(3);
		this.motors.add(new Motor(MotorPort.OUT_A));
		this.motors.add(new Motor(MotorPort.OUT_B)); // moteur droit
		this.motors.add(new Motor(MotorPort.OUT_C)); // moteur gauche

		listPoints = new Point2D[32];

		for (int i = 0; i <= 31; i++) {
			listPoints[i] = new Point2D.Double();
		}
	}

	/**
	 * @return le sensors
	 */
	public List<Sensor<? extends Object>> getSensors() {
		return sensors;
	}

	/**
	 * Recuperer la liste de point definissant le contour du robot
	 *
	 * @return liste de point
	 */
	public List<Point2D> getPoints() {

		List<Point2D> points = new ArrayList<Point2D>();
		for (Point2D p : listPoints) {
			points.add(p);
		}
		return points;
	}

	public Motor getMotor(MotorPort port) {
		for (Motor m : motors) {
			if (m.getPort() == port) {
				return m;
			}
		}
		return null;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public double getOrientation() {
		return orientation;
	}

	/**
	 * @param longueur le longueur à définir
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	/**
	 * @param largeur le largeur à définir
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;

		if (this.orientation > 2 * Math.PI) {
			this.orientation -= 2 * Math.PI;
		} else if (this.orientation < 0) {
			this.orientation += 2 * Math.PI;
		}
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public double getL() {
		return L;
	}

	public double getEcartEntreRoues() {
		return ecartEntreRoues;
	}

	public double getRayonRoues() {
		return rayonRoues;
	}

	/**
	 * @return le pointCentral
	 */
	public Point2D getPointCentral() {
		return pointCentral;
	}

	/**
	 * @param pointCentral le pointCentral à définir
	 */
	public void setPointCentral(Point2D pointCentral) {
		this.pointCentral = pointCentral;
	}

	public Point2D[] getListePoints() {
		return listPoints;
	}

	/**
	 * Mise à jour du point central
	 *
	 * @param dx
	 * @param dy
	 */
	public void updatePointCentral(double dx, double dy) {
		pointCentral.setLocation(pointCentral.getX() + dx, pointCentral.getY() + dy);
	}

	/**
	 * Mise à jour de la position des points de collisions du robot
	 */
	public void updateListePoints() {
		// Calcul des 4 coins du robot
		double x1 = pointCentral.getX() + (largeur / 2) * Math.cos(orientation) - (longueur / 2) * Math.sin(orientation);
		double y1 = pointCentral.getY() + (longueur / 2) * Math.cos(orientation) + (largeur / 2) * Math.sin(orientation);

		double x2 = pointCentral.getX() - (largeur / 2) * Math.cos(orientation) - (longueur / 2) * Math.sin(orientation);
		double y2 = pointCentral.getY() + (longueur / 2) * Math.cos(orientation) - (largeur / 2) * Math.sin(orientation);

		double x3 = pointCentral.getX() - (largeur / 2) * Math.cos(orientation) + (longueur / 2) * Math.sin(orientation);
		double y3 = pointCentral.getY() - (longueur / 2) * Math.cos(orientation) - (largeur / 2) * Math.sin(orientation);

		double x4 = pointCentral.getX() + (largeur / 2) * Math.cos(orientation) + (longueur / 2) * Math.sin(orientation);
		double y4 = pointCentral.getY() - (longueur / 2) * Math.cos(orientation) + (largeur / 2) * Math.sin(orientation);

		Point2D p0 = listPoints[0];
		Point2D p8 = listPoints[8];
		Point2D p16 = listPoints[16];
		Point2D p24 = listPoints[24];

		p0.setLocation(x1, y1);
		p8.setLocation(x2, y2);
		p16.setLocation(x3, y3);
		p24.setLocation(x4, y4);

		// Calcul des points intermédiaires du robot		
		double x08 = p8.getX() - p0.getX();
		double y08 = p8.getY() - p0.getY();

		double x816 = p8.getX() - p16.getX();
		double y816 = p8.getY() - p16.getY();

		double x1624 = p24.getX() - p16.getX();
		double y1624 = p24.getY() - p16.getY();

		double x240 = p0.getX() - p24.getX();
		double y240 = p0.getY() - p24.getY();

		for (int i = 1; i < 8; i++) {
			listPoints[i].setLocation(p0.getX() + x08 * i / 8, p0.getY() + y08 * i / 8);
			listPoints[i + 8].setLocation(p16.getX() + x816 * i / 8, p16.getY() + y816 * i / 8);
			listPoints[i + 16].setLocation(p16.getX() + x1624 * i / 8, p16.getY() + y1624 * i / 8);
			listPoints[i + 24].setLocation(p24.getX() + x240 * i / 8, p24.getY() + y240 * i / 8);
		}
	}

	/**
	 * Reinitialisation de l'emplacement du robot
	 *
	 * @param x
	 * @param y
	 */
	public void reset(double x, double y) {
		setX(x);
		setY(y);
		pointCentral.setLocation(x + (largeur / 2), y + (longueur / 2));
		setOrientation(0);
		updateListePoints();
	}

	/**
	 * Mise à jour des sensors
	 */
	public void updateSensor() {
		double x1;
		double y1;

		for (Sensor<? extends Object> s : sensors) {
			x1 = pointCentral.getX() + (s.getX()) * Math.cos(orientation) - (s.getY()) * Math.sin(orientation);
			y1 = pointCentral.getY() + (s.getY()) * Math.cos(orientation) + (s.getX()) * Math.sin(orientation);
			s.getPosition().setLocation(x1, y1);
			s.update();
		}
	}
}
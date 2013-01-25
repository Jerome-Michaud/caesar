package jscratch.modeles.sim;

import java.awt.geom.Point2D;
import java.util.*;

import jscratch.controleur.sim.MapController;

/**
 * Capteur de détection de distance
 * @author Nicolas Detan
 * @author Guillaume Delorme
 */
public class UltraSonicSensor extends Sensor<Integer> {
	
<<<<<<< HEAD
	private List<Point2D> listPoint;
	private double distance;
	private Point2D positionFinal;
=======
	private double distance;
	private Point2D pointFinal;
>>>>>>> 37f209697bdda91b1de9819cfa31f5cbc308fc9a
	private Robot robot;
	
	public UltraSonicSensor(SensorPort port, MapController mapC, double x,
			double y, double orientation,double distance,Robot robot) {
		super(port, mapC, x, y, orientation);
		this.distance = distance;
		this.robot = robot;
<<<<<<< HEAD
		this.positionFinal = new Point2D.Double();
=======
		this.pointFinal = new Point2D.Double();
>>>>>>> 37f209697bdda91b1de9819cfa31f5cbc308fc9a
		update();
	}

	/**
	 * @return le positionFinal
	 */
<<<<<<< HEAD
	public Point2D getPositionFinal() {
		return positionFinal;
=======
	public Point2D getPointFinal() {
		return pointFinal;
>>>>>>> 37f209697bdda91b1de9819cfa31f5cbc308fc9a
	}

	@Override
	public void update() {
		
		/*
		 * Mise à jour de la position du point Final - point permettant de former la droite du laser
		 * 
		 */
		
		double x1 = position.getX()+(distance)*Math.cos(orientation+robot.getOrientation());
		double y1 = position.getY()+(distance)*Math.sin(orientation+robot.getOrientation());
		
<<<<<<< HEAD
		positionFinal.setLocation(x1, y1);
=======
		pointFinal.setLocation(x1, y1);
>>>>>>> 37f209697bdda91b1de9819cfa31f5cbc308fc9a
		
		/*
		 * Tracage d'une droite entre la position du capteur et le point final 
		 * On calcule la distance entre le capteur et le premier obstacle en parcourant les points de la droite
		 * 
		 * Reference : Wikipedia - Line Draw Algorithm
		 */
		double x;
		double y;
		
<<<<<<< HEAD
		double dx = positionFinal.getX()-position.getX();
		double dy = positionFinal.getY()-position.getY();
=======
		double dx = pointFinal.getX()-position.getX();
		double dy = pointFinal.getY()-position.getY();
>>>>>>> 37f209697bdda91b1de9819cfa31f5cbc308fc9a
		
		int distanceObs = -1;
		int nbPoints = 0;
		
<<<<<<< HEAD
		for(x = position.getX();x<positionFinal.getX();x++)
=======
		for(x = position.getX();x<pointFinal.getX();x++)
>>>>>>> 37f209697bdda91b1de9819cfa31f5cbc308fc9a
		{
			nbPoints++;
			y = position.getY()+dy * (x-position.getX())/dx;
			if (mapC.pointInObstacle(new Point2D.Double(x, y)) && distanceObs == -1)
				distanceObs = nbPoints;
		}
		if (distanceObs == -1)
			value = 255;
		else
			value = (distanceObs *255)/ nbPoints;
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
<<<<<<< HEAD

	/**
	 * @return le listPoint
	 */
	public List<Point2D> getListPoint() {
		return listPoint;
	}

=======
>>>>>>> 37f209697bdda91b1de9819cfa31f5cbc308fc9a
}

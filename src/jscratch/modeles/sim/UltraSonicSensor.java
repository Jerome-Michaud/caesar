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

package jscratch.modeles.sim;

import java.awt.geom.Point2D;

import jscratch.controleur.sim.MapController;


/**
 * Classe qui représente un capteur
 * @author Nicolas Detan
 * @author Guillaume Delorme
 */
public abstract class Sensor<T> {
	protected SensorPort port;
	protected MapController mapC;
	protected T value;
	protected Point2D position;
	protected double orientation;
	protected double x;
	protected double y;
	
		
	public Sensor(SensorPort port, MapController mapC, double x, double y,
			double orientation) {
		super();
		this.port = port;
		this.mapC = mapC;
		this.x = x;
		this.y = y;
		this.position = new Point2D.Double();
		this.orientation = orientation;
	}

	/**
	 * @return le x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return le y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @return le value
	 */
	public T getValue() {
		return value;
	}		
		
	/**
	 * @return le port
	 */
	public SensorPort getPort() {
		return port;
	}	

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public double getOrientation() {
		return orientation;
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}

	/**
	 * met à jour le sensor
	 */
	public abstract void update();	
}
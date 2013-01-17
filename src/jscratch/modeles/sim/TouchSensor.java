package jscratch.modeles.sim;

import jscratch.controleur.sim.MapController;

/**
 * Capteur de détection de collision
 * @author Nicolas Detan
 * @author Guillaume Delorme
 */
public class TouchSensor extends Sensor<Boolean> {

	public TouchSensor(SensorPort port, MapController mapC, double x, double y,
			double orientation) {
		super(port, mapC, x, y, orientation);
		update();
	}

	/* (non-Javadoc)
	 * @see model.Sensor#update()
	 */
	public void update() {
		value = mapC.pointInObstacle(position);
	}

}

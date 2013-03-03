package jscratch.modeles.sim;

import jscratch.controleur.sim.MapController;
import nxtim.instruction.Capteur;

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

	@Override
	public void update() {
		value = mapC.pointInObstacle(position);
	}

	@Override
	public String toString() {
		return "<strong>" + Capteur.TOUCH.toString() + " (" + port + ") :</strong> " + value;
	}
}

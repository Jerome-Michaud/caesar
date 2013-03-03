package jscratch.modeles.sim;

import jscratch.controleur.sim.MapController;
import nxtim.instruction.Capteur;

/**
 * Capteur de détection des couleurs 
 * @author Nicolas Detan
 * @author Guillaume Delorme
 */
public class ColorSensor extends Sensor<ColorValue> {		
	
	public ColorSensor(SensorPort port, MapController mapC, double x, double y,
			double orientation) {
		super(port, mapC, x, y, orientation);
		update();
	}

	@Override
	public void update() {
		value = mapC.getColorValue(position);
	}

	@Override
	public String toString() {
		return "<strong>" + Capteur.COLOR.toString() + " (" + port + ") :</strong> " + value;
	}
}

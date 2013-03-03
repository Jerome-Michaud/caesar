package jscratch.modeles.sim;

import java.awt.Color;

import jscratch.controleur.sim.MapController;
import nxtim.instruction.Capteur;


/**
 * Capteur de détection de la luminosité
 * @author Guillaume Delorme
 */
public class LightSensor extends Sensor<Integer> {

	public LightSensor(SensorPort port, MapController mapC, double x, double y,
			double orientation) {
		super(port, mapC, x, y, orientation);
		update();
	}

	@Override
	public void update() {
		// Récuperation de la luminosité de la couleur
		Color color = mapC.getColorRGB(position);

		double r = color.getRed() / 255.0;
		double g = color.getGreen() / 255.0;
		double b = color.getBlue() / 255.0;
		double v;
		double m;
		double l;

		v = Math.max(r,g);
		v = Math.max(v,b);
		m = Math.min(r,g);
		m = Math.min(m,b);

		l = (m + v) / 2.0;
		
		/* Le capteur doit retourner une valeur entre 0 et 100
		 * où 0 est le plus foncé et 100 est le plus clair
		 */
		this.value = (int) (l * 100);
	}

	@Override
	public String toString() {
		return "<strong>" + Capteur.LIGHT.toString() + " (" + port + ") :</strong> " + value;
	}
}

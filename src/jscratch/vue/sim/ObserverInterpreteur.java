package jscratch.vue.sim;

import java.util.List;

import jscratch.modeles.sim.MotorPort;

/**
 * Interface de la classe observant l' Interpreteur
 * @author Nicolas
 *
 */
public interface ObserverInterpreteur {

	/**
	 * rafraichi l'affichage du panelController
	 */
	public void update(ObservableInterpreteur o);
	
	/**
	 * ajoute une commande dans le simulateur
	 */
	public void update(String type, int vitesse, List<MotorPort> ports);
}

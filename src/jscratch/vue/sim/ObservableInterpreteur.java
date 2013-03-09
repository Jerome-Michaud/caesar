package jscratch.vue.sim;

import java.util.List;

import jscratch.modeles.sim.MotorPort;

/**
 * Interface de la classe Interpreteur à observer
 * @author Nicolas
 *
 */
public interface ObservableInterpreteur {

	/**
	 * ajoute un observateur sur l'interpreteur
	 * 
	 * @param ObserverInterpreteur
	 */
	public void addObserver(ObserverInterpreteur o);
	
	/**
	 * supprimer un observateur de l'interpreteur
	 * 
	 * @param ObserverInterpreteur
	 */
	public void deleteObserver(ObserverInterpreteur o);
	
	/**
	 * met à jour les observateurs
	 */
	public void notifyObserver();
	
	/**
	 * met à jour les observateurs avec une commande
	 */
	public void notifyObserver(String type, int vitesse, List<MotorPort> port);
}

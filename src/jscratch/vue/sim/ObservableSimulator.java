package jscratch.vue.sim;

/**
 * Interface de la classe Simulator à observer 
 * @author Nicolas
 *
 */
public interface ObservableSimulator {

	/**
	 * ajoute un observateur sur le simulateur
	 * 
	 * @param ObserverSimulator
	 */
	public void addObserver(ObserverSimulator o);
	
	/**
	 * supprimer un observateur du simulateur
	 * 
	 * @param ObserverSimulator
	 */
	public void deleteObserver(ObserverSimulator o);
	
	/**
	 * met à jour les observateurs
	 */
	public void notifyObserver();
}

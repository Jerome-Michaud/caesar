package jscratch.vue.sim;

/**
 * Interface de la classe Simulator à observer 
 * @author Nicolas
 *
 */
public interface ObservableSimulator {

	public void addObserver(ObserverSimulator o);
	
	public void deleteObserver(ObserverSimulator o);
	
	public void notifyObserver();
}

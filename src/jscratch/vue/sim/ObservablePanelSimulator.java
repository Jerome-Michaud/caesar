package jscratch.vue.sim;

/**
 * Interface de la classe PanelSimulator à observer
 * @author Nicolas
 *
 */
public interface ObservablePanelSimulator {

	public void addObserver(ObserverPanelSimulator o);
	
	public void deleteObserver(ObserverPanelSimulator o);
	
	public void notifyObserver();
}

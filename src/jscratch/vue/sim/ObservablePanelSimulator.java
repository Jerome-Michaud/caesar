package jscratch.vue.sim;

/**
 * Interface de la classe PanelSimulator à observer
 * @author Nicolas
 *
 */
public interface ObservablePanelSimulator {

	/**
	 * ajoute un observateur sur le panelsimulateur
	 * 
	 * @param ObserverPanelSimulator
	 */
	public void addObserver(ObserverPanelSimulator o);
	/**
	 * supprimer un observateur du panelsimulateur
	 * 
	 * @param ObserverPanelSimulator
	 */
	public void deleteObserver(ObserverPanelSimulator o);
	/**
	 * met à jour les observateurs
	 */
	public void notifyObserver();
}

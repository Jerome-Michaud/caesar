package jscratch.vue.sim;

public interface ObservablePanelSimulator {

	public void addObserver(ObserverPanelSimulator o);
	
	public void deleteObserver(ObserverPanelSimulator o);
	
	public void notifyObserver();
}

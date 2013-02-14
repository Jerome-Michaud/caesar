package jscratch.vue.sim;

public interface ObservableSimulator {

	public void addObserver(ObserverSimulator o);
	
	public void deleteObserver(ObserverSimulator o);
	
	public void notifyObserver();
}

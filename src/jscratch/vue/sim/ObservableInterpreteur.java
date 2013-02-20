package jscratch.vue.sim;

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
}

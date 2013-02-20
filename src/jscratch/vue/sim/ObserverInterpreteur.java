package jscratch.vue.sim;

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
}

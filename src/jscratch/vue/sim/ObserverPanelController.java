package jscratch.vue.sim;

/**
 * Interface de la classe observant le Simulator
 * @author Nicolas
 *
 */
public interface ObserverPanelController {

	/**
	 * rafraichi l'affichage du panelController
	 */
	public void update(ObservableSimulator o);
}

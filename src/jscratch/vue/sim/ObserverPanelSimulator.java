package jscratch.vue.sim;

/**
 * Interface de la classe observant le PanelSimulator
 * @author Nicolas
 *
 */
public interface ObserverPanelSimulator {

	/**
	 * rafraichi l'affichage du panelInfosRobot
	 */
	public void update(ObservablePanelSimulator o);
}

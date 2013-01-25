package jscratch.vue.ginterface;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import jscratch.vue.tools.Variables;
import jscratch.vue.widget.IWidget;

/**
 * Zone de travail où placer les widgets qui seront ensuite traduits.
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelCodeGraphique extends JPanel implements IWidget, Observer {

	/**
	 * L'instance unique de PanelCodeGraphique.
	 */
	private static PanelCodeGraphique instance = new PanelCodeGraphique();

	private PanelCodeGraphique() {
		this.setMinimumSize(new Dimension(400, 600));
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder("Code graphique"));
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	protected static PanelCodeGraphique getInstance() {
		return instance;
	}

	@Override
	public boolean isRacine() {
		return true;
	}

	@Override
	public void update(Observable o, Object o1) {
		this.repaint();
	}
}
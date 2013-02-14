package jscratch.vue.ginterface.principales.panels;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import jscratch.vue.widgets.IWidget;

/**
 * Zone de travail où placer les widgets qui seront ensuite traduits.
 *
 * @since 1.0
 * @version 1.0
 */
public final class PanelCodeGraphique extends JPanel implements IWidget, Observer {

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
	public static PanelCodeGraphique getInstance() {
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
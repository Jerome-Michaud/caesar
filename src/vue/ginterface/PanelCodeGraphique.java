package vue.ginterface;

import vue.widget.IWidget;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
/**
 * Zone de travail où placer les widgets qui seront ensuite traduits.
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelCodeGraphique extends JPanel implements IWidget {
	/**
	 * SINGLETON.
	 *
	 * @since 1.0
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
}

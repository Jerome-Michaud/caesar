package jscratch.vue.ginterface.principales.panels;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import jscratch.vue.arborescence.DragAndDropTools;
import jscratch.vue.widgets.IWidget;
import jscratch.vue.widgets.Widget;

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
	private JScrollPane scroll = null;

	private PanelCodeGraphique() {
		this.setMinimumSize(new Dimension(400, 600));
		this.setLayout(null);
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
	
	public void updateSize(List<List<Widget>> arborescence) {
		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		Rectangle bounds = null;
		for (List<Widget> l : arborescence) {
			if (!l.isEmpty()) {
				Rectangle boundsGroup = DragAndDropTools.groupeWidgetBounds(l, 0, null);
				if (bounds == null) {
					bounds = boundsGroup;
				} else {
					bounds = bounds.union(boundsGroup);
				}
			}
		}
		if (bounds != null) {
			p.setPreferredSize(new Dimension((int) (bounds.getX() + bounds.getWidth()), (int) (bounds.getY() + bounds.getHeight())));
			p.getScroll().validate();
		}
	}

	@Override
	public boolean isRacine() {
		return true;
	}

	@Override
	public void update(Observable o, Object o1) {
		this.repaint();
	}

	public void setScrollPane(JScrollPane scrollCodeGraphique) {
		this.scroll = scrollCodeGraphique;
	}

	public JScrollPane getScroll() {
		return scroll;
	}
}

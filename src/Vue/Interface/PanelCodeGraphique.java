package Vue.Interface;

import Vue.Widget.IWidget;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelCodeGraphique extends JPanel implements IWidget {

	private static PanelCodeGraphique instance = new PanelCodeGraphique();

	private PanelCodeGraphique() {
		this.setMinimumSize(new Dimension(400, 600));
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder("Code graphique"));
	}

	public static PanelCodeGraphique getInstance() {
		return instance;
	}

	public boolean isRacine() {
		return true;
	}
}

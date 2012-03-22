package Vue.Interface;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelCodeConsole extends JPanel {

	private static PanelCodeConsole instance = new PanelCodeConsole();

	private PanelCodeConsole() {
		this.setMinimumSize(new Dimension(100, 600));
		this.setBorder(BorderFactory.createTitledBorder("Aperçu code console"));
	}

	public static PanelCodeConsole getInstance() {
		return instance;
	}
}

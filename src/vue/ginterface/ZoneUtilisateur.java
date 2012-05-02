package vue.ginterface;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class ZoneUtilisateur extends JPanel {

	private static ZoneUtilisateur instance = new ZoneUtilisateur();

	private ZoneUtilisateur() {

		this.setLayout(new BorderLayout());

		this.add(PanelInstruction.getInstance(), BorderLayout.WEST);
		this.add(PanelCodeGraphique.getInstance(), BorderLayout.CENTER);
	}

	public static ZoneUtilisateur getInstance() {
		return instance;
	}
}
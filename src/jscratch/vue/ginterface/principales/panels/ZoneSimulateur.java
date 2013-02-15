package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import jscratch.vue.sim.PanelInfosRobot;
import jscratch.vue.sim.PanelSimulator;

/**
 * @since 1.0
 * @version 1.0
 */
public class ZoneSimulateur extends JPanel {
	
	private PanelSimulator panelSimulator;
	private PanelInfosRobot infosRobot;
	private JSplitPane split;

	/**
	 * Constructeur par défaut de <code>ZoneSimulateur</code>.
	 */
	public ZoneSimulateur() {
		setLayout(new BorderLayout());
		this.panelSimulator = new PanelSimulator();
		
		this.infosRobot = new PanelInfosRobot(panelSimulator.getSimulator().getRobot());	
		this.split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, infosRobot, panelSimulator);
		panelSimulator.addObserver(infosRobot);
		
		this.add(split);
	}
}
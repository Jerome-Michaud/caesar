package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import jscratch.controleur.sim.Simulator;
import jscratch.vue.sim.PanelController;
import jscratch.vue.sim.PanelInfosRobot;
import jscratch.vue.sim.PanelSimulator;

/**
 * @since 1.0
 * @version 1.0
 */
public class ZoneSimulateur extends JPanel {
	
	private PanelSimulator panelSimulator;
	private PanelController panelController;
	private PanelInfosRobot infosRobot;
	private JSplitPane split;
	private JPanel panelSC;
	private Simulator simulator;

	/**
	 * Constructeur par défaut de <code>ZoneSimulateur</code>.
	 */
	public ZoneSimulateur() {
		setLayout(new BorderLayout());
		
		this.simulator = new Simulator();
		this.panelSC = new JPanel();
		this.panelSimulator = new PanelSimulator(simulator);
		this.panelController = new PanelController(simulator);
		this.infosRobot = new PanelInfosRobot(panelSimulator.getSimulator().getRobot());	

		this.panelSC.setLayout(new BorderLayout());	
		this.panelSC.setMinimumSize(new Dimension(500, 600));
		this.panelSC.add(panelController,BorderLayout.NORTH);
		this.panelSC.add(panelSimulator,BorderLayout.CENTER);	
				
		this.split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, infosRobot, panelSC);
		panelSimulator.addObserver(infosRobot);
		
		this.add(split);
	}
}

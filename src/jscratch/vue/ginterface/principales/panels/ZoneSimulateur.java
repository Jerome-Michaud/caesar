package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.sun.xml.internal.bind.unmarshaller.InfosetScanner;

import jscratch.controleur.sim.Simulator;
import jscratch.vue.sim.PanelInfosRobot;
import jscratch.vue.sim.PanelSimulator;

public class ZoneSimulateur extends JPanel {
	
	private PanelSimulator panelSimulator;
	private PanelInfosRobot infosRobot;
	private JSplitPane split;

	public ZoneSimulateur() {
		setLayout(new BorderLayout());
		this.panelSimulator = new PanelSimulator();
		
		this.infosRobot = new PanelInfosRobot(panelSimulator.getSimulator().getRobot());	
		this.split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, infosRobot, panelSimulator);
		panelSimulator.addObserver(infosRobot);
		
		this.add(split);
	}
}

package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import jscratch.controleur.sim.Simulator;
import jscratch.vue.sim.PanelInfosRobot;
import jscratch.vue.sim.PanelSimulator;

import de.javasoft.swing.JYTabbedPane;

/**
 * Gestion des onglets dans l'affichage
 * association de la zone d'edition/utilisateur et la zone du simulateur
 * @author Nicolas
 *
 */
public class OngletUtilisateur extends JPanel {

	private static OngletUtilisateur instance = null;
	
	private JYTabbedPane onglets;
	private PanelInfosRobot infosRobot;
	
	public OngletUtilisateur() {
		this.setLayout(new BorderLayout());
		this.onglets = new JYTabbedPane();
				
		onglets.addTab("Edition", ZoneUtilisateur.getInstance());
		onglets.addTab("Simulation", new ZoneSimulateur());
		
		this.add(onglets,BorderLayout.CENTER);
		/*
		if (Boolean.valueOf(PropertiesHelper.getInstance().get("user.interface.afficher.categories"))) {
			this.add(PanelInstruction.getInstance(), BorderLayout.WEST);
		}
		this.add(PanelCodeGraphique.getInstance(), BorderLayout.CENTER);*/
	}
	
	/**
	 * @since 1.0
	 *
	 * @return L'unique instance de OngletUtilisateur.
	 */
	public static OngletUtilisateur getInstance() {
		if(instance == null){
			instance = new OngletUtilisateur();
		}
		return instance;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import jscratch.controleur.sim.Simulator;
import jscratch.helpers.LangueHelper;
import jscratch.parametrages.langue.VariableLangue;
import jscratch.vue.ginterface.principales.GUI;

/**
 *
 * @author Jérôme
 */
public final class PanelConfigRobot extends JDialog {

	/**
	 * L'instance unique de PanelConfigRobot.
	 */
	//private JDialog dialSC;
	private JDialog dialSC;
	private JLabel label;
	private JPanel dessinRobot;
	private JLabel zoneCapteur;
	
	private JPanel capteurs;
	private JPanel capteursDisponibles;
	private JLabel texteCapteursDispo;
	private JLabel texteCapteursDispo2;
	private JPanel capteursInstalles;
	private JLabel texteCapteursInstalles;
	
	private JPanel moteurs;
	private JPanel moteursDisponibles;
	private JLabel texteMoteursDispo;
	private JPanel moteursInstalles;
	private JLabel texteMoteursInstalles;
	
	public PanelConfigRobot(Simulator simulator) {
		String titre = LangueHelper.getInstance().get(VariableLangue.SIM_CONF_TITTLE);
		dialSC = new JDialog(GUI.getFenetre(), titre, true);
		dialSC.setSize(900, 600);
		dialSC.setLocationRelativeTo(null); 
		try {
			//todo: Recréer nvle img robot pour config + img capteurs
			label = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/briqueNXT_200x400.png"))));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		dessinRobot = new JPanel();
		dessinRobot.setLayout(new FlowLayout(FlowLayout.CENTER));
		dessinRobot.add(label);
		dessinRobot.setLocation(300, 100);
		
		capteursDisponibles = new JPanel();
		capteursDisponibles.setLayout(new FlowLayout(FlowLayout.LEFT));
		capteursDisponibles.setBorder(BorderFactory.createTitledBorder(LangueHelper.getInstance().get(VariableLangue.SIM_CONF_CAPT_DISP)));
		try {
			texteCapteursDispo = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/capteurContact_50x42.png"))));
			texteCapteursDispo2 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/capteurContact_50x42.png")), "Capteur contact"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		capteursDisponibles.add(texteCapteursDispo);
		capteursDisponibles.add(texteCapteursDispo2);
		
		capteursInstalles = new JPanel();
		capteursInstalles.setLayout(new FlowLayout(FlowLayout.LEFT));
		capteursInstalles.setBorder(BorderFactory.createTitledBorder(LangueHelper.getInstance().get(VariableLangue.SIM_CONF_CAPT_UTIL)));
		texteCapteursInstalles = new JLabel("");
		capteursInstalles.add(texteCapteursInstalles);
		
		capteurs = new JPanel();
		capteurs.setPreferredSize(new Dimension(200,600));
		capteurs.setLayout(new GridLayout(2,1));
		capteurs.add(capteursDisponibles);
		capteurs.add(capteursInstalles);
		
		moteursDisponibles = new JPanel();
		moteursDisponibles.setLayout(new FlowLayout(FlowLayout.LEFT));
		moteursDisponibles.setBorder(BorderFactory.createTitledBorder(LangueHelper.getInstance().get(VariableLangue.SIM_CONF_MOT_DISP)));
		texteMoteursDispo = new JLabel("");
		moteursDisponibles.add(texteMoteursDispo);
		
		moteursInstalles = new JPanel();
		moteursInstalles.setLayout(new FlowLayout(FlowLayout.LEFT));
		moteursInstalles.setBorder(BorderFactory.createTitledBorder(LangueHelper.getInstance().get(VariableLangue.SIM_CONF_MOT_UTIL)));
		texteMoteursInstalles = new JLabel("");
		moteursInstalles.add(texteMoteursInstalles);
		
		moteurs = new JPanel();
		moteurs.setPreferredSize(new Dimension(200,600));
		moteurs.setLayout(new GridLayout(2,1));
		moteurs.add(moteursDisponibles);
		moteurs.add(moteursInstalles);
	
		try {
			zoneCapteur = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		JPanel zone = new JPanel();
		zone.setLayout(new FlowLayout(FlowLayout.CENTER));
		//zone.setBorder(BorderFactory.createTitledBorder(LangueHelper.getInstance().get(VariableLangue.SIM_CONF_CAPT_DISP)));
		zone.add(zoneCapteur);
		
		
		JPanel Robot = new JPanel();
		Robot.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		Robot.add(dessinRobot, gbc);
		/*
		gbc.anchor = GridBagConstraints.SOUTH;
		Robot.add(zone, gbc);
		*/
		dialSC.setLayout(new BorderLayout());
		dialSC.getContentPane().add(capteurs, BorderLayout.WEST);
		dialSC.getContentPane().add(moteurs, BorderLayout.EAST);
		dialSC.add(Robot);
		//dialSC.add(zone);
		dialSC.setVisible(true);
	}
	
	
}
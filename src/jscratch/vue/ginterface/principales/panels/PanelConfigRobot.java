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
	
	private JLabel zone1;
	private JLabel zone2;
	private JLabel zone3;
	private JLabel zone4;
	private JLabel zone5;
	private JLabel zone6;
	private JLabel zone7;
	private JLabel zone8;
	private JLabel zone9;
	private JLabel zone10;
	private JLabel zone11;
	private JLabel zoneVide1;
	private JLabel zoneVide2;
	private JLabel zoneVide3;
	private JLabel zoneVide4;
	private JLabel zoneVide5;
	private JLabel zoneVide6;
	
	// TEST
	private JLabel zoneVide7;
	private JLabel zoneVide8;
	private JLabel zoneVide9;
	private JLabel zoneVide10;
	private JLabel zoneVide11;
	private JLabel zoneVide12;
	
	private JPanel capteurs;
	private JPanel capteursDisponibles;
	private JLabel texteCapteursDispo;
	private JLabel texteCapteursDispo2;
	private JLabel texteCapteursDispo3;
	private JLabel texteCapteursDispo4;
	private JLabel texteCapteursDispo5;
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
		dialSC.setMinimumSize(new Dimension(875, 600));
		dialSC.setResizable(false);
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
			texteCapteursDispo2 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/capteurSon_50x38.png"))));
			texteCapteursDispo3 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/capteurCouleur_50x42.png"))));
			texteCapteursDispo4 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/capteurProximite_50x35.png"))));
			texteCapteursDispo5 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/paveNum_50x44.png"))));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		capteursDisponibles.add(texteCapteursDispo);
		capteursDisponibles.add(texteCapteursDispo2);
		capteursDisponibles.add(texteCapteursDispo3);
		capteursDisponibles.add(texteCapteursDispo4);
		capteursDisponibles.add(texteCapteursDispo5);
		
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
		//texteMoteursDispo = new JLabel("");
		try {
			texteMoteursDispo = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/moteur_110x85.png"))));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
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
			zone1 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone2 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone3 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone4 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone5 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone6 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone7 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone8 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone9 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone10 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zone11 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zone.png"))));
			zoneVide1 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide2 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide3 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide4 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide5 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide6 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			// TEST
			zoneVide7 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide8 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide9 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide10 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide11 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
			zoneVide12 = new JLabel(new ImageIcon(ImageIO.read(new File("./ressources/simulateur/config/zoneVide.png"))));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		JPanel zonevide1 = new JPanel();
		zonevide1.add(zoneVide1);
		JPanel zonevide2 = new JPanel();
		zonevide2.add(zoneVide2);
		JPanel zonevide3 = new JPanel();
		zonevide3.add(zoneVide3);
		JPanel zonevide4 = new JPanel();
		zonevide4.add(zoneVide4);
		JPanel zonevide5 = new JPanel();
		zonevide5.add(zoneVide5);
		JPanel zonevide6 = new JPanel();
		zonevide6.add(zoneVide6);
		// TEST
		JPanel zonevide7 = new JPanel();
		zonevide7.add(zoneVide7);
		JPanel zonevide8 = new JPanel();
		zonevide8.add(zoneVide8);
		JPanel zonevide9 = new JPanel();
		zonevide9.add(zoneVide9);
		JPanel zonevide10 = new JPanel();
		zonevide10.add(zoneVide10);
		JPanel zonevide11 = new JPanel();
		zonevide11.add(zoneVide11);
		JPanel zonevide12 = new JPanel();
		zonevide12.add(zoneVide12);
		
		JPanel zoneCapteur1 = new JPanel();
		zoneCapteur1.add(zone1);
		JPanel zoneCapteur2 = new JPanel();
		zoneCapteur2.add(zone2);
		JPanel zoneCapteur3 = new JPanel();
		zoneCapteur3.add(zone3);
		JPanel zoneCapteur4 = new JPanel();
		zoneCapteur4.add(zone4);
		JPanel zoneCapteur5 = new JPanel();
		zoneCapteur5.add(zone5);
		JPanel zoneCapteur6 = new JPanel();
		zoneCapteur6.add(zone6);
		JPanel zoneCapteur7 = new JPanel();
		zoneCapteur7.add(zone7);
		JPanel zoneCapteur8 = new JPanel();
		zoneCapteur8.add(zone8);
		JPanel zoneCapteur9 = new JPanel();
		zoneCapteur9.add(zone9);
		JPanel zoneCapteur10 = new JPanel();
		zoneCapteur10.setLayout(new FlowLayout());
		zoneCapteur10.add(zone10);
		JPanel zoneCapteur11 = new JPanel();
		zoneCapteur11.add(zone11);
		
		JPanel Robot = new JPanel();
		Robot.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		Robot.add(dessinRobot, gbc);
		
		JPanel ZoneNord = new JPanel();
		ZoneNord.setLayout(new GridLayout(1,5));
		ZoneNord.add(zonevide1);
		ZoneNord.add(zoneCapteur1);
		ZoneNord.add(zoneCapteur2);
		ZoneNord.add(zoneCapteur3);
		ZoneNord.add(zonevide2);
		
		JPanel ZoneSud = new JPanel();
		ZoneSud.setLayout(new GridLayout(2,3));
		ZoneSud.add(zonevide3);
		ZoneSud.add(zoneCapteur4);
		ZoneSud.add(zonevide4);
		ZoneSud.add(zonevide5);
		ZoneSud.add(zoneCapteur5);
		ZoneSud.add(zonevide6);
		
		JPanel ZoneEst = new JPanel();
		ZoneEst.setLayout(new GridLayout(3,1));
		ZoneEst.add(zoneCapteur6);
		//ZoneEst.add(zonevide7);
		ZoneEst.add(zoneCapteur7);
		//ZoneEst.add(zonevide8);
		ZoneEst.add(zoneCapteur8);
		
		JPanel ZoneOuest = new JPanel();
		ZoneOuest.setLayout(new GridLayout(3,1));
		//ZoneOuest.add(zonevide9);
		ZoneOuest.add(zoneCapteur9);
		//ZoneOuest.add(zonevide10);
		ZoneOuest.add(zoneCapteur10);
		//ZoneOuest.add(zonevide11);
		ZoneOuest.add(zoneCapteur11);
		
		JPanel Zones = new JPanel();
		Zones.setLayout(new BorderLayout());
		Zones.add(ZoneNord, BorderLayout.NORTH);
		Zones.add(Robot, BorderLayout.CENTER);
		Zones.add(ZoneSud, BorderLayout.SOUTH);
		Zones.add(ZoneEst, BorderLayout.EAST);
		Zones.add(ZoneOuest, BorderLayout.WEST);
		
		dialSC.setLayout(new BorderLayout());
		dialSC.getContentPane().add(capteurs, BorderLayout.WEST);
		dialSC.getContentPane().add(moteurs, BorderLayout.EAST);
		dialSC.add(Zones, BorderLayout.CENTER);
		//dialSC.add(Robot);
		dialSC.setVisible(true);
	}
	
	
	
}
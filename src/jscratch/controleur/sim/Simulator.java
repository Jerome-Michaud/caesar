package jscratch.controleur.sim;

import java.awt.Graphics;
import java.io.File;

import javax.swing.JFrame;

import jscratch.interpreteur.Interpreteur;
import jscratch.modeles.sim.Map;
import jscratch.modeles.sim.MapFactory;
import jscratch.modeles.sim.Robot;
import jscratch.vue.sim.MapRenderer;
import jscratch.vue.sim.PanelInfosRobot;
import jscratch.vue.sim.RobotRenderer;



/**
 * Classe qui gère le simulateur
 * @author Guillaume Delorme
 *
 */
public class Simulator {
	private Robot robot;
	private Map map;
	private MapController mapController;
	private RobotController robotController;
	private MapRenderer mapRenderer;
	private RobotRenderer robotRenderer;
	private PanelInfosRobot infosRobot;
	
	private Interpreteur inter;
	
	public Simulator() {
		
		map = MapFactory.createMapFromXML(new File("./ressources/simulateur/maps/map1.xml"));
		
		mapController = new MapController(map);
		
		robot = new Robot(mapController);
		robotController = new RobotController(mapController, robot);
		
		mapRenderer = new MapRenderer(map);
		robotRenderer = new RobotRenderer(robot);
		
		// TEST Panel infos
		JFrame fenInfo = new JFrame();
		infosRobot = new PanelInfosRobot(robot);
		fenInfo.add(infosRobot);
		fenInfo.pack();
		fenInfo.setVisible(true);
		// Fin test Panel infos
		
		inter = new Interpreteur(robotController);
		// TODO mettre le thread à part du constructeur
		/*Thread t = new Thread(){
			@Override
			public void run(){
				inter.launchInterpreteur();
			}
		};
		t.start();*/
		
	}

	/**
	 * Mise à jour du simulateur
	 * @param deltaTime
	 */
	public void update(float deltaTime) {
		robotController.update(deltaTime);
		infosRobot.update(deltaTime);
	}

	/**
	 * Rendu du simulateur
	 * @param g
	 */
	public void render(Graphics g) {
		mapRenderer.render(g);
		robotRenderer.render(g);
		
	}

	/**
	 * @return le robotController
	 */
	public RobotController getRobotController() {
		return robotController;
	}
}

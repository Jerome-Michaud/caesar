package jscratch.controleur.sim;

import java.awt.Graphics;
import java.io.File;

import jscratch.modeles.sim.Map;
import jscratch.modeles.sim.MapFactory;
import jscratch.modeles.sim.Robot;
import jscratch.vue.sim.MapRenderer;
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
	
	public Simulator() {
		
		map = MapFactory.createMapFromXML(new File("./ressources/simulateur/maps/map2.xml"));
		
		mapController = new MapController(map);
		
		robot = new Robot(mapController);
		robotController = new RobotController(mapController, robot);
		
		mapRenderer = new MapRenderer(map);
		robotRenderer = new RobotRenderer(robot);
	}

	/**
	 * Mise à jour du simulateur
	 * @param deltaTime
	 */
	public void update(float deltaTime) {
		robotController.update(deltaTime);
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

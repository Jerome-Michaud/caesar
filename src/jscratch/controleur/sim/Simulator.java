package jscratch.controleur.sim;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

import jscratch.interpreteur.Interpreteur;
import jscratch.modeles.sim.Map;
import jscratch.modeles.sim.MapFactory;
import jscratch.modeles.sim.Robot;
import jscratch.vue.sim.MapRenderer;
import jscratch.vue.sim.ObservableSimulator;
import jscratch.vue.sim.ObserverPanelSimulator;
import jscratch.vue.sim.ObserverSimulator;
import jscratch.vue.sim.PanelInfosRobot;
import jscratch.vue.sim.PanelSimulator;
import jscratch.vue.sim.RobotRenderer;



/**
 * Classe qui gère le simulateur
 * @author Guillaume Delorme
 *
 */
public class Simulator implements Runnable,ObservableSimulator{
	
	private Robot robot;
	private Map map;
	private MapController mapController;
	private RobotController robotController;
	private MapRenderer mapRenderer;
	private RobotRenderer robotRenderer;
	private ArrayList<ObserverSimulator> listObserver;// Tableau d'observateurs.
	private boolean run = true;
	private boolean wait = false;
	
	public Simulator() {
		
		this.listObserver = new ArrayList<ObserverSimulator>();

		map = MapFactory.createMapFromXML(new File("./ressources/simulateur/maps/map1.xml"));
		
		mapController = new MapController(map);
		
		robot = new Robot(mapController);
		robotController = new RobotController(mapController, robot);
		
		mapRenderer = new MapRenderer(map);
		robotRenderer = new RobotRenderer(robot);
	}
	
	/**
	 * @return le robot
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * Mise à jour du simulateur
	 * @param deltaTime
	 */
	public void update(float deltaTime) {
		if(run){
			if(!wait){
				robotController.update(deltaTime);
			}
		}
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
	
	public void start() {
		new Thread(this).start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		// Set up the graphics stuff, double-buffering.
				
		long delta = 0l;

		// Boucle infinie du simulateur
		while (true) {
			long lastTime = System.nanoTime();

			// Mise à jour du simulateur
			this.update((float)(delta / 1000000000.0));
			
			// Rendu du simulateur
			//this.render(g);

			// Affichage du résultat du rendu dans le panel
			
			notifyObserver();
			// Lock des fps
			delta = System.nanoTime() - lastTime;
			if (delta < 20000000L) {
				try {
					Thread.sleep((20000000L - delta) / 1000000L);
				} catch (Exception e) {
					// Interrupted exception
				}
			}
		}
	}
	/**
	 * ajoute un observateur sur le simulateur
	 * 
	 * @param ObserverSimulator
	 */
	@Override
	public void addObserver(ObserverSimulator o) {
		 listObserver.add(o); 
	}
	/**
	 * supprimer un observateur du simulateur
	 * 
	 * @param ObserverSimulator
	 */
	@Override
	public void deleteObserver(ObserverSimulator o) {
		listObserver.remove(o); 
	}
	/**
	 * met à jour les observateurs
	 */
	@Override
	public void notifyObserver() {
		for(ObserverSimulator o : listObserver){
			o.update(this);
		}
	}
	/**
	 * met en attente le simulator
	 * @param b
	 */
	public synchronized void setWait(boolean b){
		this.wait = b;
	}
	/**
	 * arrete le simulateur
	 * @param b
	 */
	public synchronized void setRun(boolean b){
		this.run = b;
	}
}

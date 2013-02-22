package jscratch.controleur.sim;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import jscratch.helpers.ErreurHelper;

import jscratch.modeles.sim.Map;
import jscratch.modeles.sim.MapFactory;
import jscratch.modeles.sim.MotorPort;
import jscratch.modeles.sim.Robot;
import jscratch.vue.sim.MapRenderer;
import jscratch.vue.sim.ObservableInterpreteur;
import jscratch.vue.sim.ObservableSimulator;
import jscratch.vue.sim.ObserverInterpreteur;
import jscratch.vue.sim.ObserverPanelController;
import jscratch.vue.sim.ObserverSimulator;
import jscratch.vue.sim.RobotRenderer;



/**
 * Classe qui gère le simulateur
 * @author Guillaume Delorme
 *
 */
public class Simulator implements Runnable, ObservableSimulator,ObserverInterpreteur {
	
	private Robot robot;
	private Map map;
	private MapController mapController;
	private RobotController robotController;
	private MapRenderer mapRenderer;
	private RobotRenderer robotRenderer;
	private ArrayList<ObserverSimulator> listObserver;// Tableau d'observateurs.
	private ArrayList<ObserverPanelController> listPanelController;// Tableau d'observateurs.
	private boolean run;
	private boolean wait;
	
	public Simulator() {
		
		this.listObserver = new ArrayList<ObserverSimulator>();
		this.listPanelController = new ArrayList<ObserverPanelController>();

		map = MapFactory.createMapFromXML(new File("./ressources/simulateur/maps/CAESAR.xml"));
		
		mapController = new MapController(map);
		
		robot = new Robot(mapController);
		robotController = new RobotController(mapController, robot);
		
		mapRenderer = new MapRenderer(map);
		robotRenderer = new RobotRenderer(robot);
		
		this.run = true;
		this.wait = false;
	}
	
	/**
	 * @return le robot
	 */
	public Robot getRobot() {
		return robot;
	}
	
	public Map getMap() {
		return map;
	}

	public RobotRenderer getRobotRenderer() {
		return robotRenderer;
	}

	/**
	 * Mise à jour du simulateur
	 * @param deltaTime
	 */
	public void update() {
		robotController.update();
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
		System.out.println("Demarrage du simulateur");
		System.out.println("Simulateur = "+Thread.currentThread().getName());		
				
		// Conversion du temps en secondes
        double nextTime = (double)System.nanoTime() / 1000000000.0;
        double maxTimeDiff = 0.5;
        int skippedFrames = 1;
        int maxSkippedFrames = 5;
        double currTime;
        int sleepTime;        
        this.run = true;
		this.robotController.resetStartTime();
        
        // Delta entre chaque mise à jour (1 / 30 -> 30 fps) 
        double delta = 1 / 30;
        
        while(run)
        {
            // Conversion du temps en secondes
            currTime = (double)System.nanoTime() / 1000000000.0;
            if((currTime - nextTime) > maxTimeDiff) {
				nextTime = currTime;
			}
            if(currTime >= nextTime)
            {
                // Temps pour la prochaine mise à jour
                nextTime += delta;
                
                // Mise à jour du simulateur 
                this.update();
                
                if((currTime < nextTime) || (skippedFrames > maxSkippedFrames))
                {
                	// Affichage
                	notifyObserverSimulator();
                    skippedFrames = 1;
                }
                else
                {
                    skippedFrames++;
                }
            }
            else
            {
                // Calcul du temps à attendre
                sleepTime = (int)(1000.0 * (nextTime - currTime));
                
                if(sleepTime > 0)
                {
                    // Attente en attendant la prochaine mise à jour
                    try
                    {
                        Thread.sleep(sleepTime);
                    }
                    catch(InterruptedException e) {}
                }
            }
        }
        
        this.notifyObserverPanelController();
		
		System.out.println("Arret du simulateur");
		System.out.println("Simulateur = "+Thread.currentThread().getName());
	}
	
	@Override
	public void addObserver(ObserverSimulator o) {
		 listObserver.add(o);
	}
	
	@Override
	public void deleteObserver(ObserverSimulator o) {
		listObserver.remove(o); 
	}
	
	@Override
	public void notifyObserverSimulator() {
		for(ObserverSimulator o : listObserver){
			o.update(this);
		}
	}
	
	private synchronized void testWait() {
		if(wait){
			try {
				System.out.println("Met en attente le simulateur");
				System.out.println("Simulateur = "+Thread.currentThread().getName());
					this.wait();
			} catch (InterruptedException e) {
				ErreurHelper.afficher(e);
			}
		}
	}
	/**
	 * met le simulator en pause
	 */
	public synchronized void waitThread() {
		this.wait = true;
	}

	public synchronized void notifyThread() {
		this.notify();
		System.out.println("Redemarre le simulateur");
		System.out.println("Simulateur = "+Thread.currentThread().getName());
		this.wait = false;
	}
	
	/**
	 * arrete le simulator
	 */
	public synchronized void stopThread() {
		this.notify();
		this.run= false;
		this.wait = false;
		this.robotController.addCommand(new StopCommand(this.robotController, 0, MotorPort.OUT_A));
		this.robotController.executeCommands();
		this.robotController.addCommand(new StopCommand(this.robotController, 0, MotorPort.OUT_B));
		this.robotController.executeCommands();
		this.robotController.addCommand(new StopCommand(this.robotController, 0, MotorPort.OUT_C));
		this.robotController.executeCommands();
		this.robotController.clearListCommands();
	}

	@Override
	public void update(String type,int vitesse,MotorPort port) {
		if(type.equals("Forward")){
			robotController.addCommand(new ForwardCommand(robotController, vitesse, port));
			robotController.executeCommands();
		}
		else if(type.equals("Stop")){
			robotController.addCommand(new StopCommand(robotController, vitesse, port));
			robotController.executeCommands();
		}
		else if(type.equals("End")){
			this.stopThread();
		}
	}

	@Override
	public void update(ObservableInterpreteur o) {}

	@Override
	public void addObserver(ObserverPanelController o) {
		listPanelController.add(o);
	}

	@Override
	public void deleteObserver(ObserverPanelController o) {
		listPanelController.remove(o);
	}

	@Override
	public void notifyObserverPanelController() {
		for(ObserverPanelController o : listPanelController){
			o.update(this);
		}
	}
}

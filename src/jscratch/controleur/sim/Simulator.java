/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.controleur.sim;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
 * Classe qui gère le simulateur.
 * 
 * @since 1.0
 * @version 1.0
 */
public class Simulator implements Runnable, ObservableSimulator, ObserverInterpreteur {
	
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
	 * Accède au robot du simuateur.
	 * 
	 * @return le robot
	 */
	public Robot getRobot() {
		return robot;
	}
	
	/**
	 * Accède à la map sur laquelle évolue le robot.
	 * 
	 * @return la map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * Donne l'objet effectuant le rendu du robot.
	 * 
	 * @return l'objet de rendu
	 */
	public RobotRenderer getRobotRenderer() {
		return robotRenderer;
	}

	/**
	 * Mise à jour du simulateur
	 */
	public void update() {
		robotController.update();
	}

	/**
	 * Rendu du simulateur
	 * 
	 * @param g l'objet de dessin pour le rendu
	 */
	public void render(Graphics g) {
		mapRenderer.render(g);
		robotRenderer.render(g);
		
	}

	/**
	 * Donne le contrôleur du robot du simulateur.
	 * 
	 * @return le contrôleur du robot
	 */
	public RobotController getRobotController() {
		return robotController;
	}
	
	/**
	 * Lance le simulateur.
	 * Un nouveau thread est créé pour effectuer la simulation.
	 */
	public void start() {
		new Thread(this).start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// Set up the graphics stuff, double-buffering.
	/*	System.out.println("Demarrage du simulateur");
		System.out.println("Simulateur = "+Thread.currentThread().getName());		*/
				
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
        	this.testWait();
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
                    catch(InterruptedException e) {
						ErreurHelper.afficherSansSortie(e);
					}
                }
            }
        }
        
        this.notifyObserverPanelController();
		
	/*	System.out.println("Arret du simulateur");
		System.out.println("Simulateur = "+Thread.currentThread().getName());*/
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
			/*	System.out.println("Met en attente le simulateur");
				System.out.println("Simulateur = "+Thread.currentThread().getName());*/
					this.wait();
			} catch (InterruptedException e) {
				ErreurHelper.afficherSansSortie(e);
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
		/*System.out.println("Redemarre le simulateur");
		System.out.println("Simulateur = "+Thread.currentThread().getName());*/
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
	public void update(String type, int vitesse, List<MotorPort> ports) {
		if(type.equals("Forward")){
			for (MotorPort mp : ports) {
				robotController.addCommand(new ForwardCommand(robotController, vitesse, mp));
			}
			robotController.executeCommands();
		}
		else if(type.equals("Stop")){
			for (MotorPort mp : ports) {
				robotController.addCommand(new StopCommand(robotController, vitesse, mp));
			}
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

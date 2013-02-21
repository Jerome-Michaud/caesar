package jscratch.interpreteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jscratch.controleur.sim.Simulator;
import jscratch.vue.sim.ObserverInterpreteur;

public class GestionSimulation{
	
	private Interpreteur interpreteur;
	private Simulator simulator;
	private List<Runnable> runnables;
	private ExecutorService service;
	private InterpreteurListener listener;
	
    public GestionSimulation(Simulator simulator){
    	this.simulator = simulator;
    	this.interpreteur = new Interpreteur(simulator);
    	this.runnables = new ArrayList<Runnable>();
		this.listener = new InterpreteurListener(this);

		runnables.add(this.interpreteur);
		runnables.add(this.simulator);
		service = Executors.newFixedThreadPool(2);
    }         
     
    private static void executeRunnables(final ExecutorService service, List<Runnable> runnables){
    	for(Runnable r : runnables){
            service.execute(r);
        }
        service.shutdown();
    }
    /**
	 * permet de demarrer le controlleur de la simulation
	 */
    public void startThread(){
    	System.out.println("Demarre le controlleur");
		System.out.println("Controlleur = "+Thread.currentThread().getName());
    	executeRunnables(service, runnables);
    }
    /**
	 * arrete le controller de la simulation
	 */
	public void stopThread() {
		System.out.println("Arret du controller de la simulation");
		System.out.println("Controlleur = "+Thread.currentThread().getName());
		interpreteur.stopThread();
		simulator.stopThread();
	}
	
	/**
	 * met la simulation en pause
	 */
	public synchronized void waitThread() {
		System.out.println("Met en attente le controlleur");
		System.out.println("Controlleur = "+Thread.currentThread().getName());
		interpreteur.waitThread();
		simulator.waitThread();
	}
	
	/**
	 * redemarre la simulation
	 */
	public synchronized void notifyThread() {
		System.out.println("Redemarre le controlleur");
		System.out.println("Controlleur = "+Thread.currentThread().getName());
		interpreteur.notifyThread();
		simulator.notifyThread();
	}
	
	public InterpreteurListener getListener(){
		return listener;
	}
}

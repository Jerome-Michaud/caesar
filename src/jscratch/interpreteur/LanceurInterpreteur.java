package jscratch.interpreteur;

import jscratch.controleur.sim.Simulator;

/**
 * Classe lancant un thread contenant l'interpreteur
 * @author Nicolas
 *
 */
public class LanceurInterpreteur extends Thread {

	private Interpreteur inter;
	protected volatile boolean stop = true;
	private boolean wait = false;
	private Simulator simulator;
	
	public LanceurInterpreteur(Simulator simulator) {
		super();
		this.simulator = simulator;
		this.inter = new Interpreteur(simulator);
	}
	
	public void run() {		
		while(stop){
			try {
				if(wait)
				{
					synchronized (this) {
						this.wait();
					}
				}
			} 
			catch (InterruptedException e) {
				System.out.println("Thread de l'interpreteur interrompu");
			}
			inter.launchInterpreteur();
			this.stopThread();
		}
	}
	/**
	 * permet d'arreter le thread 
	 */
	public synchronized void stopThread(){
		this.stop = false;
		this.wait = false;
		inter.setRun(false);
		inter.getVisiteur().setRun(false);
		inter.setWait(false);
		inter.getVisiteur().setWait(false);
	}
	
	/**
	 * permet de mettre en pause l'interpreteur
	 */
	public synchronized void waitThread() {
		this.wait = !wait;
		inter.setWait(true);
		inter.getVisiteur().setWait(true);
		simulator.setWait(true);
	}
	/**
	 * permet de relancer l'interpreteur
	 */
	public synchronized void notifyThread() {
			this.wait = false;
			inter.setWait(false);
			inter.getVisiteur().setWait(false);
			simulator.setWait(false);
			this.notify();
			synchronized (inter) {
				inter.notify();
			}
			synchronized (inter.getVisiteur()) {
				inter.getVisiteur().notify();
			}
	}
	
	public boolean getStop(){
		return stop;
	}
}

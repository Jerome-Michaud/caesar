package jscratch.interpreteur;

/**
 * Classe lancant un thread contenant l'interpreteur
 * @author Nicolas
 *
 */
public class LanceurInterpreteur extends Thread {

	private Interpreteur inter;
	protected volatile boolean stop = true;
	private boolean wait = false;

	
	public LanceurInterpreteur(Interpreteur inter) {
		super();
		this.inter = inter;
	}
	
	public void run() {
		while(stop){
			try {
				if(wait){
					synchronized (this) {
						this.wait();
					}
				}
			} catch (InterruptedException e) {
				System.out.println("Thread de l'interpreteur interrompu");
			}
		}
	}
	/**
	 * permet d'arreter le thread 
	 */
	public synchronized void stopThread(){
		this.stop = false;
		this.wait = false;
	}
	
	/**
	 * permet de mettre en pause l'interpreteur
	 */
	public void waitThread() {
		this.wait = !wait;
	}
	/**
	 * permet de relancer l'interpreteur
	 */
	public void notifyThread() {
		synchronized (this) {
			this.wait = false;
			this.notify();
		}
	}
}

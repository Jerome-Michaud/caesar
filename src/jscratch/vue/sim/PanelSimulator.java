package jscratch.vue.sim;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import jscratch.controleur.sim.Simulator;


/**
 * Panel pour l'affichage du simulateur
 * @author Guillaume Delorme
 *
 */
public class PanelSimulator extends JPanel implements Runnable {
	Simulator simulator;

	public PanelSimulator() {
		super();
		this.simulator = new Simulator();
	}

	/**
	 * @return le simulator
	 */
	public Simulator getSimulator() {
		return simulator;
	}

	public void start() {
		new Thread(this).start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		setSize(800, 600);

		// Set up the graphics stuff, double-buffering.
		BufferedImage screen = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = screen.getGraphics();
		Graphics graphics = this.getGraphics();

		long delta = 0l;

		// Boucle infinie du simulateur
		while (true) {
			long lastTime = System.nanoTime();

			// Mise à jour du simulateur
			simulator.update((float)(delta / 1000000000.0));
			
			// Rendu du simulateur
			simulator.render(g);

			// Affichage du résultat du rendu dans le panel
			graphics.drawImage(screen, 0, 0, null);

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
}
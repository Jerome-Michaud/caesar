package jscratch.vue.sim;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
import jscratch.controleur.sim.Simulator;


/**
 * Panel pour l'affichage du simulateur
 * @author Guillaume Delorme
 *
 */
public class PanelSimulator extends JPanel implements MouseWheelListener, MouseMotionListener,ObservablePanelSimulator,ObserverSimulator{
	
	private BufferedImage screen;
	private ArrayList<ObserverPanelSimulator> listObserver;// Tableau d'observateurs.
	private Simulator simulator;

	public PanelSimulator(Simulator simulator) {
		super();	
		this.screen = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		this.simulator = simulator;
		this.addMouseWheelListener(this);
		this.addMouseMotionListener(this);
		this.listObserver = new ArrayList<ObserverPanelSimulator>();
		setDoubleBuffered(true);
		this.validate();
		simulator.addObserver(this);
	}
	
	/**
	 * @since 1.0
	 *
	 * @return L'unique instance de PanelSimulator.
	 */
	public Simulator getSimulator(){
		return simulator;
	}
	/**
	 * permet de modifier l'angle du robot avec la souris
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {		
		simulator.getRobotController().changerAngleRobot(event.getUnitsToScroll() * 0.02);
		repaint();
		notifyObserver();
	}
	/**
	 * permet de deplacer le robot avec la souris
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
		simulator.getRobotController().deplacerRobot(event.getX(), event.getY());
		repaint();
		notifyObserver();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
	
	/**
	 * affiche l'image de la carte sur le panelsimulator
	 */
	@Override
	public void paintComponent(Graphics g){
		
		Graphics gScreen = screen.getGraphics();
		simulator.render(gScreen);		
		
		g.drawImage(screen, 0, 0, 800, 600, null);		
       // g.drawRect(50, 50, 50, 50);
	}

	/**
	 * ajoute un observateur sur le simulateur
	 * 
	 * @param ObserverPanelSimulator
	 */
	@Override
	public void addObserver(ObserverPanelSimulator o) {
		 listObserver.add(o); 
	}
	/**
	 * supprimer un observateur du simulateur
	 * 
	 * @param ObserverPanelSimulator
	 */
	@Override
	public void deleteObserver(ObserverPanelSimulator o) {
		listObserver.remove(o); 
	}
	/**
	 * met à jour les observateurs
	 */
	@Override
	public void notifyObserver() {
		for(ObserverPanelSimulator o : listObserver){
			o.update(this);
		}
	}
	/**
	 * rafraichi l'affichage du panelSimulator
	 */
	@Override
	public void update(ObservableSimulator o) {
		repaint();
	}
}
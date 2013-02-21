package jscratch.vue.sim;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import jscratch.controleur.sim.Simulator;
import jscratch.modeles.sim.Map;
import jscratch.modeles.sim.collision.CouleurObstacle;


/**
 * Panel pour l'affichage du simulateur
 * @author Guillaume Delorme
 *
 */
public class PanelSimulator extends JPanel implements MouseWheelListener, MouseMotionListener, MouseListener, ObservablePanelSimulator, ObserverSimulator {
	
	private BufferedImage screen;
	private ArrayList<ObserverPanelSimulator> listObserver;// Tableau d'observateurs.
	private Simulator simulator;
	private Map map;

	public PanelSimulator(Simulator simulator) {
		super();
		this.map = simulator.getMap();
		this.screen = new BufferedImage(map.getTailleX(), map.getTailleY(), BufferedImage.TYPE_INT_RGB);
		this.simulator = simulator;
		this.addMouseWheelListener(this);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.listObserver = new ArrayList<ObserverPanelSimulator>();
		setDoubleBuffered(true);
		this.validate();
		simulator.addObserver(this);
		this.setBackground(CouleurObstacle.DARK_GRAY.getCouleur());
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
		Dimension d = this.getSize();
		simulator.getRobotController().deplacerRobot(event.getX() - (int) ((d.getWidth() - map.getTailleX()) / 2),
				event.getY() - (int) ((d.getHeight() - map.getTailleY()) / 2));
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
		super.paintComponent(g);
		
		Graphics gScreen = screen.getGraphics();
		simulator.render(gScreen);		
		
		Dimension d = this.getSize();
		this.setPreferredSize(new Dimension(map.getTailleX(), map.getTailleY()));
		
		g.drawImage(screen, (int) ((d.getWidth() - map.getTailleX()) / 2), (int) ((d.getHeight() - map.getTailleY()) / 2),
				map.getTailleX(), map.getTailleY(), null);
	}
	
	@Override
	public void addObserver(ObserverPanelSimulator o) {
		 listObserver.add(o); 
	}
	
	@Override
	public void deleteObserver(ObserverPanelSimulator o) {
		listObserver.remove(o); 
	}
	
	@Override
	public void notifyObserver() {
		for(ObserverPanelSimulator o : listObserver){
			o.update(this);
		}
	}	
	
	@Override
	public void update(ObservableSimulator o) {
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseDragged(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
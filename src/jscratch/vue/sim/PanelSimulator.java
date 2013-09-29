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
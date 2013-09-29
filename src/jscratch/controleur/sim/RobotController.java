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

import java.awt.geom.Point2D;
import java.util.*;

import jscratch.modeles.sim.MotorPort;
import jscratch.modeles.sim.Robot;


/**
 * Controller du robot
 * @author Guillaume Delorme
 * @author Nicolas Detan
 */
public class RobotController {

	private LinkedList<Command> listCommand;
	private Robot robot;
	private int index;
	private MapController mapController;
	private double startTime = 0;
	
	/**
	 * constructeur
	 */

	public RobotController(MapController m,Robot r){
		this.listCommand = new LinkedList<Command>();
		this.index = 0;
		this.robot = r;
		this.mapController = m;
	}

	/**
	 * met à jour le robot
	 * @param deltaTime
	 */

	public synchronized void update()	{
		/* Déplacement du robot */
		int coef = 140000;
		double vgauche = (double) robot.getMotor(MotorPort.OUT_C).getPower() / coef;
		double vdroite = (double) robot.getMotor(MotorPort.OUT_B).getPower() / coef;
		double v = robot.getRayonRoues() * (vgauche + vdroite) / 2; // Vitesse d'avancement
		double w = robot.getRayonRoues() * (vdroite - vgauche) / robot.getEcartEntreRoues(); // Vitesse de rotation

		double dx = v*Math.cos(robot.getOrientation()); // déplacement en x
		double dy = v*Math.sin(robot.getOrientation()); // déplacement en y
		
		deplacementRobot(dx, dy, w);
	}	

	/**
	 * Permet d'exécuter les commandes
	 */
	public synchronized void executeCommands()
	{
		Command c;
		while (index < listCommand.size()) {
			c = listCommand.get(index);
			
			c.execute();
			index++;
		}
	}

	/**
	 * permet d'ajouter une commande
	 * 
	 * @param c Command representant la commande à ajouter
	 */
	public synchronized void addCommand(Command c)
	{
		listCommand.add(c);
	}

	/**
	 * fait avancer le robot
	 * 
	 * @param vitesse int
	 * @param port MotorPort
	 */
	public void onFwd(MotorPort port,int vitesse)
	{
		robot.getMotor(port).setPower(vitesse);		
	}

	/**
	 * fait reculer le robot
	 * 
	 * @param vitesse int
	 * @param port MotorPort
	 * 
	 */
	public void onRev(MotorPort port,int vitesse)
	{
		robot.getMotor(port).setPower(-vitesse);		
	}

	/**
	 * stop le robot
	 * 
	 * @param port MotorPort
	 */
	public void off(MotorPort port)
	{
		robot.getMotor(port).setPower(0);
	}
	
	/**
	 * permet de replacer le robot dans son etat initial
	 */
	public void resetRobot()
	{
		robot.reset(200, 200);
		addCommand(new StopCommand(this,0, MotorPort.OUT_B));
		addCommand(new StopCommand(this,0, MotorPort.OUT_C));
	}
	
	/**
	 * Augmentation de l'angle du robot
	 */
	public void changerAngleRobot(double pas) {
		deplacementRobot(0, 0, pas);
	}
	
	/**
	 * Déplacer le robot à une position
	 * @param x les coordonnées en x
	 * @param y les coordonnées en y
	 */
	public void deplacerRobot(double x, double y) {
		// on vérifie si l'utilisateur n'essai pas de déplacer le robot en dehors de la map			
		if (mapController.pointDeplacementRobot(new Point2D.Double(x, y))) {
			double dx = x - robot.getLargeur() / 2 - robot.getX();
			double dy = y - robot.getLongueur() / 2 - robot.getY();
			
			deplacementRobot(dx, dy, 0);
		}
	}
	
	/**
	 * Déplacement le robot
	 * @param x le décalage en x
	 * @param y le décalage en y
	 * @param w l'angle
	 */
	private void deplacementRobot(double dx, double dy, double w) {	
		robot.setX(robot.getX() + dx);
		robot.setY(robot.getY() + dy);
		robot.setOrientation(robot.getOrientation() - w);
		
		robot.updatePointCentral(dx, dy);
		robot.updateListePoints();
		robot.updateSensor();
		
		if (!mapController.positionPossible(robot)) {
			robot.setX(robot.getX() - dx);
			robot.setY(robot.getY() - dy);
			robot.setOrientation(robot.getOrientation() + w);
			
			robot.updatePointCentral(-dx, -dy);
			robot.updateListePoints();
			robot.updateSensor();
		}
	}
	/**
	 * vide la liste de commande du robot
	 */
	public void clearListCommands() {
		listCommand.clear();
		index = 0;
	}

	public void getSimulator() {
		// TODO Stub de la méthode généré automatiquement
		
	}
	/**
	 * retourne le temps d'execution
	 * @return currentTime
	 */
	public double getCurrentTime() {
		return (double)(System.nanoTime() - startTime) / 1000000000.0;

	}
	/**
	 * reset le temps de depart du simulator
	 * @param currentTicks
	 */
	public void resetStartTime() {
		startTime = System.nanoTime();    
	}
}

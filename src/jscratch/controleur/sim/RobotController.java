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

	public synchronized void update(float deltaTime)	{		
		/* Déplacement du robot */
		double vgauche = (double) robot.getMotor(MotorPort.OUT_C).getPower() * deltaTime * 2;
		double vdroite = (double) robot.getMotor(MotorPort.OUT_B).getPower() * deltaTime * 2;
		double v = robot.getRayonRoues() * (vgauche + vdroite) / 2; // Vitesse d'avancement
		double w = robot.getRayonRoues() * (vdroite - vgauche) / robot.getEcartEntreRoues(); // Vitesse de rotation

		double dx = v*Math.cos(robot.getOrientation()); // déplacement en x
		double dy = v*Math.sin(robot.getOrientation()); // déplacement en y
		
		deplacementRobot(dx, dy, w);
	}	

	/**
	 * permet d'exécuter la commande à la generation actuelle
	 */
	public void executeCommands()
	{
		Command c = listCommand.get(index-1);
		c.execute();
	}

	/**
	 * permet d'ajouter une commande
	 * 
	 * @param c Command representant la commande à ajouter
	 */

	public void addCommand(Command c)
	{
		listCommand.add(c);
		index++;
		executeCommands();
	}

	/**
	 * permet de supprimer une commande
	 * 
	 */

	public void removeCommand()
	{
		listCommand.remove(index);
		index--;

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
}

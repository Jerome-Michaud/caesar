package jscratch.controleur.sim;

import jscratch.modeles.sim.MotorPort;

/**
 * classe Commande permet de donner des instructions au robot
 * @author Nicolas
 *
 */
public abstract class Command {
	
	protected RobotController robot;
	protected int vitesse;
	protected MotorPort port;
	
	/**
	 * constructeur
	 * 
	 * @param robot Robot representant le robot associé à la commande
	 * @param vitesse int representant la vitesse du robot
	 */
	public Command(RobotController r,int v,MotorPort p)
	{
		this.robot = r;
		this.vitesse = v;
		this.port = p;
	}
	
	
	/**
	 * permet d'exécuter la commande
	 */
	
	public abstract void execute();

}

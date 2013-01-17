package jscratch.controleur.sim;

import jscratch.modeles.sim.MotorPort;


	/**
	 * Commande permettant de faire reculer le robot
	 */

public class ReverseCommand extends Command {

	public ReverseCommand(RobotController r,int v,MotorPort p) 
	{
		super(r,v,p);
		// TODO Stub du constructeur généré automatiquement
	}

	@Override
	public void execute() {
		// TODO Stub de la méthode généré automatiquement
		robot.onRev(port, vitesse);
	}

}

package jscratch.controleur.sim;

import jscratch.modeles.sim.MotorPort;

	/**
	 * Commande permettant de faire avancer le robot
	 */

public class ForwardCommand extends Command {
		
	public ForwardCommand(RobotController r,int v,MotorPort p) 
	{
		super(r, v, p);
		// TODO Stub du constructeur généré automatiquement
	}

	@Override
	public void execute() {
		// TODO Stub de la méthode généré automatiquement
		robot.onFwd(port, vitesse);

	}

}

package jscratch.controleur.sim;

import jscratch.modeles.sim.MotorPort;

	/**
	 * Commande permettant d'arreter le robot
	 */

public class StopCommand extends Command {

	public StopCommand(RobotController r,int v,MotorPort p)
	{
		super(r,v,p);
		// TODO Stub du constructeur généré automatiquement
	}

	@Override
	public void execute() {
		// TODO Stub de la méthode généré automatiquement
		robot.off(port);
	}

}

package jscratch.controleur.sim;

import jscratch.modeles.sim.MotorPort;

/**
 * Commande permettant de faire stopper le robot
 * @author Nicolas
 *
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

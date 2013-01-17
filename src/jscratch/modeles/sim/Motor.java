package jscratch.modeles.sim;

/**
 * Classe qui représente un moteur du robot
 * @author Guillaume Delorme
 *
 */
public class Motor {
	/**
	 * La puissance du moteur (entre -100 et 100)
	 */
	private int power;
	
	/**
	 * Le nombre de rotations du moteur
	 */
	private int rotationCount;
	
	/**
	 * Le port sur lequel est branché le moteur
	 */
	private MotorPort port;
	
	public Motor(MotorPort port) {
		super();
		this.port = port;
		power = 0;
		rotationCount = 0;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getRotationCount() {
		return rotationCount;
	}

	public void setRotationCount(int rotationCount) {
		this.rotationCount = rotationCount;
	}

	public MotorPort getPort() {
		return port;
	}	
}

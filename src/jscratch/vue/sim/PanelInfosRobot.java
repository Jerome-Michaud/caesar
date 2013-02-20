package jscratch.vue.sim;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jscratch.modeles.sim.MotorPort;
import jscratch.modeles.sim.Robot;
import jscratch.modeles.sim.Sensor;

/**
 * Panel qui permet d'afficher les informations du robot pendant la simulation
 * @author Guillaume Delorme
 *
 */
public class PanelInfosRobot extends JPanel implements ObserverPanelSimulator,ObserverSimulator {
	private final float FREQ_UPDATE = 0.02f;
	private float nextUpdate = FREQ_UPDATE;
	
	private Robot robot;
	
	private JPanel infosRobot;
	private JLabel texteRobot;
	
	private JPanel infosCapteurs;
	private JLabel texteCapteurs;
	
	public PanelInfosRobot(Robot robot) {
		this.robot = robot;		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setMinimumSize(new Dimension(160, 600));
		
		infosRobot = new JPanel();
		infosRobot.setLayout(new FlowLayout(FlowLayout.LEFT));
		infosRobot.setBorder(BorderFactory.createTitledBorder("Robot"));
		texteRobot = new JLabel("");
		infosRobot.add(texteRobot);
		add(infosRobot);
		
		infosCapteurs = new JPanel();
		infosCapteurs.setLayout(new FlowLayout(FlowLayout.LEFT));
		infosCapteurs.setBorder(BorderFactory.createTitledBorder("Capteurs"));
		texteCapteurs = new JLabel("");
		infosCapteurs.add(texteCapteurs);
		add(infosCapteurs);
		
		update(0);
	}
	
	/**
	 * Mise à jour du panel
	 * @param deltaTime 
	 */
	public void update(float deltaTime) {
		nextUpdate += deltaTime;
		
		if (nextUpdate >= FREQ_UPDATE) {
			nextUpdate -= FREQ_UPDATE;
			
			texteRobot.setText("<html><strong>Vitesses moteurs :</strong> <br />" +
				"gauche (C) = " + robot.getMotor(MotorPort.OUT_C).getPower() + "; droit (B) = " + robot.getMotor(MotorPort.OUT_B).getPower() + "<br /><br />" +
				"<strong>Rotations moteurs :</strong> <br />" +
				"gauche (C) = " + robot.getMotor(MotorPort.OUT_C).getRotationCount() + "; droit (B) = " + robot.getMotor(MotorPort.OUT_B).getRotationCount() + "<br /> <br />" +
				"<strong>Orientation :</strong> " + (int) Math.toDegrees(robot.getOrientation()) + "°<br /> <br />" +
				"<strong>Position :</strong> x = " + (int) robot.getPointCentral().getX() + "; y = " + (int) robot.getPointCentral().getY() + "<br /></html>");
		
			
			StringBuffer capteurs = new StringBuffer("<html>");
			for (Sensor<? extends Object> s : robot.getSensors()) {
				capteurs.append(s.toString() + "<br />");
			}
			capteurs.append("</html>");
			texteCapteurs.setText(capteurs.toString());
		}		
	}
	
	@Override
	public void update(ObservablePanelSimulator o) {
		update(FREQ_UPDATE);
	}

	@Override
	public void update(ObservableSimulator o) {
		update(FREQ_UPDATE);
	}
}

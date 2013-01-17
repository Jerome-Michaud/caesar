package jscratch.vue.sim;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jscratch.controleur.sim.*;
import jscratch.modeles.sim.MotorPort;




/**
 * Fenêtre de test du simulateur
 * @author Guillaume Delorme
 *
 */
public class Fenetre extends JFrame implements ActionListener{
	private PanelSimulator panelSimulator;
	private JPanel panelControl;
	private JButton buttonForward;
	private JButton buttonReverse;
	private JButton buttonStop;
	private JLabel labelPowerA;
	private JLabel labelPowerB;
	private JSlider slidePowerA;
	private JSlider slidePowerB;
	private JButton buttonReset;
	
	public Fenetre() {
		super();
		setSize(850, 850);
		
		setLayout(new BorderLayout());
		
		panelSimulator = new PanelSimulator();
		
		add(panelSimulator,BorderLayout.CENTER);
		
		
		panelControl = new JPanel();
		
		panelControl.setLayout(new GridLayout(5,2));
		add(panelControl,BorderLayout.NORTH);
		
		buttonForward = new JButton("Avancer");
		buttonReverse = new JButton("Reculer");
		buttonStop = new JButton("Stop");
		buttonReset = new JButton("Réinitialiser");
		labelPowerA = new JLabel("Vitesse Moteur Gauche");
		labelPowerB = new JLabel("Vitesse Moteur Droit");
		slidePowerA = new JSlider(-100,100,0);
		slidePowerB = new JSlider(-100,100,0);
		
		slidePowerA.setMajorTickSpacing(20);
		slidePowerA.setMinorTickSpacing(5);
		slidePowerA.setPaintTicks(true);
		slidePowerA.setPaintLabels(true);
		slidePowerB.setMajorTickSpacing(20);
		slidePowerB.setMinorTickSpacing(5);
		slidePowerB.setPaintTicks(true);
		slidePowerB.setPaintLabels(true);
		
		panelControl.add(buttonReverse);
		panelControl.add(buttonForward);
		panelControl.add(labelPowerA);
		panelControl.add(slidePowerA);
		panelControl.add(labelPowerB);
		panelControl.add(slidePowerB);
		panelControl.add(buttonStop);
		panelControl.add(buttonReset);
		
		buttonForward.addActionListener(this);
		buttonReverse.addActionListener(this);
		buttonStop.addActionListener(this);
		buttonReset.addActionListener(this);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelSimulator.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Stub de la méthode généré automatiquement
		
		RobotController robotC = panelSimulator.getSimulator().getRobotController();
		
		if(e.getSource() == buttonForward || e.getSource() == buttonReverse || e.getSource() == buttonStop)
		{
			Command c1 = null;
			Command c2 = null;
			if(e.getSource() == buttonForward)
			{
				c1 = new ForwardCommand(robotC, slidePowerB.getValue(), MotorPort.OUT_B);
				c2 = new ForwardCommand(robotC, slidePowerA.getValue(), MotorPort.OUT_C);
			}
			else if(e.getSource() == buttonReverse)
			{
				c1 = new ReverseCommand(robotC, slidePowerB.getValue(), MotorPort.OUT_B);
				c2 = new ReverseCommand(robotC, slidePowerA.getValue(), MotorPort.OUT_C);
			}
			else if(e.getSource() == buttonStop)
			{
				c1 = new StopCommand(robotC,0, MotorPort.OUT_B);
				c2 = new StopCommand(robotC,0, MotorPort.OUT_C);
			}
			
			robotC.addCommand(c1);
			robotC.addCommand(c2);
		}
		
		if(e.getSource() == buttonReset)
		{
			robotC.resetRobot();
		}
	}
	
}

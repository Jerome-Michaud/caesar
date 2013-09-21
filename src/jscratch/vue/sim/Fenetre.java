/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

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
		Simulator simulator = new Simulator();
		panelSimulator = new PanelSimulator(simulator);
		
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
		
		//panelSimulator.start();
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
	
	public static void main(String args[]){
		new Fenetre();
	}
	
}

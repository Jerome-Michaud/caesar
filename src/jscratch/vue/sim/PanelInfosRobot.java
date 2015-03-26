/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

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
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jscratch.helpers.LangueHelper;

import jscratch.modeles.sim.MotorPort;
import jscratch.modeles.sim.Robot;
import jscratch.modeles.sim.Sensor;
import jscratch.parametrages.langue.VariableLangue;

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
		infosRobot.setBorder(BorderFactory.createTitledBorder(LangueHelper.getInstance().get(VariableLangue.SIM_PAN_ROB)));
		texteRobot = new JLabel("");
		infosRobot.add(texteRobot);
		add(infosRobot);
		
		infosCapteurs = new JPanel();
		infosCapteurs.setLayout(new FlowLayout(FlowLayout.LEFT));
		infosCapteurs.setBorder(BorderFactory.createTitledBorder(LangueHelper.getInstance().get(VariableLangue.SIM_PAN_CAPT)));
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
		LangueHelper l = LangueHelper.getInstance();
		nextUpdate += deltaTime;
		
		if (nextUpdate >= FREQ_UPDATE) {
			nextUpdate -= FREQ_UPDATE;
			
			texteRobot.setText("<html><strong>" + l.get(VariableLangue.SIM_PAN_ROB_VITESSE) + " :</strong> <br />" +
				l.get(VariableLangue.SUP_GAUCHE) + " (C) = " + robot.getMotor(MotorPort.OUT_C).getPower() + "; " + l.get(VariableLangue.SUP_DROITE) + " (B) = " + robot.getMotor(MotorPort.OUT_B).getPower() + "<br /><br />" +
				"<strong>" + l.get(VariableLangue.SIM_PAN_ROB_ROTATION) + " :</strong> <br />" +
				l.get(VariableLangue.SUP_GAUCHE) + " (C) = " + robot.getMotor(MotorPort.OUT_C).getRotationCount() + "; " + l.get(VariableLangue.SUP_DROITE) + " (B) = " + robot.getMotor(MotorPort.OUT_B).getRotationCount() + "<br /> <br />" +
				"<strong>" + l.get(VariableLangue.SIM_PAN_ROB_ORIENTATION) + " :</strong> " + (int) Math.toDegrees(robot.getOrientation()) + "°<br /> <br />" +
				"<strong>" + l.get(VariableLangue.SIM_PAN_ROB_POSITION) + " :</strong> x = " + (int) robot.getPointCentral().getX() + "; y = " + (int) robot.getPointCentral().getY() + "<br /></html>");
		
			
			StringBuilder capteurs = new StringBuilder("<html>");
			for (Sensor<? extends Object> s : robot.getSensors()) {
				capteurs.append(s.toString());
				capteurs.append("<br />");
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

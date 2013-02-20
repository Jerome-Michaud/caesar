package jscratch.vue.sim;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import de.javasoft.swing.ButtonBar;
import de.javasoft.swing.SimpleDropDownButton;
import jscratch.controleur.sim.Simulator;
import jscratch.controleur.sim.StopCommand;
import jscratch.dictionnaires.DicoTraces;
import jscratch.helpers.ImagesHelper;
import jscratch.interpreteur.LanceurInterpreteur;
import jscratch.modeles.sim.MotorPort;
import jscratch.traces.fabriques.FabriqueTrace;

/**
 * Panel permettant de controller l'execution du simulateur
 *
 * @author Nicolas
 *
 */
public class PanelController extends JPanel {

	private ButtonBar buttonBar;
	private AbstractButton bExec;
	private AbstractButton bPause;
	private AbstractButton bStop;
	private SimpleDropDownButton bDebug;
	private JMenuItem m1;
	private JMenuItem m2;
	private JMenuItem m3;
	private boolean pause = false;
	private Simulator simulator;
	private LanceurInterpreteur lanceurInter;

	/**
	 * Constructeur par défaut de <code>PanelController</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param simulator  le simulateur
	 */
	public PanelController(Simulator simulator) {
		this.simulator = simulator;
		setLayout(new FlowLayout(10, 1, 4));

		ImageIcon iconPlay = (ImageIcon) ImagesHelper.getIcon("control.png");
		ImageIcon iconPause = (ImageIcon) ImagesHelper.getIcon("control-pause.png");
		ImageIcon iconStop = (ImageIcon) ImagesHelper.getIcon("control-stop-square.png");
		ImageIcon iconDebug = (ImageIcon) ImagesHelper.getIcon("bug.png");

		buttonBar = new ButtonBar();

		bExec = createButton("Exécuter", iconPlay, true, false);
		bPause = createButton("Pause", iconPause, false, false);
		bStop = createButton("Stop", iconStop, false, false);

		bDebug = new SimpleDropDownButton("Debug");
		bDebug.setIcon(iconDebug);

		JPopupMenu popupMenu = bDebug.getPopupMenu();

		m1 = new JMenuItem("Afficher les points des capteurs");
		m2 = new JMenuItem("MenuItem 2");
		m3 = new JMenuItem("MenuItem 3");
		popupMenu.add(m1);
		popupMenu.add(m2);
		popupMenu.add(m3);

		buttonBar.add(bExec);
		buttonBar.add(bPause);
		buttonBar.add(bStop);
		buttonBar.add(bDebug);
		this.add(buttonBar);

		Listener listener = new Listener();
		
		bExec.addActionListener(listener);
		bPause.addActionListener(listener);
		bStop.addActionListener(listener);
		m1.addActionListener(listener);
		m2.addActionListener(listener);
		m3.addActionListener(listener);
	}

	/**
	 * methode permettant de créer un bouton pour la buttonBar
	 *
	 * @param text
	 * @param icon
	 * @param enabled
	 * @param toggleButton
	 * @return
	 */
	private AbstractButton createButton(String text, ImageIcon icon, boolean enabled, boolean toggleButton) {
		AbstractButton b = null;
		if (toggleButton) {
			b = new JToggleButton(text) {
				@Override
				public Insets getMargin() {
					if (super.getMargin() != null) {
						return new Insets(super.getMargin().top, 10, super.getMargin().bottom, 10);
					}
					return null;
				}
			};
		} else {
			b = new JButton(text) {
				@Override
				public Insets getMargin() {
					if (super.getMargin() != null) {
						return new Insets(super.getMargin().top, 10, super.getMargin().bottom, 10);
					}
					return null;
				}
			};
		}
		b.setEnabled(enabled);
		Insets margin = b.getMargin();
		b.setMargin(new Insets(margin.top, 10, margin.bottom, 10));
		b.setIcon(icon);
		return b;
	}
	
	/**
	 * Classe pour la gestion des appuis sur les boutons.
	 * 
	 * @since 1.0
	 * @version 1.0
	 */
	private class Listener implements ActionListener,ObserverInterpreteur {
		@Override
		public void actionPerformed(ActionEvent e) {
			DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceBoutonsSimulateur(((JButton)e.getSource()).getText()));
		
			if (e.getSource() == bExec) {
				start();
				this.startThread();
			} else if (e.getSource() == bPause) {
				pause();
				pauseThread();
			} else if (e.getSource() == bStop) {
				stop();
				this.stopThread();
			} else if (e.getSource() == m1) {

			} else if (e.getSource() == m2) {

			} else if (e.getSource() == m3) {

			}
		}
		/**
		 * gerer le debut de la simulation
		 */
		private void startThread(){
			lanceurInter = new LanceurInterpreteur(simulator);
			lanceurInter.addObserverInterpreteur(this);
			lanceurInter.start();
			simulator.start();
			simulator.setRun(true);
			simulator.getRobotController().resetStartTime();
		}
		
		/**
		 * gere la pause de la simulation
		 */
		private void pauseThread(){
			if (!pause) {
				lanceurInter.waitThread();
			} else {
				lanceurInter.notifyThread();
			}
		}
		
		/**
		 * gere la fin de la simulation
		 */
		private void stopThread(){
			lanceurInter.stopThread();
			simulator.setRun(false);
			simulator.setWait(false);
			simulator.getRobotController().addCommand(new StopCommand(simulator.getRobotController(), 0, MotorPort.OUT_A));
			simulator.getRobotController().addCommand(new StopCommand(simulator.getRobotController(), 0, MotorPort.OUT_B));
			simulator.getRobotController().addCommand(new StopCommand(simulator.getRobotController(), 0, MotorPort.OUT_C));
			simulator.getRobotController().clearListCommands();
		}
		/**
		 * gere l'etat des boutons lors du debut de la simulation
		 */
		private void start(){
			bPause.setEnabled(true);
			bStop.setEnabled(true);
			bExec.setEnabled(false);
		}
		
		/**
		 * gere l'etat des boutons lors du debut de la simulation
		 */
		private void pause(){
			if (!pause) {
				pause = true;
				bPause.setText("Relance");
			} else {
				pause = false;
				bPause.setText("Pause");
			}
		}
		
		/**
		 * gere l'etat des boutons lors du debut de la simulation
		 */
		private void stop(){
			bPause.setEnabled(false);
			bStop.setEnabled(false);
			bExec.setEnabled(true);
			pause = false;
		}
		@Override
		public void update(ObservableInterpreteur o) {
			this.stop();
			this.stopThread();
		}
	}
}

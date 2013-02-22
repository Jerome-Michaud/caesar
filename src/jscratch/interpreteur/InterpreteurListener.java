package jscratch.interpreteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import jscratch.dictionnaires.DicoTraces;
import jscratch.traces.fabriques.FabriqueTrace;

/**
 * Classe pour la gestion des appuis sur les boutons pour l'Interpreteur.
 * 
 * @since 1.0
 * @version 1.0
 */
public class InterpreteurListener implements ActionListener {
			
	private GestionSimulation simulation;
	private boolean waitnotify;
	
	public InterpreteurListener(GestionSimulation simulation){
		this.simulation = simulation;
		this.waitnotify = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("PauseSimulator".equals(e.getActionCommand())) {
			this.waitNotifyThread();
		}
		else if ("StopSimulator".equals(e.getActionCommand())) {
			System.out.println("Stop");
			this.stopThread();
		}
	}
	
	/**
	 * appele la methode waitThread de l'interpreteur pour gerer la pause de la simulation
	 */
	private void waitNotifyThread(){
		if (!waitnotify) {
			this.waitnotify = true;
			System.out.println("Wait");
			simulation.waitThread();
		} else {
			simulation.notifyThread();
			System.out.println("ReStart");
			this.waitnotify = false;
			
		}
	}
	
	/**
	 * appele la methode stopThread de l'interpreteur pour gerer la fin de la simulation
	 */
	private void stopThread(){
		waitnotify = false;
		simulation.stopThread();
	}
}
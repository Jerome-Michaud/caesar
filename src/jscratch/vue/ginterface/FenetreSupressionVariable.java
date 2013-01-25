package jscratch.vue.ginterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import jscratch.modeles.DicoVariables;
import jscratch.modeles.DicoWidgetsCategories;
import nxtim.instruction.Variable;

public class FenetreSupressionVariable extends JFrame {

	private JComboBox variables;
	private JButton boutonValider;

	/**
	 * L'instance unique de <code>FenetreSuppressionVariable</code>.
	 */
	private static FenetreSupressionVariable instance = null;
	
	/**
	 * Le constructeur privé de <code>FenetreSuppressionVariable</code>.
	 */
	private FenetreSupressionVariable() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		
		variables = new JComboBox(DicoVariables.getInstance().getLesvariables());
		boutonValider = new JButton("Valider");

		Box boxV = Box.createVerticalBox();
		Box boxH1 = Box.createHorizontalBox();

		this.setContentPane(boxV);

		boxV.add(Box.createVerticalStrut(10));
		boxV.add(boxH1);
		boxV.add(Box.createVerticalStrut(10));

		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(variables);
		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(boutonValider);
		boxH1.add(Box.createHorizontalStrut(10));

		this.pack();
		this.setLocationRelativeTo(GUI.getFenetre());
		this.setVisible(true);
		this.variables.requestFocus();
		
		boutonValider.addActionListener(new ActionListener() {
			@ Override
			public void actionPerformed(ActionEvent ae) {
				String variable = ((Variable) variables.getSelectedItem()).getNom();
				
				// Suppression du widget dans la catégorie "Variables"
				DicoWidgetsCategories.getInstance().supprimerWidgetVariable(variable);
				
				// Suppression de la vaiable dans le dictionnaire
				DicoVariables.getInstance().supprimer(variable);

				// Mise à jour du panel widget
				GUI.getPanelWidget().setLesWidgets(1);
				
				dispose();
			}
		});
	}
	
	/**
	 * Permet de récupérer l'instance unique de <code>FenetreSuppressionVariable</code>.
	 *
	 * @return l'instance unique
	 */
	public static FenetreSupressionVariable getInstance() {
		if (instance == null) {
			instance = new FenetreSupressionVariable();
		}
		else {
			instance.reset();
		}
		return instance;
	}

	/**
	 * RAZ de la fenêtre.
	 */
	private void reset() {
		this.setVisible(true);
	}
}

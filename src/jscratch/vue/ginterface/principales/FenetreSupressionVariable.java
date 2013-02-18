package jscratch.vue.ginterface.principales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import jscratch.dictionnaires.DicoVariables;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.traduction.LanceurTraduction;
import jscratch.vue.arborescence.ArborescenceTools;
import nxtim.instruction.Variable;

public final class FenetreSupressionVariable extends JFrame {

	private JComboBox variables;
	private JButton boutonValider;
	
	/**
	 * Le constructeur par défaut de <code>FenetreSuppressionVariable</code>.
	 */
	public FenetreSupressionVariable() {
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
		this.setLocationRelativeTo(GUI.getPanelWidget());
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
				
				// Suppression des widgets variable dans l'arborescence
				ArborescenceTools.getInstance().supprimerVariable(variable);
				
				// On relance la traduction
				LanceurTraduction.getInstance().lancerTraduction();

				// Mise à jour du panel widget
				GUI.getPanelWidget().setLesWidgets(1);				
				
				dispose();
			}
		});
		
		this.getRootPane().setDefaultButton(this.boutonValider);
		this.boutonValider.setDefaultCapable(true);
	}
}

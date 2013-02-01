package jscratch.vue.ginterface.principales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import jscratch.dictionnaires.DicoVariables;
import jscratch.dictionnaires.DicoWidgetsCategories;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableModifiable;

public class FenetreAjoutVariable extends JFrame {

	private JComboBox typeVariable;
	private JTextField nomVariable;
	private JButton boutonValider, boutonAnnuler;

	/**
	 * L'instance unique de <code>FenetreAjoutVariable</code>.
	 */
	private static FenetreAjoutVariable instance = null;
	
	/**
	 * Le constructeur privé de <code>FenetreAjoutVariable</code>.
	 */
	private FenetreAjoutVariable() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		
		Box boxV = Box.createVerticalBox();
		Box boxH1 = Box.createHorizontalBox();
		Box boxH2 = Box.createHorizontalBox();

		this.typeVariable = new JComboBox(TypeVariable.values());
		this.nomVariable = new JTextField(20);
		this.boutonValider = new JButton("Valider");
		this.boutonAnnuler = new JButton("Annuler");

		this.setContentPane(boxV);
		boxV.add(Box.createVerticalStrut(10));
		boxV.add(boxH1);
		boxV.add(Box.createVerticalStrut(15));
		boxV.add(boxH2);
		boxV.add(Box.createVerticalStrut(10));

		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(this.typeVariable);
		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(this.nomVariable);
		boxH1.add(Box.createHorizontalStrut(10));

		boxH2.add(Box.createHorizontalStrut(10));
		boxH2.add(this.boutonValider);
		boxH2.add(Box.createHorizontalStrut(10));
		boxH2.add(this.boutonAnnuler);
		boxH2.add(Box.createHorizontalStrut(10));

		this.pack();
		this.setLocationRelativeTo(GUI.getPanelWidget());
		this.setVisible(true);
		this.nomVariable.requestFocus();
		this.boutonValider.setDefaultCapable(true);

		boutonValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (!nomVariable.getText().isEmpty()) {
					Variable var = new VariableModifiable((TypeVariable) typeVariable.getSelectedItem(), nomVariable.getText(), "0");
					
					// Ajout dans le dictionnaire
					DicoVariables.getInstance().ajouter(var);
					
					// Mise à jour des widgets liés au variables
					DicoWidgetsCategories.getInstance().updateWidgetsVariables();
					
					// Mise à jour du panel widget
					GUI.getPanelWidget().setLesWidgets(1);
					
					dispose();
				}
			}
		});

		boutonAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
	}
	
	/**
	 * Permet de récupérer l'instance unique de <code>FenetreAjoutVariable</code>.
	 *
	 * @return l'instance unique
	 */
	public static FenetreAjoutVariable getInstance() {
		if (instance == null) {
			instance = new FenetreAjoutVariable();
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
		this.nomVariable.setText("");
		this.setVisible(true);
	}
}

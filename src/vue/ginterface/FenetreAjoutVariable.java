package vue.ginterface;

import instruction.TypeVariable;
import instruction.Variable;
import instruction.VariableModifiable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import modeles.DicoVars;
import java.awt.Color;
import vue.ginterface.GUI;
import vue.widget.Widget;
import vue.categories.BoutonCategorieVariable;
import vue.categories.BoutonCategorie;

/**
 *
 * @author Quentin
 */
public class FenetreAjoutVariable extends JFrame {

	private JComboBox typeVariable;
	private JTextField nomVariable;
	private JButton boutonValider, boutonAnnuler;

	private static final int ROUGE = 212, VERT = 82, BLEU = 144;
	public FenetreAjoutVariable() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);

		Box boxV = Box.createVerticalBox();
		Box boxH1 = Box.createHorizontalBox();
		Box boxH2 = Box.createHorizontalBox();

		typeVariable = new JComboBox(TypeVariable.values());
		nomVariable = new JTextField(20);
		boutonValider = new JButton("Valider");
		boutonAnnuler = new JButton("Annuler");

		this.setContentPane(boxV);
		boxV.add(Box.createVerticalStrut(10));
		boxV.add(boxH1);
		boxV.add(Box.createVerticalStrut(15));
		boxV.add(boxH2);
		boxV.add(Box.createVerticalStrut(10));

		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(typeVariable);
		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(nomVariable);
		boxH1.add(Box.createHorizontalStrut(10));

		boxH2.add(Box.createHorizontalStrut(10));
		boxH2.add(boutonValider);
		boxH2.add(Box.createHorizontalStrut(10));
		boxH2.add(boutonAnnuler);
		boxH2.add(Box.createHorizontalStrut(10));

		this.pack();
		this.setLocationRelativeTo(GUI.getFenetre());
		this.setVisible(true);

		boutonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (!nomVariable.getText().isEmpty()) {
					Variable var = new VariableModifiable((TypeVariable)typeVariable.getSelectedItem(), nomVariable.getText(), "");
					DicoVars.getInstance().ajouter(var);

					for (BoutonCategorie bc : GUI.getPanelTypeWidget().getLesCategories()) {
						if (bc instanceof BoutonCategorieVariable) {
							BoutonCategorieVariable bcv = (BoutonCategorieVariable) bc;
							bcv.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetVariable(nomVariable.getText()));
							//bcv.ajouterUnWidget(GUI.getPanelWidget().getFabrique().creerWidgetVariable());
							for (Widget w : bcv.getLesWidgets()) {
								w.getModele().setCouleur(new Color(ROUGE, VERT, BLEU));
							}
						}
					}

					
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
}

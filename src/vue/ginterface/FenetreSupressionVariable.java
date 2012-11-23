/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.ginterface;

import instruction.Variable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import modeles.DicoVars;

/**
 *
 * @author Quentin
 */
public class FenetreSupressionVariable extends JFrame {
	
	private JComboBox variables;
	private JButton boutonValider;
	
	public FenetreSupressionVariable() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		variables = new JComboBox(DicoVars.getInstance().getLesvariables());
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
		
		boutonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				DicoVars.getInstance().supprimer(((Variable)variables.getSelectedItem()).getNom());
				dispose();
			}
		});
	}
}

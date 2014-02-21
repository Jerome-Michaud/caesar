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
package jscratch.vue.ginterface.principales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.traduction.LanceurTraduction;
import jscratch.vue.arborescence.ArborescenceTools;
import nxtim.instruction.Variable;

/**
 * Cette classe représente la fenêtre permettant de supprimer des variables. 
 */
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
		
		variables = new JComboBox(ApplicationUI.getInstance().getDicoVariables().getLesVariables());
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
				ApplicationUI.getInstance().getDicoVariables().supprimer(variable);
				
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

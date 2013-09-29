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
package jscratch.vue.ginterface.parametrages;

import de.javasoft.swing.JYTabbedPane;
import jscratch.vue.ginterface.parametrages.panels.PanelCategories;
import jscratch.vue.ginterface.parametrages.panels.PanelTraces;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import jscratch.vue.ginterface.parametrages.panels.PanelAutres;
import jscratch.vue.ginterface.parametrages.panels.PanelInterfaces;
import jscratch.vue.ginterface.parametrages.panels.PanelOngletsWidgets;

/**
 * L'interface de paramétrage.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class ParametrageUI extends JFrame {

	/**
	 * Unique instance of <code>TestParametrage</code>.
	 */
	private static ParametrageUI instance = null;

	/**
	 * Les onglets
	 */
	private JYTabbedPane tab = null;
	
	/**
	 * Bouton sauvegarder.
	 */
	private JButton sauvegarder = null;

	/**
	 * Private constructor of <code>TestParametrage</code>.
	 */
    private ParametrageUI() {
		this.setTitle("Configuration de JScratch");
		this.setIconImage(ImagesHelper.getImage("icone.png"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		tab = new JYTabbedPane();
		tab.insertTab("Interface", null, PanelInterfaces.getInstance(), null, 0);
		tab.insertTab("Catégories", null, PanelCategories.getInstance(), null, 1);
		tab.insertTab("Widgets", null, PanelOngletsWidgets.getInstance(), null, 2);
		tab.insertTab("Autres", null, PanelAutres.getInstance(), null, 3);
		tab.insertTab("Traces", null, PanelTraces.getInstance(), null, 4);
		
		tab.setTabReorderByDraggingEnabled(false);
		
		this.sauvegarder = new JButton("Sauvegarder");
		this.sauvegarder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PanelInterfaces.getInstance().update();
				PanelCategories.getInstance().update();
				PanelOngletsWidgets.getInstance().update();
				PanelAutres.getInstance().update();
				PanelTraces.getInstance().update();
				
				PropertiesHelper.getInstance().sauvegarder();
				
				JOptionPane.showMessageDialog(instance, "La sauvegarde a correctement été réalisée", "Sauvegarde terminée", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		this.add(this.tab, BorderLayout.CENTER);
		this.add(this.sauvegarder, BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Accessor for <code>TestParametrage</code>.
	 *
	 * @return unique instance of <code>TestParametrage</code>
	 */
    public static ParametrageUI getInstance() {
        if (instance == null) {
			instance = new ParametrageUI();
		}
		return instance;
    }
 }
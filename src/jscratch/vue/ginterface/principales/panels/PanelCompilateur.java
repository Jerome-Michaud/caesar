/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

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
package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import jscratch.helpers.CompilateurHelper;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.LangueHelper;
import jscratch.helpers.SessionHelper;
import jscratch.parametrages.langue.VariableLangue;

/**
 *
 */
public class PanelCompilateur extends JPanel {

	private static PanelCompilateur instance = new PanelCompilateur();
	private StyledDocument docInfos;
	private SimpleAttributeSet ligneCompil;
	private SimpleAttributeSet ligneInfo;
	private JTextPane panneauInfos;
	private JPanel panelTools;
	private JButton boutComp;
	private JCheckBox checkRun;

	/**
	 * Default constructor of
	 * <code>PanelCompilateur</code>.
	 */
	private PanelCompilateur() {
		this.setLayout(new BorderLayout());
		panneauInfos = new JTextPane(){
			public boolean getScrollableTracksViewportWidth() {
			  Component parent = getParent();
			  ComponentUI ui = getUI();
 
			  return parent != null ? (ui.getPreferredSize(this).width <= parent
				  .getSize().width) : true;
			}
		};
		docInfos = panneauInfos.getStyledDocument();
		panneauInfos.setEditable(false);
		ligneCompil = new SimpleAttributeSet();
		StyleConstants.setForeground(ligneCompil, Color.RED);
		StyleConstants.setBold(ligneCompil, true);
		ligneInfo = new SimpleAttributeSet();
		StyleConstants.setForeground(ligneInfo, Color.BLACK);
		this.add(new JScrollPane(panneauInfos),BorderLayout.CENTER);
		
		this.panelTools = new JPanel(new BorderLayout());
		this.boutComp = new JButton(LangueHelper.getInstance().get(VariableLangue.COMPIL_COMPIL), ImagesHelper.getIcon("compile.png"));
		
		boutComp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CompilateurHelper.exporter(checkRun.isSelected());
			}
		});
		
		this.checkRun = new JCheckBox(LangueHelper.getInstance().get(VariableLangue.COMPIL_EXEC));
		panelTools.add(boutComp,BorderLayout.EAST);
		panelTools.add(checkRun,BorderLayout.WEST);
				
		this.add(panelTools,BorderLayout.SOUTH);
		
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	public static PanelCompilateur getInstance() {
		return instance;
	}

	public void ecrireDateEtHeure() {
		try {
			Date dateAct = new Date();
			docInfos.insertString(docInfos.getLength(), " ----- "+SessionHelper.formatDate(dateAct) + " à "+SessionHelper.formatHeure(dateAct) + " -----\n", ligneCompil);
		} catch (BadLocationException ex) {
			Logger.getLogger(PanelCompilateur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void ecrireNouvelleLigneInfo(String ligne) {
		try {
			docInfos.insertString(docInfos.getLength(), ligne+"\n", ligneInfo);
		} catch (BadLocationException ex) {
			Logger.getLogger(PanelCompilateur.class.getName()).log(Level.SEVERE, null, ex);
		}
		panneauInfos.setCaretPosition(docInfos.getLength());
	}
}
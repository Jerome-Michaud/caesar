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

import de.javasoft.swing.AboutDialog;
import jscratch.vue.ginterface.principales.selecteur.SelecteurFichier;
import jscratch.vue.ginterface.principales.panels.PanelCodeGraphique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import jscratch.helpers.CompilateurHelper;
import jscratch.helpers.ErreurHelper;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.LangueHelper;
import jscratch.helpers.SessionHelper;
import jscratch.parametrages.langue.VariableLangue;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.ginterface.principales.selecteur.TypeSelecteur;
import jscratch.vue.widgets.Widget;

/**
 * Le menu de l'application.
 */
public final class Menu extends JMenuBar {

	private JMenu fichier, exportation, traces, aide;
	private JMenuItem fichierNouveau, fichierOuvrir, fichierEnregistrer, fichierChargerProp, fichierQuitter;
	private JMenuItem exportationNXC, exportationRobot;
	private JMenuItem tracesExporter;
	private JMenuItem aideAPropos;
	
	private static Menu instance = null;

	private ListenerMenu listener = new ListenerMenu();

	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de Menu
	 */
	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}

	/**
	 * Constructeur privé de <code>Menu</code>.
	 */
	private Menu() {
		LangueHelper l = LangueHelper.getInstance();
		// FIchier
		this.fichier = new JMenu(l.get(VariableLangue.FIC));
		this.fichierNouveau = new JMenuItem(l.get(VariableLangue.FIC_NEW), ImagesHelper.getIcon("document.png"));
		this.fichierOuvrir = new JMenuItem(l.get(VariableLangue.FIC_LOAD_ALGORITHME), ImagesHelper.getIcon("folder-horizontal-open.png"));
		this.fichierEnregistrer = new JMenuItem(l.get(VariableLangue.FIC_SAVE), ImagesHelper.getIcon("disk-black.png"));
		this.fichierChargerProp = new JMenuItem(l.get(VariableLangue.FIC_LOAD_PROPERTIES), ImagesHelper.getIcon("gear.png"));
		this.fichierQuitter = new JMenuItem(l.get(VariableLangue.FIC_QUIT), ImagesHelper.getIcon("cross-circle.png"));
		this.fichier.add(fichierNouveau);
		this.fichier.addSeparator();
		this.fichier.add(fichierOuvrir);
		this.fichier.add(fichierEnregistrer);
		this.fichier.add(fichierChargerProp);
		this.fichier.addSeparator();
		this.fichier.add(fichierQuitter);

		// Exportation
		this.exportation = new JMenu(l.get(VariableLangue.EXP));
		this.exportationNXC = new JMenuItem(l.get(VariableLangue.EXP_NXC), ImagesHelper.getIcon("document-code.png"));
		this.exportationRobot = new JMenuItem(l.get(VariableLangue.EXP_ROBOT), ImagesHelper.getIcon("robot.png"));
		this.exportation.add(exportationNXC);
		this.exportation.add(exportationRobot);
		
		// Traces
		this.traces = new JMenu(l.get(VariableLangue.TRA));
		this.tracesExporter = new JMenuItem(l.get(VariableLangue.TRA_EXPORT), ImagesHelper.getIcon("document-traces.png"));
		this.traces.add(tracesExporter);
		
		// Aide
		this.aide = new JMenu(l.get(VariableLangue.MOR));
		this.aideAPropos = new JMenuItem(l.get(VariableLangue.MOR_HELP), ImagesHelper.getIcon("information-italic.png"));
		this.aide.add(aideAPropos);

		this.add(fichier);
		this.add(exportation);
		this.add(traces);
		this.add(aide);

		fichierNouveau.addActionListener(listener);
		fichierOuvrir.addActionListener(listener);
		fichierEnregistrer.addActionListener(listener);
		fichierChargerProp.addActionListener(listener);
		fichierQuitter.addActionListener(listener);
		exportationNXC.addActionListener(listener);
		exportationRobot.addActionListener(listener);
		aideAPropos.addActionListener(listener);
	}

	/**
	 * Permet de définir les différentes actions du menu.
	 *
	 * @since 1.0
	 */
	private class ListenerMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == fichierNouveau) {
				nouveau();
			}
			else if (e.getSource() == fichierOuvrir) {
				new SelecteurFichier(TypeSelecteur.ARBORESCENCE).chargement();
			}
			else if (e.getSource() == fichierEnregistrer) {
				new SelecteurFichier(TypeSelecteur.ARBORESCENCE).sauvegarde();
			}
			else if (e.getSource() == fichierChargerProp) {
				new SelecteurFichier(TypeSelecteur.PROPERTIES).chargement();
			}
			else if (e.getSource() == fichierQuitter) {
				SessionHelper.quitter();
			}
			else if (e.getSource() == exportationNXC) {
				new SelecteurFichier(TypeSelecteur.CODE).sauvegarde();
			}
			else if (e.getSource() == exportationRobot) {
				CompilateurHelper.exporter(false);
			}
			else if (e.getSource() == traces) {
				new SelecteurFichier(TypeSelecteur.TRACES).sauvegarde();
			}
			else if (e.getSource() == aideAPropos) {
				try {
					AboutDialog ad = new AboutDialog(GUI.getFenetre(), false, null, false);
					ad.setTitle("A propos");
					ad.setDescription("<html><b>Vous trouverez ici plus d'information sur l'application</b><p>Cliquez sur les onglets suivants pour avoir les informations sur l'application et le système.</p></html>");
					ad.setAboutText(this.getClass().getClassLoader().getResource("jscratch" + File.separator + "APropos.html"));
					ad.showDialog();
				} catch (IOException ex) {
					ErreurHelper.afficher(ex);
				}
			}
		}
	}

	/**
	 * Permet de créer un nouveau projet.
	 *
	 * @since 1.0
	 */
	private void nouveau() {
		int choix = JOptionPane.showConfirmDialog(ApplicationUI.getInstance(), new JLabel("<html>Souhaitez vous créer un nouveau fichier ?<br><br>Toute Progression non sauvegardée sera perdue.</html>"), "Création d'un nouveau fichier", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (choix == JOptionPane.YES_OPTION) {
			ArborescenceTools.getInstance().initArborescence(new LinkedList<List<Widget>>(), false);
			PanelCodeGraphique.getInstance().repaint();
		}
	}
}
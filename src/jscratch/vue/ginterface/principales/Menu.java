package jscratch.vue.ginterface.principales;

import jscratch.vue.ginterface.principales.panels.PanelCodeGraphique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import jscratch.helpers.ImagesHelper;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.widgets.Widget;

/**
 * Le menu de l'application.
 *
 * @since 1.0
 * @version 1.0
 */
public class Menu extends JMenuBar {

	private JMenu fichier, exportation, aide;
	private JMenuItem fichierNouveau, fichierOuvrir, fichierEnregistrer, fichierQuitter;
	private JMenuItem exportationNXC, exportationRobotC;
	private JMenuItem aideAPropos;
	private SelecteurFichier selecteur;
	
	/**
	 * @since 1.0
	 */
	private static final Menu instance = new Menu();
	/**
	 * @see Vue.Interface.Menu.ListenerMenu
	 */
	private ListenerMenu listener = new ListenerMenu();

	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de Menu
	 */
	public static Menu getInstance() {
		return instance;
	}

	/**
	 * Constructeur privé de <code>Menu</code>.
	 */
	private Menu() {
		this.fichier = new JMenu("Fichier");
		this.fichierNouveau = new JMenuItem("Nouveau");
		this.fichierNouveau.setIcon(ImagesHelper.getIcon("page_blank.png"));
		this.fichierOuvrir = new JMenuItem("Ouvrir ...");
		this.fichierOuvrir.setIcon(ImagesHelper.getIcon("folder_search.png"));
		this.fichierEnregistrer = new JMenuItem("Enregistrer ...");
		this.fichierEnregistrer.setIcon(ImagesHelper.getIcon("save.png"));
		this.fichierQuitter = new JMenuItem("Quitter");
		this.fichierQuitter.setIcon(ImagesHelper.getIcon("remove.png"));
		this.fichier.add(fichierNouveau);
		this.fichier.addSeparator();
		this.fichier.add(fichierOuvrir);
		this.fichier.add(fichierEnregistrer);
		this.fichier.addSeparator();
		this.fichier.add(fichierQuitter);

		this.exportation = new JMenu("Exporter");
		this.exportationNXC = new JMenuItem("En NXC");
		this.exportationNXC.setIcon(ImagesHelper.getIcon("export_nxc.png"));
		this.exportationRobotC = new JMenuItem("En RobotC");
		this.exportationRobotC.setIcon(ImagesHelper.getIcon("export_robotc.png"));
		this.exportation.add(exportationNXC);
		//this.exportation.add(exportationRobotC);

		this.aide = new JMenu("?");
		this.aideAPropos = new JMenuItem("A propos");
		this.aideAPropos.setIcon(ImagesHelper.getIcon("info.png"));
		this.aide.add(aideAPropos);

		this.add(fichier);
		this.add(exportation);
		this.add(aide);

		fichierNouveau.addActionListener(listener);
		fichierOuvrir.addActionListener(listener);
		fichierEnregistrer.addActionListener(listener);
		fichierQuitter.addActionListener(listener);
		exportationNXC.addActionListener(listener);
		exportationRobotC.addActionListener(listener);
		aideAPropos.addActionListener(listener);

		selecteur = new SelecteurFichier(false);
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
			} else if (e.getSource() == fichierOuvrir) {
				selecteur.chargement();
			} else if (e.getSource() == fichierEnregistrer) {
				selecteur.sauvegarde();
			} else if (e.getSource() == fichierQuitter) {
				System.exit(0);
			} else if (e.getSource() == exportationNXC) {
				new SelecteurFichier(true).sauvegarde();
			} else if (e.getSource() == exportationRobotC) {
				//TODO finir l'implémentation de la traduction RobotC
			} else if (e.getSource() == aideAPropos) {
				AProposUI p = new AProposUI();
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
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
import jscratch.helpers.SessionHelper;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.ginterface.principales.selecteur.TypeSelecteur;
import jscratch.vue.widgets.Widget;

/**
 * Le menu de l'application.
 *
 * @since 1.0
 * @version 1.0
 */
public final class Menu extends JMenuBar {

	private JMenu fichier, exportation, traces, aide;
	private JMenuItem fichierNouveau, fichierOuvrir, fichierEnregistrer, fichierChargerProp, fichierQuitter;
	private JMenuItem exportationNXC, exportationRobot;
	private JMenuItem tracesExporter;
	private JMenuItem aideAPropos;
	
	/**
	 * @since 1.0
	 */
	private static Menu instance = null;
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
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}

	/**
	 * Constructeur privé de <code>Menu</code>.
	 */
	private Menu() {
		// FIchier
		this.fichier = new JMenu("Fichier");
		this.fichierNouveau = new JMenuItem("Nouveau", ImagesHelper.getIcon("document.png"));
		this.fichierOuvrir = new JMenuItem("Ouvrir ...", ImagesHelper.getIcon("folder-horizontal-open.png"));
		this.fichierEnregistrer = new JMenuItem("Enregistrer ...", ImagesHelper.getIcon("disk-black.png"));
		this.fichierChargerProp = new JMenuItem("Charger configuration ...", ImagesHelper.getIcon("gear.png"));
		this.fichierQuitter = new JMenuItem("Quitter", ImagesHelper.getIcon("cross-circle.png"));
		
		this.fichier.add(fichierNouveau);
		this.fichier.addSeparator();
		this.fichier.add(fichierOuvrir);
		this.fichier.add(fichierEnregistrer);
		this.fichier.add(fichierChargerProp);
		this.fichier.addSeparator();
		this.fichier.add(fichierQuitter);

		// Exportation
		this.exportation = new JMenu("Exporter");
		this.exportationNXC = new JMenuItem("En NXC", ImagesHelper.getIcon("document-code.png"));
		this.exportationRobot = new JMenuItem("Vers le robot", ImagesHelper.getIcon("robot.png"));
		
		this.exportation.add(exportationNXC);
		this.exportation.add(exportationRobot);
		
		// Traces
		this.traces = new JMenu("Traces");
		this.tracesExporter = new JMenuItem("Exporter ...", ImagesHelper.getIcon("document-traces.png"));
		
		this.traces.add(tracesExporter);
		
		// Aide
		this.aide = new JMenu("?");
		this.aideAPropos = new JMenuItem("A propos");
		this.aideAPropos.setIcon(ImagesHelper.getIcon("information-italic.png"));
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
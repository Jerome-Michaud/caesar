package Vue.Interface;

import Ressources.ResourceTools;
import Vue.Tools.ArborescenceTools;
import Vue.Tools.CreationCodeTools;
import Vue.Tools.SavingTools;
import Vue.Widget.Widget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

import traduction.VisiteurNXC;
import traduction.VisiteurRobotC;

public class Menu extends JMenuBar implements ActionListener {

    private JMenu fichier, exportation, aide;
    private JMenuItem fichierNouveau, fichierOuvrir, fichierEnregistrer, fichierQuitter;
    private JMenuItem exportationNXC, exportationRobotC;
    private JMenuItem aideAPropos;

    public Menu() {
        this.fichier = new JMenu("Fichier");
        this.fichierNouveau = new JMenuItem("Nouveau");
        this.fichierNouveau.setIcon(ResourceTools.getIcon("page_blank.png"));
        this.fichierOuvrir = new JMenuItem("Ouvrir ...");
        this.fichierOuvrir.setIcon(ResourceTools.getIcon("folder_search.png"));
        this.fichierEnregistrer = new JMenuItem("Enregistrer ...");
        this.fichierEnregistrer.setIcon(ResourceTools.getIcon("save.png"));
        this.fichierQuitter = new JMenuItem("Quitter");
        this.fichierQuitter.setIcon(ResourceTools.getIcon("remove.png"));
        this.fichier.add(fichierNouveau);
        this.fichier.addSeparator();
        this.fichier.add(fichierOuvrir);
        this.fichier.add(fichierEnregistrer);
        this.fichier.addSeparator();
        this.fichier.add(fichierQuitter);

        this.exportation = new JMenu("Exporter");
        this.exportationNXC = new JMenuItem("En NXC");
        this.exportationNXC.setIcon(ResourceTools.getIcon("export_nxc.png"));
        this.exportationRobotC = new JMenuItem("En RobotC");
        this.exportationRobotC.setIcon(ResourceTools.getIcon("export_robotc.png"));
        this.exportation.add(exportationNXC);
        this.exportation.add(exportationRobotC);

        this.aide = new JMenu("?");
        this.aideAPropos = new JMenuItem("A propos");
        this.aideAPropos.setIcon(ResourceTools.getIcon("info.png"));
        this.aide.add(aideAPropos);

        this.add(fichier);
        this.add(exportation);
        this.add(aide);

        fichierNouveau.addActionListener(this);
        fichierOuvrir.addActionListener(this);
        fichierEnregistrer.addActionListener(this);
        fichierQuitter.addActionListener(this);
        exportationNXC.addActionListener(this);
        exportationRobotC.addActionListener(this);
        aideAPropos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fichierNouveau) {
            nouveau();
        }
		else if (e.getSource() == fichierOuvrir) {
            SavingTools.load();
        }
		else if (e.getSource() == fichierEnregistrer) {
            SavingTools.save();
        }
		else if (e.getSource() == fichierQuitter) {
            System.exit(0);
        }
		else if (e.getSource() == exportationNXC) {
			CreationCodeTools.getInstance().ecrire(VisiteurNXC.getInstance().getTraduction());
        }
		else if (e.getSource() == exportationRobotC) {
        }
		else if (e.getSource() == aideAPropos) {
            new FenetreAPropos();
        }
    }

    private void nouveau() {
        int choix = JOptionPane.showConfirmDialog(Fenetre.getInstance(), new JLabel("<html>Souhaitez vous créer un nouveau fichier ?"
                + "<br><br>Toute Progression non sauvegardée sera perdue.</html>"), "Création d'un nouveau fichier", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (choix == JOptionPane.YES_OPTION) {
            System.out.println("oui");
            ArborescenceTools.getInstance().initArborescence(new LinkedList<List<Widget>>(), false);
            PanelCodeGraphique.getInstance().repaint();
        } else {
            System.out.println("non");
        }
    }
}
package Vue.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar implements ActionListener {

    private JMenu fichier, exportation, aide;
    private JMenuItem fichierNouveau, fichierOuvrir, fichierEnregistrer, fichierQuitter;
    private JMenuItem exportationNXC, exportationRobotC;
    private JMenuItem aideAPropos;

    public Menu() {
	this.fichier = new JMenu("Fichier");
	this.fichierNouveau = new JMenuItem("Nouveau");
	this.fichierOuvrir = new JMenuItem("Ouvrir ...");
	this.fichierEnregistrer = new JMenuItem("Enregistrer ...");
	this.fichierQuitter = new JMenuItem("Quitter");
	    this.fichier.add(fichierNouveau);
	    this.fichier.addSeparator();
	    this.fichier.add(fichierOuvrir);
	    this.fichier.add(fichierEnregistrer);
	    this.fichier.addSeparator();
	    this.fichier.add(fichierQuitter);

	this.exportation = new JMenu("Exporter");
	this.exportationNXC = new JMenuItem("En NXC");
	this.exportationRobotC = new JMenuItem("En RobotC");
	    this.exportation.add(exportationNXC);
	    this.exportation.add(exportationRobotC);

	this.aide = new JMenu("?");
	this.aideAPropos = new JMenuItem("A propos");
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
	    
	}
	else if (e.getSource() == fichierNouveau) {
	    
	}
	else if (e.getSource() == fichierOuvrir) {
	    
	}
	else if (e.getSource() == fichierEnregistrer) {
	    
	}
	else if (e.getSource() == fichierQuitter) {
	    System.exit(0);
	}
	else if (e.getSource() == exportationNXC) {
	    
	}
	else if (e.getSource() == exportationRobotC) {
	    
	}
	else if (e.getSource() == aideAPropos) {
	    new FenetreAPropos();
	}
    }
}
package Modeles;

import javax.swing.JOptionPane;

public class Erreur {
    
    public static void afficher(Exception e) {
	JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
	System.exit(1);
    }
}

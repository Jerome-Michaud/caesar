package jscratch.modeles;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Définit l'action à faire lors d'une erreur.<br/>
 * Afin de ne pas avoir à rechercher dans tout le code.<br/><br/>
 * Au lieu de faire <code>Exception.printStackTrace()</code>, faire <code>Erreur.afficher(Exception)</code>.
 */
public final class Erreur {

	/**
	 * Le constructeur est privé pour empêcher l'instanciation.
	 */
	private Erreur() { }

	/**
	 * Définit l"action à réaliser quand une erreur est rencontrée.
	 *
	 * @param e l'exception à gérer
	 */
	public static void afficher(final Exception e) {
		//JOptionPane.showMessageDialog(Fenetre.getInstance(), e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
		System.exit(1);
	}

	/**
	 * Définit l"action à réaliser quand une erreur est rencontrée.
	 *
	 * @param e l'exception à gérer
	 * @param message le message à logguer
	 */
	public static void afficher(final Exception e, final String message) {
		//JOptionPane.showMessageDialog(Fenetre.getInstance(), e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		Logger.getLogger(Erreur.class.getName()).log(Level.SEVERE, message);
		e.printStackTrace();
		System.exit(1);
	}
}

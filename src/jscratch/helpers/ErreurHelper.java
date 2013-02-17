package jscratch.helpers;

import de.javasoft.swing.DetailsDialog;
import jscratch.vue.ginterface.principales.GUI;

/**
 * Définit l'action à faire lors d'une erreur.<br/>
 * Afin de ne pas avoir à rechercher dans tout le code.<br/><br/>
 * Au lieu de faire <code>Exception.printStackTrace()</code>, faire <code>Erreur.afficher(Exception)</code>.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class ErreurHelper {

	/**
	 * Le constructeur est privé pour empêcher l'instanciation.
	 * 
	 * @since 1.0
	 */
	private ErreurHelper() { }

	/**
	 * Définit l"action à réaliser quand une erreur est rencontrée.
	 *
	 * @since 1.0
	 * 
	 * @param e l'exception à gérer
	 */
	public static void afficher(final Exception e) {
		DetailsDialog.showDialog(GUI.getFenetre(), null, "Une erreur de type '" + e.getClass().getSimpleName() + "' est survenue", e);
		System.exit(1);
	}

	/**
	 * Définit l"action à réaliser quand une erreur est rencontrée.
	 *
	 * @since 1.0
	 * 
	 * @param e l'exception à gérer
	 * @param message le message à logguer
	 */
	public static void afficher(final Exception e, final String message) {
		DetailsDialog.showDialog(GUI.getFenetre(), null, message, e);
		System.exit(1);
	}
}
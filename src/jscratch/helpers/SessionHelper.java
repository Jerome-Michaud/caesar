package jscratch.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.principales.selecteur.SelecteurFichier;
import jscratch.vue.ginterface.principales.selecteur.TypeSelecteur;

/**
 * @since 1.0
 * @version 1.0
 */
public final class SessionHelper {

	private static DateFormat formatJour = new SimpleDateFormat("dd/MM/yyyy");
	private static DateFormat formatHeure = new SimpleDateFormat("HH:mm:ss");
	/**
	 * Constructeur privé de <code>SessionHelper</code>.
	 */
    private SessionHelper() { }
	
	/**
	 * Permet d'avoir le login de l'utilisateur en cours.
	 * 
	 * @since 1.0
	 * 
	 * @return le login de l'utilisateur
	 */
	public static String getUtilisateur() {
		return System.getProperty("user.name");
	}
	
	/**
	 * Permet d'avoir la date de la session.
	 * 
	 * @since 1.0
	 * 
	 * @param date la date à formater
	 * @return la date au format DD/MM/YYYY
	 */
	public static String formatDate(final Date date) {
		return formatJour.format(date);
	}
	
	/**
	 * Permet d'avoir l'heure actuelle.
	 * 
	 * @since 1.0
	 * 
	 * @param date la date à formater
	 * @return l'heure au format HH:mm:ss
	 */
	public static String formatHeure(final Date date) {
		return formatHeure.format(date);
	}
	
	/**
	 * Permet d'éxécuter les actions avant de fermer l'application.
	 */
	public static void quitter() {
		if (Boolean.parseBoolean(PropertiesHelper.getInstance().get("user.trace.active"))) {
			new SelecteurFichier(TypeSelecteur.TRACES).sauvegarde();
		}
		
		System.exit(0);
	}
 }

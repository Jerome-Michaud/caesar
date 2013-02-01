package jscratch.exceptions;

/**
 * Erreur à lever quand un composant n'est pas chargeable à partir d'un fichier.
 *
 * @author Gosselin Quentin
 */
public class NonChargeableException extends Exception {

	/**
	 * Constructeur faisant appel au constructeur de la classe Exception.
	 */
	public NonChargeableException() {
		super();
	}

	/**
	 * Constructeur prenant en paramètre une chaine de caractères faisant appel au contructeur correspondant de la class Exception.
	 *
	 * @param msg Le message d'erreur type lorsque cette exception est levée
	 */
	public NonChargeableException(String msg) {
		super(msg);
	}
}
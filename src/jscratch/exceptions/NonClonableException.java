package jscratch.exceptions;

/**
 * Erreur à lever quand un composant n'est pas clonable.
 *
 * @since 1.0
 * @version 1.0
 */
public class NonClonableException extends Exception {

	/**
	 * Constructeur faisant appel au constructeur de la classe Exception.
	 * 
	 * @since 1.0
	 */
	public NonClonableException() {
		super();
	}

	/**
	 * Constructeur prenant en paramètre une chaine de caractères faisant appel au contructeur correspondant de la class Exception.
	 *
	 * @since 1.0
	 * 
	 * @param msg Le message d'erreur type lorsque cette exception est levée
	 */
	public NonClonableException(String msg) {
		super(msg);
	}
}

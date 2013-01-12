package jscratch.vue.tools;

/**
 * Erreur à lever quand un composant n'est pas clonable.
 *
 * @author Gosselin Quentin
 */
public class NonClonableException extends Exception {

	/**
	 * Constructeur faisant appel au constructeur de la classe Exception.
	 */
	public NonClonableException() {
		super();
	}

	/**
	 * Constructeur prenant en paramètre une chaine de caractères faisant appel au contructeur correspondant de la class Exception.
	 *
	 * @param msg Le message d'erreur type lorsque cette exception est levée
	 */
	public NonClonableException(String msg) {
		super(msg);
	}
}

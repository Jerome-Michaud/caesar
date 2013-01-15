package jscratch.vue.tools.exceptions;

/**
 * Classe héritant d'Exception permettant de définir une erreur à lever quand un composant n'est pas trouvé dans l'arborescence.
 *
 * @author Quentin GOSSELIN
 */
public class ComposantIntrouvableException extends Exception {

	/**
	 * Constructeur faisant appel au constructeur de la classe Exception.
	 */
	public ComposantIntrouvableException() {
		super();
	}

	/**
	 * Constructeur prenant en paramètre une chaine de caractères faisant appel au contructeur correspondant de la class Exception.
	 *
	 * @param message Le message d'erreur type lorsque cette exception est levée
	 */
	public ComposantIntrouvableException(String message) {
		super(message);
	}
}

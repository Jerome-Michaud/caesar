package jscratch.exceptions;

/**
 * @since 1.0
 * @version 1.0
 */
public class IncompatibleTypeForTrace extends Exception {

	/**
	 * Constructeur par défaut de <code>IncompatibleTypeForTrace</code>.
	 */
	public IncompatibleTypeForTrace() {
		super();
	}
	
	/**
	 * Constructeur avec message de <code>IncompatibleTypeForTrace</code>.
	 * 
	 * @param msg le message
	 */
	public IncompatibleTypeForTrace(final String msg) {
		super(msg);
	}
}
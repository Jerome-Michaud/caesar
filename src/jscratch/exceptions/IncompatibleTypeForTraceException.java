package jscratch.exceptions;

/**
 * @since 1.0
 * @version 1.0
 */
public class IncompatibleTypeForTraceException extends Exception {

	/**
	 * Constructeur par défaut de <code>IncompatibleTypeForTrace</code>.
	 */
	public IncompatibleTypeForTraceException() {
		super();
	}
	
	/**
	 * Constructeur avec message de <code>IncompatibleTypeForTrace</code>.
	 * 
	 * @param msg le message
	 */
	public IncompatibleTypeForTraceException(final String msg) {
		super(msg);
	}
}
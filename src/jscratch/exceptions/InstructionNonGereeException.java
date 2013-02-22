package jscratch.exceptions;

/**
 * @since 1.0
 * @since 1.0
 */
public class InstructionNonGereeException extends Exception {

	/**
	 * Constructeur par défaut de <code>InstructionNonGereeException</code>.
	 */
	public InstructionNonGereeException() {
		super();
	}
	
	/**
	 * Constructeur avec message de <code>InstructionNonGereeException</code>.
	 * 
	 * @param msg le message
	 */
	public InstructionNonGereeException(final String msg) {
		super(msg);
	}
}
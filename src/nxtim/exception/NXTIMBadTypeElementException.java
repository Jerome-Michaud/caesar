package nxtim.exception;

import nxtim.instruction.TypeElement;

/**
 * Exception indiquant qu'un type incorrect est utilisé dans un élément de programme.
 * 
 * @since 1.0
 */
public class NXTIMBadTypeElementException extends RuntimeException {
	private TypeElement typeElement;

	/**
	 * Crée une exception indiquant une erreur de type.
	 * 
	 * @param badType le type déclenchant l'erreur.
	 */
	public NXTIMBadTypeElementException(TypeElement badType) {
		this(badType, "");
	}
	
	/**
	 * Crée une exception indiquant une erreur de type.
	 * 
	 * @param badType le type déclenchant l'erreur.
	 * @param message le message à associer à l'exception.
	 */
	public NXTIMBadTypeElementException(TypeElement badType, String message) {
		super(message);
		typeElement = badType;
	}
	
	/**
	 * Donne le type de l'élément ayant déclenché l'erreur.
	 * 
	 * @return le type à l'origine de l'erreur.
	 */
	public TypeElement getTypeElement() {
		return typeElement;
	}
	
	@Override
	public String getMessage() {
		return "(Bad type : " + typeElement + ") " + super.getMessage();
	}
}

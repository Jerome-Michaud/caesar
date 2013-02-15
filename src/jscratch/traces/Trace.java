package jscratch.traces;

import java.util.Date;

/**
 * Définit une trace.
 * 
 * @since 1.0
 * @version 1.0
 */
public class Trace {
	
	/**
	 * Type.
	 */
	private TypeTrace type;
	
	/**
	 * Heure d'apparition.
	 */
	private Date date;
	
	/**
	 * Default constructor of <code>Trace</code>.
	 */
	public Trace(TypeTrace type) {
		this.type = type;
		this.date = new Date();
	}
	
	public TypeTrace getType() {
		return this.type;
	}
}
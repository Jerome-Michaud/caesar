package nxtim.instruction;

/**
 * Variable modifiable.
 */
public class VariableModifiable extends Variable {
	/**
	 * Crée une variable modifiable sans valeur.
	 * 
	 * @param type le type de la variable
	 * @param nom le nom de la variable
	 */
	public VariableModifiable(final TypeVariable type, final String nom) {
		super(type, nom);
	}
	
	/**
	 * Crée une variable modifiable.
	 *
	 * @param type le type de la variable
	 * @param nom le nom de la variable
	 * @param valeur la valeur initiale de la variable.
	 */
	public VariableModifiable(final TypeVariable type, final String nom, final String valeur) {
		super(type, nom, valeur);
	}

	@Override
	public boolean isConstante() {
		return false;
	}
}
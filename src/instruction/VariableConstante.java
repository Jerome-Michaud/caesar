package instruction;

/**
 * Variable constante.
 */
public class VariableConstante extends Variable {

	/**
	 * Crée une variable constante.
	 *
	 * @param type le type de la variable
	 * @param nom le nom de la variable
	 * @param valeur la valeur initiale de la variable
	 */
	public VariableConstante(final TypeVariable type, final String nom, final String valeur) {
		super(type, nom, valeur);
	}

	@Override
	public boolean isConstante() {
		return true;
	}
}
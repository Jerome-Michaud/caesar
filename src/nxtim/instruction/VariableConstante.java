package nxtim.instruction;

/**
 * Variable constante ou valeur.
 */
public class VariableConstante extends Variable {

	/**
	 * Crée une variable constante.
	 *
	 * @param type le type de la variable
	 * @param nom le nom de la variable. Si vide la variable représente une valeur.
	 * @param valeur la valeur initiale de la variable
	 */
	public VariableConstante(final TypeElement type, final String nom, final String valeur) {
		super(type, nom, valeur);
	}
	
	/**
	 * Crée une valeur (variable constante sans nom).
	 * 
	 * @param type le type de la valeur
	 * @param valeur la valeur
	 */
	public VariableConstante(final TypeElement type, final String valeur) {
		super(type, "", valeur);
	}

	@Override
	public boolean isConstante() {
		return true;
	}
}
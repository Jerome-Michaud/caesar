package instruction;

public class VariableConstante extends Variable{

	/**
	 * Crée une variable constante.
	 * @param type Le type de la variable
	 * @param nom Le nom de la variable
	 * @param valeur La valeur initiale de la variable
	 */
	public VariableConstante(TypeVariable type, String nom,  String valeur) {
		super(type, nom, valeur);
	}
	
	@Override
	public boolean isConstante() {
		return true;
	}

}

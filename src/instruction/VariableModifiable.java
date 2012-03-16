package instruction;

/**
 * Variable modifiable.
 * @author Adrien, Ivan, Bastien
 */
public class VariableModifiable extends Variable{

	/**
	 * Crée une variable modifiable.
	 * @param type Le type de la variable
	 * @param nom Le nom de la variable
	 * @param valeur La valeur initiale de la variable.
	 */
	public VariableModifiable(TypeVariable type, String nom,  String valeur){
		super(type, nom, valeur);
	}

	@Override
	public boolean isConstante() {
		return false;
	}
}

package instruction;

/**
 * expression modifiable.
 */
public class ExpressionModifiable extends ExpressionA {

	/**
	 * Crée une variable modifiable.
	 *
	 * @param type le type de la variable
	 * @param nom le nom de la variable
	 *
	 */
	public ExpressionModifiable(final TypeExpression type, final String nom) {
		super(type, nom);
	}
}

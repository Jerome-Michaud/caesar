package instruction;

/**
 * Concept abstrait regroupant les expressions.
 */
public class ExpressionA {

	/**
	 * Le type de la expressions.
	 */
	private TypeExpression type;
	/**
	 * Le nom de l expressions.
	 */
	private String nom;

	/**
	 * Construit une expression.
	 *
	 * @param type le type de l expressions
	 * @param nom le nom de l expressions
	 *
	 */
	public ExpressionA(final TypeExpression type, final String nom) {
		this.type = type;
		this.nom = nom;
	}

	/**
	 * Accède au type de l expression.
	 *
	 * @return le type de l expression
	 */
	public TypeExpression getType() {
		return type;
	}

	/**
	 * Modifie le type de l expression.
	 *
	 * @param type le nouveau type
	 */
	public void setType(final TypeExpression type) {
		this.type = type;
	}

	/**
	 *
	 *
	 * @return le nom de l expression
	 */
	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}
}

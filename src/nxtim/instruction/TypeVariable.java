package nxtim.instruction;

/**
 * Cette énumération donne la liste des différents types possibles pour les variables.
 */
public enum TypeVariable {

	/**
	 * Tous les types de variable.
	 */
	INT, SHORT, LONG, FLOAT, DOUBLE, BOOL, STRING, LIST;

	@Override
	public String toString() {
		switch (this) {
			case INT:
				return "int";
			case SHORT:
				return "short";
			case LONG:
				return "long";
			case FLOAT:
				return "float";
			case DOUBLE:
				return "double";
			case BOOL:
				return "bool";
			case STRING:
				return "string";
			case LIST:
				return "list";
			default:
				return null;
		}
	}
	
	/**
	 * Charge le type de variable en fonction du type donnée en paramètre.
	 * 
	 * @param type le type de la variable au format <code>String</code>
	 * @return l'objet <code>TypeVariable</code> en fonction du paramètre
	 */
	public static TypeVariable fromString(final String type) {
		if ("int".equals(type)) {
			return INT;
		} else if ("short".equals(type)) {
			return SHORT;
		} else if ("long".equals(type)) {
			return LONG;
		} else if ("float".equals(type)) {
			return FLOAT;
		} else if ("double".equals(type)) {
			return DOUBLE;
		} else if ("bool".equals(type)) {
			return BOOL;
		} else if ("string".equals(type)) {
			return STRING;
		} else if ("list".equals(type)) {
			return LIST;
		} else {
			return null;
		}
	}
}
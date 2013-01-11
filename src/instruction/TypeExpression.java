package instruction;

/**
 * Cette énumération donne la liste des différents types possibles pour les expressions.
 */
public enum TypeExpression {

	/**
	 * Tous les types de expressions.
	 */
	ARITHMETIQUE, LOGIQUE;

	@Override
	public String toString() {
		switch (this) {
			case ARITHMETIQUE:
				return "arithmetique";
			case LOGIQUE:
				return "logique";

			default:
				return null;
		}
	}
}
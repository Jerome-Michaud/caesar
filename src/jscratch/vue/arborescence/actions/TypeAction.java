package jscratch.vue.arborescence.actions;

/**
 * Classe définissant les valeur possibles pour la classe Action.
 *
 * @author Quentin
 */
public enum TypeAction {

	DESSUS, DESSOUS, ACCROCHE, INTERNE, RIEN;

	/**
	 * Recupère la valeur de l'action au format int.
	 *
	 * @return la valeur de l'action
	 */
	public int toInt() {
		switch (this) {
			case DESSUS:
				return 1;
			case DESSOUS:
				return 0;
			case ACCROCHE:
				return 2;
			case INTERNE:
				return 3;
			default:
				return -1;
		}
	}

	@Override
	public String toString() {
		switch (this) {
			case DESSUS:
				return "1";
			case DESSOUS:
				return "0";
			case ACCROCHE:
				return "2";
			case INTERNE:
				return "3";
			default:
				return "Erreur";
		}
	}
}
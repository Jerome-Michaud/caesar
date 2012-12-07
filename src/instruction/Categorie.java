package instruction;

/**
 * Cette énumération regroupe les différentes catégories d'instructions possibles.
 */
/**
 * modification CHOUKET Houda
 */
public enum Categorie {

	/**
	 * Les différents types d'instructions.
	 */
	MOTEUR, CONTROL, OPERATEURS, VARIABLES, CAPTEURS, TEMPS, AFFICHAGE, EXPRESSION;

	@Override
	public String toString() {
		switch (this) {
		case MOTEUR:
			return "Moteur";
		case CONTROL:
			return "Contrôle";
		case OPERATEURS:
			return "Opérateur";
		case VARIABLES:
			return "Variables";
		case CAPTEURS:
			return "Capteurs";
		case TEMPS:
			return "Gestion du temps";
		case AFFICHAGE:
			return "Affichage";
		case EXPRESSION:
			return "Expression";
		default:
			return null;
		}
	}
}

package nxtim.instruction;

/**
 * Cette énumération regroupe les différentes catégories d'instructions et d'expressions possibles.
 */
public enum Categorie {

	/**
	 * Instruction structure (fonctions, tâches).
	 */
	STRUCTURES,
	/**
	 * Instruction de moteur.
	 */
	MOTEURS,
	/**
	 * Variable ou instruction associée aux variables.
	 */
	VARIABLES,
	/**
	 * Instruction associée aux capteurs
	 */
	CAPTEURS,
	/**
	 * Instruction de gestion du temps.
	 */
	TEMPS,
	/**
	 * Expression diverse.
	 */
	EXPRESSIONS;

	@Override
	public String toString() {
		switch (this) {
			case STRUCTURES:
				return "Structures";
			case MOTEURS:
				return "Moteurs";
			case VARIABLES:
				return "Variables";
			case CAPTEURS:
				return "Capteurs";
			case TEMPS:
				return "Temps";
			case EXPRESSIONS:
				return "Expressions";
			default:
				return null;
		}
	}
}

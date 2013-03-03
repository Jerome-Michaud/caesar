package nxtim.instruction;

import jscratch.helpers.LangueHelper;
import jscratch.parametrages.langue.VariableLangue;

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

	/**
	 * Permet de récupérer le nom de la clé pour la catégorie afin de l'utiliser dans un fichier properties.
	 * 
	 * @since 1.0
	 * 
	 * @return le nom
	 */
	public String toProperties() {
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
	
	@Override
	public String toString() {
		switch (this) {
			case STRUCTURES:
				return LangueHelper.getInstance().get(VariableLangue.CAT_STRUCTURES);
			case MOTEURS:
				return LangueHelper.getInstance().get(VariableLangue.CAT_MOTEURS);
			case VARIABLES:
				return LangueHelper.getInstance().get(VariableLangue.CAT_VARIABLES);
			case CAPTEURS:
				return LangueHelper.getInstance().get(VariableLangue.CAT_CAPTEURS);
			case TEMPS:
				return LangueHelper.getInstance().get(VariableLangue.CAT_TEMPS);
			case EXPRESSIONS:
				return LangueHelper.getInstance().get(VariableLangue.CAT_EXPRESSIONS);
			default:
				return null;
		}
	}
}

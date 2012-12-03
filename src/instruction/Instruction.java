package instruction;

/**
 * Une instruction est une commande exécutable d'un programme.<br/>
 * Les instructions peuvent être divisées en plusieurs catégories et peuvent être traduites dans différents langages.
 */
public interface Instruction extends IElementProgramme {

	/**
	 * Donne la catégorie de l'instruction.
	 * 
	 * @return la catégorie
	 */
	Categorie getCategorie();
}

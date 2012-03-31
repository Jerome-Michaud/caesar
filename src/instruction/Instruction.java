package instruction;

import traduction.VisiteurTraduction;

/**
 * Une instruction est une commande exécutable d'un programme.
 * Les instructions peuvent être divisées en plusieurs catégories et
 * peuvent être traduites dans différents langages.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public interface Instruction extends IElementProgramme {

	/**
	 * Donne la catégorie de l'instruction
	 * @return la catégorie
	 */
	Categorie getCategorie();
	
	/**
	 * Accept un objet sachant traduire l'instruction.
	 * @param visiteur l'objet traducteur
	 */
	void accepte(VisiteurTraduction visiteur);
}

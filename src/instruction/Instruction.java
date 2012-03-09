package instruction;

import java.util.List;

import traduction.VisiteurTraduction;

public interface Instruction {

	/**
	 * Donne la catégorie de l'instruction
	 * @return 
	 */
	Categorie getCategorie();
	
	/**
	 * Accept un objet sachant traduire l'instruction.
	 * @param visiteur
	 */
	void accepte(VisiteurTraduction visiteur);
}

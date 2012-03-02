package instruction;

import java.util.List;

import traduction.VisiteurTraduction;

public interface Instruction {

	/**
	 * 
	 * @return 
	 */
	Categorie getCategorie();
	
	/**
	 * 
	 * @return
	 */
	List<Instruction> getEnfants();
	
	/**
	 * 
	 * @param visiteur
	 */
	void accepte(VisiteurTraduction visiteur);
		
	
	
}

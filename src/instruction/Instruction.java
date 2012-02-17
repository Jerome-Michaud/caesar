package instruction;

import java.util.List;

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
	void accept(VisiteurTraduction visiteur);
		
	
	
}

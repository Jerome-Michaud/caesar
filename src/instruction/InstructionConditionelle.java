package instruction;

import traduction.VisiteurTraduction;

public abstract class InstructionConditionelle extends InstructionStructure {
	
	private Condition cond;

	@Override
	public Categorie getCategorie(){
		return Categorie.CONTROL;
	}
	
}

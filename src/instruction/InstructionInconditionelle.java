package instruction;

import traduction.VisiteurTraduction;

public abstract class InstructionInconditionelle extends InstructionStructure {

	@Override
	public abstract Categorie getCategorie();

	@Override
	public abstract void accepte(VisiteurTraduction visiteur);
	
}

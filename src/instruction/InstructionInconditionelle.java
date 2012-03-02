package instruction;

public abstract class InstructionInconditionelle extends InstructionStructure {

	@Override
	public abstract Categorie getCategorie();

	@Override
	public abstract void accepte(VisiteurTraduction visiteur);
	
}

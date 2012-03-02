package instruction;

public abstract class InstructionConditionelle extends InstructionStructure {
	
	private Condition cond;

	@Override
	public Categorie getCategorie(){
		return Categorie.CONTROL;
	}

	@Override
	public abstract void accepte(VisiteurTraduction visiteur);
	
	
	
}

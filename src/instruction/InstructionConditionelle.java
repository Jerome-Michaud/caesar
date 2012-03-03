package instruction;

public abstract class InstructionConditionelle extends InstructionStructure {
	
	private Condition cond;

	public InstructionConditionelle(Condition cond){
		this.cond = cond;
	}
	
	@Override
	public final Categorie getCategorie(){
		return Categorie.CONTROL;
	}
	
}

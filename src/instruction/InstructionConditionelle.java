package instruction;

public abstract class InstructionConditionelle extends InstructionStructure {
	
	public InstructionConditionelle() {
		super();
	}
	private Condition condition;
	
	public InstructionConditionelle(Condition condition) {
		super();
		this.condition = condition;
	}

	@Override
	public final Categorie getCategorie(){
		return Categorie.CONTROL;
	}
	
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition cond) {
		condition = cond;
	}
}

package instruction;

public abstract class InstructionConditionelle extends InstructionStructure {
	
	private Condition condition;

	public InstructionConditionelle(Condition cond){
		this.condition = cond;
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

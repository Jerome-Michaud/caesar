package instruction;

public class InstructionIfElse extends InstructionConditionelle {
	
	private InstructionIf instIf;
		
	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

	
}

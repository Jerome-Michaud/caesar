package instruction;

import traduction.VisiteurTraduction;

public class InstructionIfElse extends InstructionConditionelle {

	public InstructionIfElse(Condition cond) {
		super(cond);
	}
	
	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

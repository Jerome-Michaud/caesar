package instruction;

import traduction.VisiteurTraduction;

public class InstructionWhile extends InstructionConditionelle {

	public InstructionWhile(Condition cond) {
		super(cond);
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

package instruction;

import traduction.VisiteurTraduction;

public class InstructionDoWhile extends InstructionConditionelle {

	public InstructionDoWhile(Condition cond) {
		super(cond);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

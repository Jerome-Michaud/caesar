package instruction;

import traduction.VisiteurTraduction;

public class InstructionFor extends InstructionConditionelle{

	
	public InstructionFor() {
		super(null);
		// TODO Auto-generated constructor stub
	}
	public InstructionFor(Condition cond) {
		super(cond);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
}

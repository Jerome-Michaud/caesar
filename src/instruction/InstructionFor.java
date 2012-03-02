package instruction;

import traduction.VisiteurTraduction;

public class InstructionFor extends InstructionConditionelle{

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
		
	}

}

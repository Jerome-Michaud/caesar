package instruction;

import traduction.VisiteurTraduction;

public class InstructionWhile extends InstructionConditionelle {

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

package instruction;

public class InstructionDoWhile extends InstructionConditionelle {

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

package instruction;

public class InstructionDoWhile extends InstructionConditionelle {

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

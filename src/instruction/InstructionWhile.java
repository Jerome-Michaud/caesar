package instruction;

public class InstructionWhile extends InstructionConditionelle {

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

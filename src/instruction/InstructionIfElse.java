package instruction;

public class InstructionIfElse extends InstructionConditionelle {

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

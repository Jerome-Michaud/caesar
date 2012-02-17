package instruction;

public class InstructionIf extends InstructionConditionelle {

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}

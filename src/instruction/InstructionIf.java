package instruction;

public class InstructionIf extends InstructionConditionelle {

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}

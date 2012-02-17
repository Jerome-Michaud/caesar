package instruction;

import java.util.List;

public abstract class InstructionTerminale implements Instruction {

	@Override
	public abstract Categorie getCategorie();

	@Override
	public List<Instruction> getEnfants() {
		return null;
	}

	@Override
	public abstract void accept(VisiteurTraduction visiteur);

}

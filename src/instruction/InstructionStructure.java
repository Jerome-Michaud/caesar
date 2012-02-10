package instruction;

import java.util.List;

public abstract class InstructionStructure implements Instruction {

	@Override
	public abstract Categorie getCategorie();

	@Override
	public List<Instruction> getEnfants() {
		return enfants;
	}

	@Override
	public abstract void accept(Visiteur visiteur);

	private List enfants;
	
}

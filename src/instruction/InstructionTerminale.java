package instruction;

import java.util.List;

public abstract class InstructionTerminale implements Instruction {

	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instruction> getEnfants() {
		return null;
	}

	@Override
	public abstract void accept(Visiteur visiteur);
	

}

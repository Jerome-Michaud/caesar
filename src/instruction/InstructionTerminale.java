package instruction;

import java.util.List;

import traduction.VisiteurTraduction;

public abstract class InstructionTerminale implements Instruction {

	@Override
	public abstract Categorie getCategorie();

	@Override
	public abstract void accepte(VisiteurTraduction visiteur);

}

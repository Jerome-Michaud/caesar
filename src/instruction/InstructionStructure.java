package instruction;

import java.util.List;

import traduction.VisiteurTraduction;

public abstract class InstructionStructure implements Instruction {

	protected List<Instruction> enfants;
		
	public InstructionStructure() {}
	
	public InstructionStructure(List<Instruction> enfants) {
		this.enfants = enfants;
	}

	public void inserer(int pos, Instruction inst){
		enfants.add(pos, inst);
	}
	
	@Override
	public abstract Categorie getCategorie();

	@Override
	public List<Instruction> getEnfants() {
		return enfants;
	}
	
	@Override
	public abstract void accepte(VisiteurTraduction visiteur);

	
}

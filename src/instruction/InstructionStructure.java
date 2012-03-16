package instruction;

import java.util.ArrayList;
import java.util.List;

import traduction.VisiteurTraduction;

public abstract class InstructionStructure implements Instruction {

	protected List<Instruction> enfants;
		
	public InstructionStructure() {
		enfants = new ArrayList<Instruction>();
	}
	
	public InstructionStructure(List<Instruction> enfants) {
		this.enfants = enfants;
	}

	public void inserer(int pos, Instruction inst){
		enfants.add(pos, inst);
	}
	
	@Override
	public abstract Categorie getCategorie();
	
	@Override
	public abstract void accepte(VisiteurTraduction visiteur);

	public String toString()
	{
		String temp= "\n";
		for ( Instruction enfant:enfants )
		{
			temp += "->"+enfant.toString()+ "\n";
		}
		return temp;
	}
}

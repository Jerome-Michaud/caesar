package instruction;

import java.util.ArrayList;
import java.util.List;

import traduction.VisiteurTraduction;

public abstract class InstructionStructure implements Instruction {
	
	public static final int POSITION_DEBUT_CODE = 0;
	public static final int POSITION_FIN_CODE = Integer.MAX_VALUE;
	
	private List<Instruction> enfants ;
		
	public InstructionStructure() {
		enfants = new ArrayList<Instruction>();
	}
	
	public InstructionStructure(List<Instruction> enfants) {
		this.enfants = enfants;
	}

	public void inserer(int position, Instruction inst){
		if (position==POSITION_FIN_CODE)
			ajouterFin(inst);
		else 
			enfants.add(position,inst);
	}
	
	public void ajouterDebut(Instruction inst){
		enfants.add(POSITION_DEBUT_CODE, inst);	
	}
	
	public void ajouterFin(Instruction inst){
		enfants.add(inst);	
	}
	
	public List<Instruction> getEnfants() {
		return enfants;
	}
	
	@Override
	public String toString(){
		String res = "";
		res+="main(){\n";
		for (Instruction is : enfants){
			res += "\t" + is + ";\n";
		}
		res+="}";
		return res;
	}
	
	@Override
	public abstract Categorie getCategorie();
	
	@Override
	public abstract void accepte(VisiteurTraduction visiteur);


}

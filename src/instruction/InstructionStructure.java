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
			insererFin(inst);
		else 
			enfants.add(position,inst);
	}
	
	public void insererDebut(Instruction inst){
		enfants.add(POSITION_DEBUT_CODE, inst);	
	}
	
	public void insererFin(Instruction inst){
		enfants.add(inst);	
	}
	
	/**
	 * Donne la liste des instructions du corps de l'instruction
	 * @return la liste des instructions
	 */
	public List<Instruction> getEnfants() {
		return enfants;
	}
	
	/**
	 * Donne la liste des instrauctions du corps de l'instruction à partir d'une position.
	 * @param pos la position de départ.
	 * @return la liste des instructions concernées.
	 */
	public List<Instruction> getEnfants(int pos) {
		return enfants.subList(pos, enfants.size()-1);
	}
	
	@Override
	public abstract Categorie getCategorie();
	
	@Override
	public abstract void accepte(VisiteurTraduction visiteur);


}

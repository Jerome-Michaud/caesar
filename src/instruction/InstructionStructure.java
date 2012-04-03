package instruction;

import java.util.ArrayList;
import java.util.List;
/**
 * Concept abstrait regroupant toutes les instructions composées d'un corps contenant d'autres instruction.
 * Design pattern Composite.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
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
	
	public void inserer(int position, List<Instruction> instListe){
		if (position==POSITION_FIN_CODE)
			enfants.addAll(instListe);
		else 
			enfants.addAll(position,instListe);
	}
	
	public void insererDebut(List<Instruction> instListe){
		enfants.addAll(POSITION_DEBUT_CODE, instListe);	
	}
	
	public void insererFin(List<Instruction> instListe){
		enfants.addAll(instListe);	
	}
	
	/**
	 * Donne la liste des instructions du corps de l'instruction
	 * @return la liste des instructions
	 */
	public List<Instruction> getEnfants() {
		return enfants;
	}
	
	/**
	 * Donne la liste des instrauctions du corps de l'instruction à partir d'une certaine position.
	 * @param pos la position de départ.
	 * @return la liste des instructions concernées.
	 */
	public List<Instruction> getEnfants(int pos) {
		return new ArrayList<Instruction>(enfants.subList(pos, enfants.size()));
	}
	
	/**
	 * Supprime toutes les instructions du corps de l'instruction.
	 * @return la liste des enfants supprimes
	 */
	public List<Instruction> removeEnfants() {
		return removeEnfants(0);
	}
	
	/**
	 * Supprime toutes les instructions du corps
	 * de l'instruction à partir d'un certain rang.
	 * @param pos le rang de départ
	 * @return la liste des enfants supprimes
	 */
	public List<Instruction> removeEnfants(int pos) {
		List<Instruction> res = getEnfants(pos);
		enfants.removeAll(res);
		return res;
	}
}

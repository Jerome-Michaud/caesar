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

	/**
	 * Crée une instruction "structure" vide.
	 */
	public InstructionStructure() {
		enfants = new ArrayList<Instruction>();
	}
	
	/**
	 * Crée une instruction "structure" avec des instruction dans le corps.
	 * @param enfants la liste des instruction du corps
	 */
	public InstructionStructure(List<Instruction> enfants) {
		this.enfants = enfants;
	}

	/**
	 * Ajoute une instruction dans le corps.
	 * @param position la position où insérer l'instruction
	 * @param inst l'instruction
	 */
	public void inserer(int position, Instruction inst){
		if (position==POSITION_FIN_CODE)
			insererFin(inst);
		else 
			enfants.add(position,inst);
	}
	
	/**
	 * Ajoute une instruction au début du corps.
	 * @param inst l'instruction
	 */
	public void insererDebut(Instruction inst){
		enfants.add(POSITION_DEBUT_CODE, inst);	
	}
	
	/**
	 * Ajoute une instruction à la fin du corps.
	 * @param inst l'instruction
	 */
	public void insererFin(Instruction inst){
		enfants.add(inst);	
	}
	
	/**
	 * Ajoute plusieurs instructions dans le corps.
	 * @param position la position où insérer les instructions
	 * @param instListe la liste des instructions
	 */
	public void inserer(int position, List<Instruction> instListe){
		if (position==POSITION_FIN_CODE)
			enfants.addAll(instListe);
		else 
			enfants.addAll(position,instListe);
	}
	
	/**
	 * Ajoute plusieurs instructions au début du corps.
	 * @param instListe les instructions
	 */
	public void insererDebut(List<Instruction> instListe){
		enfants.addAll(POSITION_DEBUT_CODE, instListe);	
	}
	
	/**
	 * Ajoute plusieurs instructions à la fin du corps.
	 * @param instListe les instructions
	 */
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

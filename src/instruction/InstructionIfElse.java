package instruction;

import java.util.List;

import traduction.VisiteurTraduction;

public class InstructionIfElse extends InstructionConditionelle {

	private InstructionIf membreIf = new InstructionIf();
	
	public InstructionIfElse() {
		super(null);
	}
	
	public InstructionIfElse(Condition cond) {
		super(null);
		getMembreIf().setCondition(cond);
	}
	
	public Condition getCondition(){
		return getMembreIf().getCondition();
	}
	
	public void setCondition(Condition cond){
		getMembreIf().setCondition(cond);
	}
		
	public InstructionIf getMembreIf()
	{
		return membreIf;
	}
	
	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

	/**
	 * Insère une instruction dans le corps de if.
	 */
	public void inserer(int position, Instruction inst){
		membreIf.inserer(position,inst);
	}
	
	/**
	 * Insère une instruction dans le corps de if.
	 */
	public void insererDebut(Instruction inst){
		membreIf.insererDebut(inst);
	}
	
	/**
	 * Insère une instruction dans le corps de if.
	 */
	public void insererFin(Instruction inst){
		membreIf.insererFin(inst);
	}
	
	/**
	 * Donne les instructions du corps de if.
	 * @return la list des instructions du corps de if.
	 */
	public List<Instruction> getEnfants() {
		return membreIf.getEnfants();
	}
	
	public void insererElse(int position, Instruction inst){
		super.inserer(position,inst);
	}
	
	public void insererDebutElse(Instruction inst){
		super.insererDebut(inst);
	}
	
	public void insererFinElse(Instruction inst){
		super.insererFin(inst);
	}
	
	public List<Instruction> getEnfantsElse() {
		return super.getEnfants();
	}	
	
	public String toString(){
		String res = "";
		res+= getMembreIf().toString();
		res+= "\telse\n{";
		for (Instruction is : getEnfantsElse()){
			res += "\t" + is + ";\n";
		}
		res+="\t}\n";
		return res;
	}
	
	/**
	 * TODO changer
	 * Donne la liste des instrauctions du corps du membre IF à partir d'une certaine position.
	 * @param pos la position de départ.
	 * @return la liste des enfants du membre IF a partir de rang precise
	 */
	@Override
	public List<Instruction> getEnfants(int pos) {
		return membreIf.getEnfants(pos);
	}
	
	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps  du membre IF.
	 * @return la liste des enfants du membre IF
	 */
	@Override
	public List<Instruction> removeEnfants() {
		return membreIf.removeEnfants();
	}
	
	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps
	 *  du membre IF à partir d'un certain rang.
	 * @param pos le rang de départ
	 * @return la liste des enfants du membre IF a partir de rang precise
	 */
	@Override
	public List<Instruction> removeEnfants(int pos) {
		return membreIf.removeEnfants(pos);
	}
	
	/**
	 * TODO changer
	 * Donne la liste des instrauctions du corps du membre ELSE à partir d'une certaine position.
	 * @param pos la position de départ.
	 * @return la liste des enfants du membre ELSE a partir de rang precise
	 */
	public List<Instruction> getEnfantsElse(int pos) {
		return super.getEnfants(pos);
	}
	
	/**
	 * Supprime toutes les instructions du corps du membre ELSE.
	 * @return la liste des enfants du membre ELSE
	 */

	public List<Instruction> removeEnfantsElse() {
		return super.removeEnfants();
	}
	
	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps
	 * du membre ELSE à partir d'un certain rang.
	 * @param pos le rang de départ
	 * @return la liste des enfants du membre ELSE a partir de rang precise
	 */
	public List<Instruction> removeEnfantsElse(int pos) {
		return super.removeEnfants(pos);
	}
}

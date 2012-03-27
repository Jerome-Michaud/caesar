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
	public void insererIf(int position, Instruction inst){
		membreIf.inserer(position,inst);
	}
	
	/**
	 * Insère une instruction dans le corps de if.
	 */
	public void insererDebutIf(Instruction inst){
		membreIf.insererDebut(inst);
	}
	
	/**
	 * Insère une instruction dans le corps de if.
	 */
	public void insererFinIf(Instruction inst){
		membreIf.insererFin(inst);
	}
	
	/**
	 * Insère une liste des instructions dans le corps de if.
	 */
	public void insererIf(int position, List<Instruction> instListe){
		membreIf.inserer(position, instListe);
	}
	
	/**
	 * Insère une liste des instructions dans le corps de if.
	 */
	public void insererDebutIf(List<Instruction> instListe){
		membreIf.insererDebut(instListe);
	}
	
	/**
	 * Insère une liste des instructions dans le corps de if.
	 */
	public void insererFinIf(List<Instruction> instListe){
		membreIf.insererFin(instListe);
	}
	
	/**
	 * Donne les instructions du corps de if.
	 * @return la list des instructions du corps de if.
	 */
	public List<Instruction> getEnfantsIf() {
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
	
	public void insererElse(int position, List<Instruction> instListe){
		super.inserer(position,instListe);
	}
	
	public void insererDebutElse(List<Instruction> instListe){
		super.insererDebut(instListe);
	}
	
	public void insererFinElse(List<Instruction> instListe){
		super.insererFin(instListe);
	}
	
	public List<Instruction> getEnfantsElse() {
		return getEnfants();
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
	public List<Instruction> getEnfantsIf(int pos) {
		return membreIf.getEnfants(pos);
	}
	
	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps  du membre IF.
	 * @return la liste des enfants du membre IF
	 */
	public List<Instruction> removeEnfantsIf() {
		return membreIf.removeEnfants();
	}
	
	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps
	 *  du membre IF à partir d'un certain rang.
	 * @param pos le rang de départ
	 * @return la liste des enfants du membre IF a partir de rang precise
	 */
	public List<Instruction> removeEnfantsIf(int pos) {
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

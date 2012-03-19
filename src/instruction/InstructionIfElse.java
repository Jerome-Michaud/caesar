package instruction;

import java.util.ArrayList;
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
	 * inserer sur if
	 */
	public void inserer(int position, Instruction inst){
		membreIf.inserer(position,inst);
	}
	/**
	 * inserer sur if
	 */
	public void insererDebut(Instruction inst){
		membreIf.insererDebut(inst);
	}
	/**
	 * inserer sur if
	 */
	public void insererFin(Instruction inst){
		membreIf.insererFin(inst);
	}
	/**
	 * get If enfants
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
}

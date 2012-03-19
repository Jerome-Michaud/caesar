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
	public void ajouterDebut(Instruction inst){
		membreIf.ajouterDebut(inst);
	}
	/**
	 * inserer sur if
	 */
	public void ajouterFin(Instruction inst){
		membreIf.ajouterFin(inst);
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
	
	public void ajouterDebutElse(Instruction inst){
		super.ajouterDebut(inst);
	}
	
	public void ajouterFinElse(Instruction inst){
		super.ajouterFin(inst);
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

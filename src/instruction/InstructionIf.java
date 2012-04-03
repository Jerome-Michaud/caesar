package instruction;

import traduction.VisiteurTraduction;
/**
 * Structure conditionnelle if.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionIf extends InstructionConditionelle {
	/**
	 * Crée une instruction if sans condition. La condition a pour valeur null.
	 */
	public InstructionIf(){
		super(null);
	}
	
	/**
	 * Créé une instruction if.
	 * @param cond la condition
	 */
	public InstructionIf(Condition cond) {
		super(cond);
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
	@Override
	public String toString(){
		String res = "";
		res+="if("+getCondition()+"){\n";
		for (Instruction is : getEnfants()){
			res += "\t" + is + ";\n";
		}
		res+="\t}\n";
		return res;
	}
}
package instruction;

import traduction.VisiteurTraduction;

public class InstructionWhile extends InstructionConditionelle {

	public InstructionWhile() {
		super(null);
	}
	public InstructionWhile(Condition cond) {
		super(cond);
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	public String toString(){
		String res = "";
		res+="While("+getCondition()+"){\n";
		for (Instruction is : getEnfants()){
			res += "\t" + is + ";\n";
		}
		res+="\t}\n";
		return res;
	}
}

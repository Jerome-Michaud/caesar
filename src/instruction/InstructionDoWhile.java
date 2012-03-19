package instruction;

import traduction.VisiteurTraduction;

public class InstructionDoWhile extends InstructionConditionelle {

	public InstructionDoWhile() {
		super(null);
		// TODO Auto-generated constructor stub
	}
	public InstructionDoWhile(Condition cond) {
		super(cond);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
	public String toString(){
		String res = "";
		res+="Dowhile("+condition+"){\n";
		for (Instruction is : getEnfants()){
			res += "\t" + is + ";\n";
		}
		res+="\t}\n";
		return res;
	}

}

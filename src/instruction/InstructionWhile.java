package instruction;

import traduction.VisiteurTraduction;
/**
 * Boucle conditionnelle simple : "Tant que". 
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionWhile extends InstructionConditionelle {

	/**
	 * Crée une boucle sans condition.
	 * La condition à pour valeur null.
	 */
	public InstructionWhile() {
		super(null);
	}
	
	/**
	 * Crée une boucle conditionnelle.
	 * @param cond la condition de bouclage.
	 */
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
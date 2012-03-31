package instruction;

import traduction.VisiteurTraduction;

/**
 * Boucle jusqu'à condition.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionDoWhile extends InstructionConditionelle {

	/**
	 * Créé une boucle DoWhile non initialisée.
	 * La condition à pour valeur null.
	 */
	public InstructionDoWhile() {
		super();
	}
	
	/**
	 * Créé une boucle DoWhile.
	 * @param cond la condition d'arrêt de la boucle.
	 */
	public InstructionDoWhile(Condition cond) {
		super(cond);
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
	@Override
	public String toString(){
		String res = "";
		res+="Dowhile("+getCondition()+"){\n";
		for (Instruction is : getEnfants()){
			res += "\t" + is + ";\n";
		}
		res+="\t}\n";
		return res;
	}
}

package instruction;

import traduction.VisiteurTraduction;

/**
 * Boucle conditionnelle simple : "Tant que".
 */
public class InstructionWhile extends InstructionConditionelle {

	/**
	 * Crée une boucle sans condition.<br/>
	 * La condition à pour valeur <code>null</code>.
	 */
	public InstructionWhile() {
		super(null);
	}

	/**
	 * Crée une boucle conditionnelle.
	 *
	 * @param cond la condition de bouclage.
	 */
	public InstructionWhile(final Condition cond) {
		super(cond);
	}

	@Override
	public void accepte(final VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

	@Override
	public String toString() {
		String res = "";
		res += "While(" + getCondition() + "){\n";
		for (Instruction is : getEnfants()) {
			res += "\t" + is + ";\n";
		}
		res += "\t}\n";
		return res;
	}
}
package nxtim.instruction;

/**
 * Structure conditionnelle if.
 */
public class InstructionIf extends InstructionConditionelle {

	/**
	 * Crée une instruction if sans condition.<br/>
	 * La condition a pour valeur
	 * <code>null</code>.
	 */
	public InstructionIf() {
		super(null);
	}

	/**
	 * Créé une instruction if.
	 *
	 * @param cond la condition
	 */
	public InstructionIf(final Condition cond) {
		super(cond);
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	@Override
	public String toString() {
		String res = "";
		res += "if(" + getCondition() + "){\n";
		for (Instruction is : getEnfants()) {
			res += "\t" + is + ";\n";
		}
		res += "\t}\n";
		return res;
	}
}
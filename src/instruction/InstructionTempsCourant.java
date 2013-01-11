package instruction;

/**
 * Instruction donnant le temps écoulé depuis le lancement du programme.
 *
 * @author Adrien DUROY
 */
public class InstructionTempsCourant implements Instruction {

	/**
	 * La variable dans laquelle sera stocké le temps courant.
	 */
	private VariableModifiable var;

	/**
	 * Créé une instruction donnant le temps courant sans variable pour recevoir le temps.
	 */
	public InstructionTempsCourant() {
		this(null);
	}

	/**
	 * Créé une instruction donnant le temps courant.
	 *
	 * @param var la variable qui recevra le temps courant.
	 */
	public InstructionTempsCourant(VariableModifiable var) {
		this.var = var;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	/**
	 * Accède à la variable qui reçoit le temps courant.
	 *
	 * @return la variable recevant le temps courant, ou null si elle n'a pas été précisée.
	 */
	public VariableModifiable getVariable() {
		return var;
	}

	/**
	 * Modifit la variable qui recevra le temps courant.
	 *
	 * @param var la nouvelle variable.
	 */
	public void setVariable(VariableModifiable var) {
		this.var = var;
	}
}
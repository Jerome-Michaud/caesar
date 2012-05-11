package instruction;

/**
 * Concept abstrait regroupant toutes les instructions possédant une condition.
 */
public abstract class InstructionConditionelle extends InstructionStructure {

	/**
	 * La condition.
	 */
	private Condition condition;

	/**
	 * Créé une instruction conditionnelle sans initialisé la condition.<br/>
	 * La condition à pour valeur <code>null</code>.
	 */
	public InstructionConditionelle() {
		super();
	}

	/**
	 * Créé une instruction conditionnelle.
	 *
	 * @param condition La condition associée à l'instruction.
	 */
	public InstructionConditionelle(final Condition condition) {
		super();
		this.condition = condition;
	}

	@Override
	public final Categorie getCategorie() {
		return Categorie.CONTROL;
	}

	/**
	 * Accède à la condition.
	 *
	 * @return la condition.
	 */
	public Condition getCondition() {
		return condition;
	}

	/**
	 * Modifie la condition.
	 *
	 * @param cond la nouvelle condition.
	 */
	public void setCondition(final Condition cond) {
		condition = cond;
	}
}

package instruction;

/**
 * Concept abstrait regroupant toutes les instructions possèdant une condition.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public abstract class InstructionConditionelle extends InstructionStructure {
	private Condition condition;
	
	/**
	 * Créé une instruction conditionnelle sans initialisé la condition.
	 * La condition à pour valeur null.
	 */
	public InstructionConditionelle() {
		super();
	}
	
	/**
	 * Créé une instruction conditionnelle.
	 * @param condition La condition associée à l'instruction.
	 */
	public InstructionConditionelle(Condition condition) {
		super();
		this.condition = condition;
	}

	@Override
	public final Categorie getCategorie(){
		return Categorie.CONTROL;
	}
	
	/**
	 * Accède à la condition.
	 * @return la condittion.
	 */
	public Condition getCondition() {
		return condition;
	}
	
	/**
	 * Modifie la condition.
	 * @param cond la nouvelle condition.
	 */
	public void setCondition(Condition cond) {
		condition = cond;
	}
}

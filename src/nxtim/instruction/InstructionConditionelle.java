package nxtim.instruction;

import nxtim.exception.NXTIMBadTypeElementException;

/**
 * Concept abstrait regroupant toutes les instructions possédant une condition.
 */
public abstract class InstructionConditionelle extends InstructionStructure {

	/**
	 * La condition.
	 */
	private Expression condition;

	/**
	 * Crée une instruction conditionnelle sans initialisé la condition.<br/>
	 * La condition à pour valeur
	 * <code>null</code>.
	 */
	public InstructionConditionelle() {
		super();
		condition = null;
	}

	/**
	 * Crée une instruction conditionnelle avec une condition binaire.
	 *
	 * @param condition La condition associée à l'instruction.
	 */
	public InstructionConditionelle(final Condition condition) {
		super();
		this.condition = condition;
	}
	
	/**
	 * Crée une instruction conditionnelle avec une négation comme condition.
	 * 
	 * @param condition la négation à utiliser comme condition
	 */
	public InstructionConditionelle(final NonLogique condition) {
		super();
		this.condition = condition;
	}
	
	/**
	 * Crée une instruction conditionnelle avec une variable booléenne comme condition.
	 * 
	 * @param condition la variable booléenne
	 */
	public InstructionConditionelle(final Variable condition) {
		super();
		assert condition != null;// théoriquement ce constructeur n'est jamais appelé avec l'argument null
		
		if(condition.isBooleenne()) {
			this.condition = condition;
		}
		else {
			throw new NXTIMBadTypeElementException(condition.getType(), "Variable non booléenne utilisée comme condition à une expression conditionelle.");
		}
	}

	@Override
	public final Categorie getCategorie() {
		return Categorie.STRUCTURES;
	}

	/**
	 * Accède à la condition.
	 *
	 * @return la condition.
	 */
	public Expression getCondition() {
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
	
	/**
	 * Modifie la condition par une négation.
	 *
	 * @param cond une négation.
	 */
	public void setCondition(final NonLogique cond) {
		condition = cond;
	}
	
	/**
	 * Modifie la condition par une variable.
	 * 
	 * @param cond une variable booléenne.
	 */
	public void setCondition(final Variable cond) {
		if(cond == null || cond.isBooleenne()) {
			condition = cond;
		}
		else {
			throw new NXTIMBadTypeElementException(cond.getType(), "Variable non booléenne utilisée comme condition à une expression conditionelle.");
		}
	}
	
	/**
	 * Supprime la condition.
	 * La condition a pour valeur
	 * <code>null</code>.
	 */
	public void rmCondition() {
		condition = null;
	}
}

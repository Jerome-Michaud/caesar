package nxtim.instruction;

/**
 * Boucle d'une situation de départ jusqu'à
 * une condition avec un traitement à chaque tour de boucle.
 *
 * @author Adrien DUROY, Bastien AUBRY
 */
public class InstructionFor extends InstructionConditionelle {

	/**
	 * La valeur d'initialisation.
	 */
	private Affectation initialisation;
	/**
	 * Expression à chaque itération.
	 */
	private Expression iteration;

	/**
	 * Crée une boucle For non initialisée.<br/>
	 * Ses membres ont pour valeur
	 * <code>null</code>.
	 */
	public InstructionFor() {
		super();
	}

	/**
	 * Crée une boucle For.
	 *
	 * @param initialisation l'initialisation
	 * @param condition la condition d'arrêt
	 * @param iteration le traitement de fin de tour de boucle
	 */
	public InstructionFor(final Affectation initialisation, final Condition condition, final InstructionIncrementation iteration) {
		super(condition);
		this.initialisation = initialisation;
		iteration.setIsInstruction(false);
		this.iteration = iteration;
		this.initialisation.setIsInstruction(false);
	}
	
	/**
	 * Crée une boucle For.
	 *
	 * @param initialisation l'initialisation
	 * @param condition la condition d'arrêt
	 * @param iteration le traitement de fin de tour de boucle
	 */
	public InstructionFor(final Affectation initialisation, final Condition condition, final Affectation iteration) {
		super(condition);
		this.initialisation = initialisation;
		iteration.setIsInstruction(false);
		this.iteration = iteration;
		this.initialisation.setIsInstruction(false);
	}

	/**
	 * Accède à la partie initialisation de la boucle.
	 *
	 * @return l'affectation d'initialisation
	 */
	public Affectation getInitialisation() {
		return initialisation;
	}

	/**
	 * Modifie l'initialisation de la boucle.
	 *
	 * @param intialisation la nouvelle affectation d'initialisation
	 */
	public void setInitialisation(final Affectation intialisation) {
		this.initialisation = intialisation;
		this.initialisation.setIsInstruction(false);
	}

	/**
	 * Accède à l'itération de la boucle.
	 *
	 * @return l'expression effectué à chaque itération
	 */
	public Expression getIteration() {
		return iteration;
	}

	/**
	 * Modifie l'itération de la boucle.
	 *
	 * @param iteration la nouvelle expression d'itération
	 */
	public void setIteration(final InstructionIncrementation iteration) {
		iteration.setIsInstruction(false);
		this.iteration = iteration;
	}
	
	/**
	 * Modifie l'itération de la boucle.
	 *
	 * @param iteration la nouvelle expression d'itération
	 */
	public void setIteration(final Affectation iteration) {
		iteration.setIsInstruction(false);
		this.iteration = iteration;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}
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
	 * La valeur d'itération.
	 */
	private InstructionIncrementation iteration;

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
		this.iteration = iteration;
		if(initialisation != null) {
			this.initialisation.setIsInstruction(false);
		}
		if(iteration != null) {
			this.iteration.setIsInstruction(false);
		}
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
		if(initialisation != null)
			this.initialisation.setIsInstruction(false);
	}

	/**
	 * Accède à l'itération de la boucle.
	 *
	 * @return l'affectation effectuant l'itération
	 */
	public InstructionIncrementation getIteration() {
		return iteration;
	}

	/**
	 * Modifie l'itération de la boucle.
	 *
	 * @param iteration la nouvelle itération
	 */
	public void setIteration(final InstructionIncrementation iteration) {
		this.iteration = iteration;
		if(iteration != null)
			this.iteration.setIsInstruction(false);
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}
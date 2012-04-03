package instruction;

import traduction.VisiteurTraduction;
/**
 * Boucle d'une situation de départ jusqu'à
 * une condition avec un traitement à chaque tour de boucle.
 * @author Adrien DUROY, Bastien AUBRY
 */
public class InstructionFor extends InstructionConditionelle{

	private Affectation	intialization;
	private Affectation	iteration;
	
	/**
	 * Crée une boucle For non initialisée. Ses membres ont pour valeur null.
	 */
	public InstructionFor() {
		super();
	}
	
	/**
	 * Crée une boucle For.
	 * @param cond 
	 * @param initialization l'initialisation
	 * @param condition la condition d'arrêt
	 * @param iteration le traitement de fin de tour de boucle
	 */
	public InstructionFor(Affectation initialization,
			Condition condition, Affectation iteration) {
		super(condition);
		this.intialization = initialization;
		this.iteration = iteration;
		initialization.setIsInstruction(false);
		iteration.setIsInstruction(false);
	}
	
	/**
	 * Accède à la partie initialisation de la boucle.
	 * @return l'affectation d'initialisation.
	 */
	public Affectation getIntialization() {
		return intialization;
	}

	/**
	 * Modifie l'initialisation de la boucle.
	 * @param intialization la nouvelle affectation d'initialisation.
	 */
	public void setIntialization(Affectation intialization) {
		this.intialization = intialization;
	}

	/**
	 * Accède à l'itération de la boucle.
	 * @return l'affectation effectuant l'iteration.
	 */
	public Affectation getIteration() {
		return iteration;
	}

	/**
	 * Modifie l'itération de la boucle.
	 * @param iteration la nouvelle itération.
	 */
	public void setIteration(Affectation iteration) {
		this.iteration = iteration;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}

package instruction;

import traduction.VisiteurTraduction;

public class InstructionFor extends InstructionConditionelle{


	private Affectation	intialization;
	private Affectation	iteration;
	
	public InstructionFor() {
		super();
	}
	
	
	public InstructionFor(Condition cond, Affectation initialization,
			Condition condition, Affectation iteration) {
		super(cond);
		this.intialization = initialization;
		setCondition(condition);
		this.iteration = iteration;
		initialization.setIsInstruction(false);
		iteration.setIsInstruction(false);
	}
	
	public Affectation getIntialization() {
		return intialization;
	}

	public void setIntialization(Affectation intialization) {
		this.intialization = intialization;
	}

	public Affectation getIteration() {
		return iteration;
	}

	public void setIteration(Affectation iteration) {
		this.iteration = iteration;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
}

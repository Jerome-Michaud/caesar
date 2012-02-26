package instruction;

public abstract class VisiteurTraduction {

	private String traduction;
	private int nivIndent;
		
	public String getTraduction() {
		return traduction;
	}

	public void reset(){
		traduction = "";
	}

	public abstract void visiter(InstructionIf inst);

	public abstract void visiter(InstructionIfElse inst);

	public abstract void visiter(InstructionWhile inst);

	public abstract void visiter(InstructionDoWhile inst);

	public abstract void visiter(InstructionTache inst);

	public abstract void visiter(InstrcutionHeureActuelle inst);

	public abstract void visiter(InstructionAttente inst);
	
	public abstract void visiter(InstructionMoteurMov inst);
	
	public abstract void visiter(InstructionMoteurOff inst);
}

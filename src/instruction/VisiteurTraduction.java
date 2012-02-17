package instruction;

public abstract class VisiteurTraduction {

	private String traduction;
	private int nivIndent;
	
	public void nextIndent(){
		nivIndent++;
	}
	
	public void prevIndent(){
		nivIndent--;		
	}

	public abstract void visiter(InstructionIf inst);

	public abstract void visiter(InstructionIfElse inst);

	public abstract void visiter(InstructionWhile inst);

	public abstract void visiter(InstructionDoWhile inst);

	public abstract void visiter(InstructionTache inst);

	public abstract void visiter(InstrcutionHeureActuelle inst);

	public abstract void visiter(InstructionAttente inst);

}

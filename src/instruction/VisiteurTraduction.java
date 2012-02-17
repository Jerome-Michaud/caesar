package instruction;

public abstract class VisiteurTraduction {

	private String traduction;
	private int nivIndent;
	
	public void nextIndent(){
		// TODO nextIndent
	}
	
	public void prevIndent(){
		// TODO prevIndent		
	}

	public void visiter(InstructionIf inst) {
		// TODO Auto-generated method stub
	}

	public void visiter(InstructionIfElse inst) {
		// TODO Auto-generated method stub
	}

	public void visiter(InstructionWhile inst) {
		// TODO Auto-generated method stub
	}

	public void visiter(InstructionDoWhile inst) {
		// TODO Auto-generated method stub
	}

	public void visiter(InstructionTache inst) {
		// TODO Auto-generated method stub
	}

	public void visiter(InstrcutionHeureActuelle inst) {
		// TODO Auto-generated method stub
	}

	public void visiter(InstructionAttente inst) {
		// TODO Auto-generated method stub
	}

}

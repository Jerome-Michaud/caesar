package traduction;



import instruction.InstructionAttente;
import instruction.InstructionDoWhile;
import instruction.InstructionFor;
import instruction.InstructionIf;
import instruction.InstructionIfElse;
import instruction.InstructionMoteurMov;
import instruction.InstructionMoteurOff;
import instruction.InstructionRepeat;
import instruction.InstructionTache;
import instruction.InstructionTempsCourant;
import instruction.InstructionWhile;

public abstract class VisiteurTraduction {

	private String traduction;
	private int nivIndent;
		
	public String getTraduction() {
		return traduction;
	}

	public void reset(){
		traduction = "";
	}

	public abstract void visiter(InstructionIf instructionIf);

	public abstract void visiter(InstructionIfElse inst);

	public abstract void visiter(InstructionWhile inst);

	public abstract void visiter(InstructionDoWhile inst);

	public abstract void visiter(InstructionTache inst);

	public abstract void visiter(InstructionTempsCourant inst);

	public abstract void visiter(InstructionAttente inst);
	
	public abstract void visiter(InstructionMoteurMov inst);
	
	public abstract void visiter(InstructionMoteurOff inst);

	public abstract void visiter(InstructionFor instructionFor);

	public abstract void visiter(InstructionRepeat instructionRepeat) ;

	
	

}

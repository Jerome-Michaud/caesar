package traduction;


import instruction.Affectation;
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
import instruction.Operation;
import instruction.Variable;
import instruction.VariableModifiable;

public class VisiteurNXC extends VisiteurTraduction {

	@Override
	public void visiter(InstructionIf inst) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visiter(InstructionIfElse inst) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visiter(InstructionWhile inst) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visiter(InstructionDoWhile inst) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visiter(InstructionTache inst) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visiter(InstructionAttente inst) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visiter(InstructionMoteurOff inst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visiter(InstructionFor instructionFor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visiter(InstructionTempsCourant inst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visiter(InstructionRepeat instructionRepeat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visiter(Affectation affectation) {
		affectation.getMembreGauche().accepte(this);
		super.traduction += " = ";
		affectation.getMembreDroit().accepte(this);
	}

	@Override
	public void visiter(Operation operation) {
		
	}

	@Override
	public void visiter(Variable variable) {
		traduction += variable.toString();
	}

}

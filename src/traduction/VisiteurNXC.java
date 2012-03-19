package traduction;


import instruction.Affectation;
import instruction.Condition;
import instruction.ExpressionComplexe;
import instruction.Instruction;
import instruction.InstructionAttente;
import instruction.InstructionDoWhile;
import instruction.InstructionFor;
import instruction.InstructionIf;
import instruction.InstructionIfElse;
import instruction.InstructionMoteurMov;
import instruction.InstructionMoteurOff;
import instruction.InstructionRepeat;
import instruction.InstructionStructure;
import instruction.InstructionTache;
import instruction.InstructionTempsCourant;
import instruction.InstructionWhile;
import instruction.Operation;
import instruction.Variable;

public class VisiteurNXC extends VisiteurTraduction {

	@Override
	public void visiter(InstructionIf inst) {
		traduction+=indent();
		
		traduction+="if(";
		inst.getCondition().accepte(this);
		traduction+="){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
			traduction+=";\n";
		}
		
		nivIndent--;
		
		traduction+=indent()+"}\n";
	}

	@Override
	public void visiter(InstructionIfElse inst) {
		inst.getMembreIf().accepte(this);
		
		
		// Else
		
		traduction+=indent();
		traduction+="else{\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
			traduction+=";\n";
		}
		
		nivIndent--;
		
		traduction+=indent()+"}\n";
		
		
		

	

	}

	@Override
	public void visiter(InstructionWhile inst) {
		traduction+=indent();
		
		traduction+="while(";
		inst.getCondition().accepte(this);
		traduction+="){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
			traduction+=";\n";
		}
		
		nivIndent--;
		
		traduction+=indent()+"}\n";

	}

	@Override
	public void visiter(InstructionDoWhile inst) {
		traduction+=indent();
		
		traduction+="do{\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
			traduction+=";\n";
		}
		
		nivIndent--;
		
		traduction+=indent()+"} while(";
		inst.getCondition().accepte(this);
		traduction+=");\n";

	}

	@Override
	public void visiter(InstructionTache inst) {
		traduction+=indent()+"task "+inst.getNom()+"(){\n";
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
			traduction+=";\n";
		}
		nivIndent--;
		traduction+=indent()+"}";
		
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
		super.traduction += indent();
		affectation.getMembreGauche().accepte(this);
		super.traduction += " = ";
		affectation.getMembreDroit().accepte(this);
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		super.traduction += "(";
		expr.getMembreGauche().accepte(this);
		super.traduction += " "+expr.getOperateur()+" ";
		expr.getMembreDroit().accepte(this);
		super.traduction += ")";
	}

	@Override
	public void visiter(Variable variable) {
		traduction += variable.toString();
	}

}

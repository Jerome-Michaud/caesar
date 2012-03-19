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

/**
 * @author m1022
 *
 */


public class VisiteurNXC extends VisiteurTraduction {

	
	private void ajouterPointVirgule(Instruction is){
		if (!(is instanceof InstructionStructure))
			traduction+=";";
	}
	
	@Override
	public void visiter(InstructionIf inst) {
		traduction+=indent();
		traduction+="if(";
		inst.getCondition().accepte(this);
		traduction+="){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
			ajouterPointVirgule(is);
			traduction+="\n";
		}
		nivIndent--;
		
		traduction+=indent()+"}";
	}

	@Override
	public void visiter(InstructionIfElse inst) {
	}

	@Override
	public void visiter(InstructionWhile inst) {
	}

	@Override
	public void visiter(InstructionDoWhile inst) {
	}
	
	@Override
	public void visiter(InstructionFor instructionFor) {
	}

	@Override
	public void visiter(InstructionTache inst) {
		
		traduction+=indent()+"task "+inst.getNom()+"(){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
			ajouterPointVirgule(is);
			traduction+="\n";
		}
		nivIndent--;
		
		traduction+=indent()+"}";
		
	}

	
	/*
	 * 	
	 * 	OnFwd(OUT_A, 75);
		OnFwd(OUT_C, 75);
		Wait(4000);
		OnRev(OUT_AC, 75);
		Wait(4000);
		Off(OUT_AC);
	 */
	@Override
	public void visiter(InstructionAttente inst) {
		traduction += indent();
		//TODO visiter InstructionAttente
	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		traduction += indent();
		
		if (inst.isReverse())
			traduction += "OnRev("+inst.getMoteur();
		else
			traduction += "OnFwd("+inst.getMoteur();
		
		traduction += ", ";
		inst.getExpression().accepte(this);
		traduction += ");";
	}

	@Override
	public void visiter(InstructionMoteurOff inst) {
		traduction += indent();
		traduction += "Off("+inst.getMoteur()+");";
	}

	@Override
	public void visiter(InstructionTempsCourant inst) {
		traduction += indent();
		//TODO visiter InstructionTempsCourant
	}

	@Override
	public void visiter(InstructionRepeat instructionRepeat) {
		traduction += indent();
		//TODO visiter InstructionRepeat
	}

	@Override
	public void visiter(Affectation affectation) {
		traduction += indent();
		affectation.getMembreGauche().accepte(this);
		traduction += " = ";
		affectation.getMembreDroit().accepte(this);
		if(affectation.isInstruction())
			super.traduction += ";";
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		traduction += "(";
		expr.getMembreGauche().accepte(this);
		traduction += " "+expr.getOperateur()+" ";
		expr.getMembreDroit().accepte(this);
		traduction += ")";
	}

	@Override
	public void visiter(Variable variable) {
		traduction += variable.toString();
	}

}

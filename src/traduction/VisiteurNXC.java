package traduction;


import instruction.Affectation;
import instruction.Condition;
import instruction.ExpressionComplexe;
import instruction.Instruction;
import instruction.InstructionAttente;
import instruction.InstructionDeclaration;
import instruction.InstructionDeclarationAffectation;
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
import instruction.Moteur;
import instruction.Operation;
import instruction.Variable;

/**
 * @author m1022
 *
 */


public class VisiteurNXC extends VisiteurTraduction {
	
	private static VisiteurNXC instance;
	
	private VisiteurNXC(){};
	
	public static VisiteurNXC getInstance(){
		if (instance==null){
			instance = new VisiteurNXC();
		}
		return instance;
	}
	
	private void ajouterPointVirgule(Instruction is){
		if (!(is instanceof InstructionStructure))
			traduction+=";";
	}
	
	private void ajouterNomMoteur(Moteur m){
		switch (m){
		case A:
			traduction += "OUTA";
			break;
		case B:
			traduction += "OUTB";
			break;
		case C:
			traduction += "OUTC";
			break;
		case D:
			traduction += "OUTD";
			break;
		}
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
			
		}
		
		nivIndent--;
		
		traduction+=indent()+"} while(";
		inst.getCondition().accepte(this);
		traduction+=");\n";

	}
	
	@Override
	public void visiter(InstructionFor inst) {
		
		traduction+=indent()+"for (";
		inst.getIntialization().accepte(this);
		traduction+="; ";
		inst.getCondition().accepte(this);
		traduction+="; ";
		inst.getIteration().accepte(this);
		traduction+=" ){\n";
			
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
		}
		nivIndent--;
		
		traduction+=indent()+"}\n";
		
	}

	@Override
	public void visiter(InstructionTache inst) {
		
		traduction+=indent()+"task "+inst.getNom()+"(){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
		}
		nivIndent--;
		
		traduction+=indent()+"}";
		
	}

	@Override
	public void visiter(InstructionAttente inst) {
		traduction += indent();
		traduction += "Wait(";
		inst.getExpression().accepte(this);
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		traduction += indent();
		
		if (inst.isReverse())
			traduction += "OnRev(";
		else
			traduction += "OnFwd(";
		
		ajouterNomMoteur(inst.getMoteur());
		
		traduction += ", ";
		inst.getExpression().accepte(this);
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionMoteurOff inst) {
		traduction += indent();
		traduction += "Off(";
		
		ajouterNomMoteur(inst.getMoteur());
		
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionTempsCourant inst) {
		traduction += indent();
		traduction += "CurrentTick();\n";
		//TODO CurrentTick(s)?
	}

	@Override
	public void visiter(InstructionRepeat inst) {
		traduction += indent();
		
		traduction += "repeat(";
		inst.getExpression().accepte(this);
		traduction += "){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
		}
		nivIndent--;
		
		traduction+=indent()+"}\n";
	}

	@Override
	public void visiter(Affectation affectation) {
		if(affectation.isInstruction())	
			traduction += indent();
		affectation.getMembreGauche().accepte(this);
		traduction += " = ";
		affectation.getMembreDroit().accepte(this);
		if(affectation.isInstruction())
			super.traduction += ";\n";
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

	@Override
	public void visiter(InstructionDeclaration instructionDeclaration) {
		traduction += indent();
		traduction += instructionDeclaration.getMembreGauche().getType()+" ";
		instructionDeclaration.getMembreGauche().accepte(this);
		
		traduction += ";\n";
		
	}

	@Override
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation) {
		traduction += indent();
		traduction += instructionDeclarationAffectation.getMembreGauche().getType()+" ";
		instructionDeclarationAffectation.getMembreGauche().accepte(this);
		traduction += " = ";
		instructionDeclarationAffectation.getMembreDroit().accepte(this);
		traduction += ";\n";
	
	}

}

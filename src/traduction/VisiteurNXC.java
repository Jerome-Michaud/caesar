package traduction;

import instruction.Affectation;
import instruction.Expression;
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
import instruction.InstructionTache;
import instruction.InstructionTempsCourant;
import instruction.InstructionWhile;
import instruction.Moteur;
import instruction.Variable;
import instruction.VariableModifiable;

/**
 * Traducteur d'instructions dans le langage NXC.
 * Cette classe implémente le design pattern Singleton.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class VisiteurNXC extends VisiteurTraduction {
	
	private static VisiteurNXC instance;
	
	private VisiteurNXC(){};
	
	/**
	 * Donne l'instance unique de VisiteurNXC.
	 * @return l'instance de VisiteurNXC
	 */
	public synchronized static VisiteurNXC getInstance(){
		if (instance==null){
			instance = new VisiteurNXC();
		}
		return instance;
	}
	
	private void ajouterNomMoteur(Moteur m){
		switch (m){
		case A:
			traduction += "OUT_A";
			break;
		case B:
			traduction += "OUT_B";
			break;
		case C:
			traduction += "OUT_C";
			break;
		case D:
			traduction += "OUT_D";
			break;
		}
	}
	
	@Override
	public void visiter(InstructionIf inst) {
		traduction+=indent();
		traduction+="if(";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
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
		InstructionIf membre = inst.getMembreIf();
		if(membre != null)
			membre.accepte(this);
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
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
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
		for (Instruction is:inst.getEnfants()) {
			is.accepte(this);		
		}
		
		nivIndent--;
		
		traduction+=indent()+"} while(";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction+=");\n";
	}
	
	@Override
	public void visiter(InstructionFor inst) {		
		traduction+=indent()+"for (";
		Affectation affec = inst.getIntialization();
		affec.accepte(this);
		traduction+="; ";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction+="; ";
		affec = inst.getIteration();
		if(affec != null)
			affec.accepte(this);
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
		Expression ex = inst.getExpression();
		if(ex != null)
			ex.accepte(this);
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
		Expression ex = inst.getExpression();
		if(ex != null)
			ex.accepte(this);
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
		Expression ex = inst.getExpression();
		if(ex != null)
			ex.accepte(this);
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
		Expression membre = affectation.getMembreGauche();
		if(membre != null)
			membre.accepte(this);
		traduction += " = ";
		membre = affectation.getMembreDroit();
		if(membre != null)
			membre.accepte(this);
		if(affectation.isInstruction())
			super.traduction += ";\n";
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		traduction += "(";
		Expression membre = expr.getMembreGauche();
		if(membre != null)
			membre.accepte(this);
		traduction += " "+expr.getOperateur()+" ";
		membre = expr.getMembreDroit();
		if(membre != null)
			membre.accepte(this);
		traduction += ")";
	}

	@Override
	public void visiter(Variable variable) {
		traduction += variable.toString();
	}

	@Override
	public void visiter(InstructionDeclaration instructionDeclaration) {
		traduction += indent();
		VariableModifiable var = instructionDeclaration.getMembreGauche();
		if(var != null)
		{
			traduction += var.getType()+" ";
			var.accepte(this);
		}
		traduction += ";\n";		
	}

	@Override
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation) {
		traduction += indent();
		VariableModifiable var = instructionDeclarationAffectation.getMembreGauche();
		if(var != null)
		{
			traduction += var.getType()+" ";
			var.accepte(this);
		}
		traduction += " = ";
		Expression ex = instructionDeclarationAffectation.getMembreDroit();
		if(ex != null)
			ex.accepte(this);
		traduction += ";\n";	
	}
}

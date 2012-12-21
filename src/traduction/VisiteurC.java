package traduction;

import instruction.Affectation;
import instruction.Expression;
import instruction.ExpressionComplexe;
import instruction.Instruction;
import instruction.InstructionAttente;
import instruction.InstructionDeclaration;
import instruction.InstructionDeclarationAffectation;
import instruction.InstructionDeclarationCapteur;
import instruction.InstructionDoWhile;
import instruction.InstructionFor;
import instruction.InstructionIf;
import instruction.InstructionIfElse;
import instruction.InstructionMoteurMov;
import instruction.InstructionMoteurOff;
import instruction.InstructionMoteurRotate;
import instruction.InstructionRepeat;
import instruction.InstructionTache;
import instruction.InstructionTempsCourant;
import instruction.InstructionWhile;
import instruction.Variable;
import instruction.VariableCapteur;

public class VisiteurC extends VisiteurTraduction {

	@Override
	public void visiter(InstructionDeclaration instructionDeclaration) {
		traduction += indent();
		Variable var = instructionDeclaration.getMembre();
		if(var != null)
		{
			traduction += var.getType() + " ";
			var.accepte(this);
		}
		traduction += ";\n";
	}

	@Override
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation) {
		traduction += indent();
		Variable var = instructionDeclarationAffectation.getMembre();
		if(var != null)
		{
			traduction += var.getType() + " ";
			var.accepte(this);
		}
		traduction += " = ";
		Expression ex = instructionDeclarationAffectation.getMembreDroit();
		if(ex != null)
			ex.accepte(this);
		traduction += ";\n";
	}

	@Override
	public void visiter(InstructionIf instructionIf) {
		traduction += indent();
		traduction += "if(";
		ExpressionComplexe cond = instructionIf.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction += ") {\n";
		
		nivIndent++;
		for (Instruction is : instructionIf.getEnfants())
			is.accepte(this);
		nivIndent--;
		
		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionIfElse inst) {
		// If
		InstructionIf membre = inst.getMembreIf();
		if(membre != null)
			membre.accepte(this);
		// Else
		traduction += indent();
		traduction += "else {\n";
		
		nivIndent++;
		for(Instruction is : inst.getEnfantsElse())
			is.accepte(this);
		nivIndent--;
		
		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionWhile inst) {
		traduction += indent();
		
		traduction += "while(";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction += "){\n";
		
		nivIndent++;
		for(Instruction is : inst.getEnfants())
			is.accepte(this);		
		nivIndent--;
		
		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionDoWhile inst) {
		traduction += indent();
		
		traduction += "do {\n";
		
		nivIndent++;
		for(Instruction ins : inst.getEnfants())
			ins.accepte(this);
		nivIndent--;
		
		traduction += indent() + "} while(";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionTache inst) {
		traduction += "/* Code C pour Tache inconnu ! */\n" + indent() + "{\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants())
			is.accepte(this);
		nivIndent--;
		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionTempsCourant inst) {
		traduction += indent();
        if(inst.getVariable() != null) {
            inst.getVariable().accepte(this);
            traduction += " = ";
        }
        traduction += "clock();\n";
	}

	@Override
	public void visiter(InstructionAttente inst) {
		traduction += indent() + "/* Code C pour l'attente inconnu ! */\n";
	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		traduction += indent() + "/* Code C pour faire avancer un moteur inconnu ! */\n";
	}

	@Override
	public void visiter(InstructionMoteurOff inst) {
		traduction += indent() + "/* Code C pour faire reculer un moteur inconnu ! */\n";
	}

	@Override
	public void visiter(InstructionFor instructionFor) {
		traduction += indent();
		traduction += "for(";
		Instruction ini = instructionFor.getInitialisation();
		if(ini != null)
			ini.accepte(this);
		traduction += "; ";
		ExpressionComplexe cond = instructionFor.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction += "; ";
		Instruction iter = instructionFor.getIteration();
		if(iter != null)
			iter.accepte(this);
		traduction += ") {\n";
		
		nivIndent++;
		for(Instruction inst : instructionFor.getEnfants())
			inst.accepte(this);
		nivIndent--;
		
		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionRepeat instructionRepeat) {
		traduction += indent() + "int nb_rep;\n";
		traduction += indent() + "for(nb_rep = 0; nb_rep < ";
		Expression exp = instructionRepeat.getExpression();
		if(exp != null)
			exp.accepte(this);
		traduction += "; nb_rep++) {\n";
		
		nivIndent++;
		for(Instruction inst : instructionRepeat.getEnfants())
			inst.accepte(this);
		nivIndent--;
		
		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(Variable variable) {
		if(variable.isConstante())
			traduction += variable.getValeur();
		else
			traduction += variable.getNom();
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
		traduction += " " + expr.getOperateur() + " ";
		membre = expr.getMembreDroit();
		if(membre != null)
			membre.accepte(this);
		traduction += ")";
	}

	@Override
	public void visiter(InstructionDeclarationCapteur instructionDeclarationCapteur) {
		traduction += indent() + "/* Code C pour déclarer un capteur inconnu ! */\n";
	}

	@Override
	public void visiter(VariableCapteur variableCapteur) {
		traduction += indent() + "/* Code C pour une variable de capteur inconnu ! */\n";
	}

	@Override
	public void visiter(InstructionMoteurRotate instructionMoteurRotate) {
		traduction += indent() + "/* Code C pour rotation d'un moteur inconnu ! */\n";
	}

}

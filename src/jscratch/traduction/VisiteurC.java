package jscratch.traduction;

import nxtim.instruction.Affectation;
import nxtim.instruction.Expression;
import nxtim.instruction.ExpressionComplexe;
import nxtim.instruction.Instruction;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.InstructionConfigCapteurs;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.InstructionDeclarationAffectation;
import nxtim.instruction.InstructionDeclarationCapteur;
import nxtim.instruction.InstructionDoWhile;
import nxtim.instruction.InstructionFor;
import nxtim.instruction.InstructionIf;
import nxtim.instruction.InstructionIfElse;
import nxtim.instruction.InstructionIncrementation;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.InstructionMoteurRotate;
import nxtim.instruction.InstructionRAZRotationMoteur;
import nxtim.instruction.InstructionRepeat;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.InstructionWhile;
import nxtim.instruction.Operateur;
import nxtim.instruction.RotationMoteur;
import nxtim.instruction.TempsCourant;
import nxtim.instruction.ValeurCapteur;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableCapteur;

public class VisiteurC extends VisiteurTraduction {

	@Override
	public void visiter(InstructionDeclaration instructionDeclaration) {
		traduction += indent();
		Variable var = instructionDeclaration.getMembre();
		if (var != null) {
			traduction += var.getType() + " ";
			var.accepte(this);
		}
		traduction += ";\n";
	}

	@Override
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation) {
		traduction += indent();
		Variable var = instructionDeclarationAffectation.getMembre();
		if (var != null) {
			traduction += var.getType() + " ";
			var.accepte(this);
		}
		traduction += " = ";
		Expression ex = instructionDeclarationAffectation.getMembreDroit();
		if (ex != null) {
			ex.accepte(this);
		}
		traduction += ";\n";
	}

	@Override
	public void visiter(InstructionIf instructionIf) {
		traduction += indent();
		traduction += "if(";
		ExpressionComplexe cond = instructionIf.getCondition();
		if (cond != null) {
			cond.accepte(this);
		}
		traduction += ") {\n";

		nivIndent++;
		for (Instruction is : instructionIf.getEnfants()) {
			is.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionIfElse inst) {
		// If
		InstructionIf membre = inst.getMembreIf();
		if (membre != null) {
			membre.accepte(this);
		}
		// Else
		traduction += indent();
		traduction += "else {\n";

		nivIndent++;
		for (Instruction is : inst.getEnfantsElse()) {
			is.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionWhile inst) {
		traduction += indent();

		traduction += "while(";
		ExpressionComplexe cond = inst.getCondition();
		if (cond != null) {
			cond.accepte(this);
		}
		traduction += "){\n";

		nivIndent++;
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionDoWhile inst) {
		traduction += indent();

		traduction += "do {\n";

		nivIndent++;
		for (Instruction ins : inst.getEnfants()) {
			ins.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "} while(";
		ExpressionComplexe cond = inst.getCondition();
		if (cond != null) {
			cond.accepte(this);
		}
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionTache inst) {
		traduction += "/* Code C pour Tache inconnu ! */\n" + indent() + "{\n";

		nivIndent++;
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		nivIndent--;
		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(TempsCourant exp) {
		traduction += "clock()";
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
		if (ini != null) {
			ini.accepte(this);
		}
		traduction += "; ";
		ExpressionComplexe cond = instructionFor.getCondition();
		if (cond != null) {
			cond.accepte(this);
		}
		traduction += "; ";
		Instruction iter = instructionFor.getIteration();
		if (iter != null) {
			iter.accepte(this);
		}
		traduction += ") {\n";

		nivIndent++;
		for (Instruction inst : instructionFor.getEnfants()) {
			inst.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionRepeat instructionRepeat) {
		traduction += indent() + "int nb_rep;\n";
		traduction += indent() + "for(nb_rep = 0; nb_rep < ";
		Expression exp = instructionRepeat.getExpression();
		if (exp != null) {
			exp.accepte(this);
		}
		traduction += "; nb_rep++) {\n";

		nivIndent++;
		for (Instruction inst : instructionRepeat.getEnfants()) {
			inst.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(Variable variable) {
		if (variable.isConstante()) {
			traduction += variable.getValeur();
		} else {
			traduction += variable.getNom();
		}
	}

	@Override
	public void visiter(Affectation affectation) {
		if (affectation.isInstruction()) {
			traduction += indent();
		}
		Expression membre = affectation.getMembreGauche();
		if (membre != null) {
			membre.accepte(this);
		}
		traduction += " = ";
		membre = affectation.getMembreDroit();
		if (membre != null) {
			membre.accepte(this);
		}
		if (affectation.isInstruction()) {
			super.traduction += ";\n";
		}
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		traduction += "(";
		Expression membre = expr.getMembreGauche();
		if (membre != null) {
			membre.accepte(this);
		}
		traduction += " " + expr.getOperateur() + " ";
		membre = expr.getMembreDroit();
		if (membre != null) {
			membre.accepte(this);
		}
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

	@Override
	public void visiter(InstructionIncrementation instructionIncrementation) {
		String op = "++";
		if (instructionIncrementation.getOperateur() == Operateur.INCREMENTATION_MOINS) {
			op = "--";
		}
		
		if (instructionIncrementation.isAvant()) {
			traduction += op;
		}
		if (instructionIncrementation.getVariable() != null) {
			instructionIncrementation.getVariable().accepte(this);
		}
		if (!instructionIncrementation.isAvant()) {
			traduction += op;
		}
		if(instructionIncrementation.isInstruction()) {
			traduction += ";\n";
		}
	}

	@Override
	public void visiter(ValeurCapteur valCapteur) {
		traduction += "/* Code C pour obtenir la valeur d'un capteur inconnu ! */\n";
	}

	@Override
	public void visiter(RotationMoteur rotMoteur) {
		traduction += "/* Code C pour obtenir le nombre de rotations d'un moteur inconnu ! */\n";
	}

	@Override
	public void visiter(InstructionRAZRotationMoteur razMoteur) {
		traduction += "/* Code C pour RAZ du nombre de rotations d'un moteur inconnu ! */\n";
	}

	@Override
	public void visiter(InstructionConfigCapteurs confCapt) {
		traduction += indent() + "/* Code C pour la configuration des capteurs inconnu ! */\n";
	}
}

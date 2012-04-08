package traduction;

import instruction.Affectation;
import instruction.CapteurSlot;
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
import instruction.Moteur;
import instruction.Variable;
import instruction.VariableCapteur;

/**
 * Traducteur d'instructions dans le langage RobotC. Cette classe implémente le
 * design pattern Singleton.
 *
 * @author Ivan MELNYCHENKO, Adrien DUROY
 */
public class VisiteurRobotC extends VisiteurTraduction {

	private static VisiteurRobotC instance;

	private VisiteurRobotC() {
		super();
	}
	
	public synchronized static VisiteurRobotC getInstance() {
		if (instance == null) {
			instance = new VisiteurRobotC();
		}
		return instance;
	}

	private void ajouterNomMoteur(Moteur m) {
		switch (m) {
			case A:
				traduction += "motorA";
				break;
			case B:
				traduction += "motorB";
				break;
			case C:
				traduction += "motorC";
				break;
		}
	}
	

	private String getNomCapteur(CapteurSlot c) {
		switch (c) {
			case A:
				return "S1";
			case B:
				return "S2";
			case C:
				return "S3";
			default:
				return null;
		}
	}

	@Override
	public void visiter(InstructionIf inst) {
		traduction += indent();
		traduction += "if(";
		inst.getCondition().accepte(this);
		traduction += "){\n";

		nivIndent++;
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionIfElse inst) {

		inst.getMembreIf().accepte(this);


		// Else

		traduction += indent();
		traduction += "else{\n";

		nivIndent++;
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);

		}

		nivIndent--;

		traduction += indent() + "}\n";

	}

	@Override
	public void visiter(InstructionWhile inst) {

		traduction += indent();

		traduction += "while(";
		inst.getCondition().accepte(this);
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

		traduction += "do{\n";

		nivIndent++;
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);

		}

		nivIndent--;

		traduction += indent() + "} while(";
		inst.getCondition().accepte(this);
		traduction += ");\n";

	}

	@Override
	public void visiter(InstructionFor inst) {

		traduction += indent() + "for (";
		inst.getIntialization().accepte(this);
		traduction += "; ";
		inst.getCondition().accepte(this);
		traduction += "; ";
		inst.getIteration().accepte(this);
		traduction += " ){\n";

		nivIndent++;
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}\n";

	}

	@Override
	public void visiter(InstructionTache inst) {

		traduction += indent() + "task " + inst.getNom() + "(){\n";

		nivIndent++;
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}";

	}

	@Override
	public void visiter(InstructionAttente inst) {
		traduction += indent();
		traduction += "wait1Msec";
		inst.getExpression().accepte(this);
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		traduction += indent();

		traduction += "motor[";
		ajouterNomMoteur(inst.getMoteur());
		traduction += "]=";

		if (inst.isReverse()) {
			traduction += "-";
		}

		inst.getExpression().accepte(this);
		traduction += ";\n";
	}

	@Override
	public void visiter(InstructionMoteurOff inst) {
		traduction += indent();

		traduction += "motor[";
		ajouterNomMoteur(inst.getMoteur());
		traduction += "]=0";
		traduction += ";\n";
	}

	@Override
	public void visiter(InstructionTempsCourant inst) {
		traduction += indent();
		traduction += "CurrentTick();\n";
	}

	@Override
	public void visiter(InstructionRepeat inst) {
		traduction += indent() + "int variablePourFor";
		traduction += indent() + "for (";
		traduction += "variablePourFor = 0 ; ";
		traduction += "variablePourFor <" + inst.getExpression() + ";";
		traduction += "variablePourFor++";
		traduction += " ){\n";

		nivIndent++;
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		nivIndent--;

		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(Affectation affectation) {
		if (affectation.isInstruction()) {
			traduction += indent();
		}
		affectation.getMembreGauche().accepte(this);
		traduction += " = ";
		affectation.getMembreDroit().accepte(this);
		if (affectation.isInstruction()) {
			super.traduction += ";\n";
		}
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		traduction += "(";
		expr.getMembreGauche().accepte(this);
		traduction += " " + expr.getOperateur() + " ";
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
		traduction += instructionDeclaration.getMembreGauche().getType() + " ";
		instructionDeclaration.getMembreGauche().accepte(this);

		traduction += ";\n";

	}

	@Override
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation) {
		traduction += indent();
		traduction += instructionDeclarationAffectation.getMembreGauche().getType() + " ";
		instructionDeclarationAffectation.getMembreGauche().accepte(this);
		traduction += " = ";
		instructionDeclarationAffectation.getMembreDroit().accepte(this);
		traduction += ";\n";

	}

	@Override
	public void visiter(InstructionDeclarationCapteur instructionDeclarationCapteur) {
		String temp = "";
		temp += "const tSensors";
		switch (instructionDeclarationCapteur.getCapteur()) {
			case TOUCH:
				temp += "touchSensor";
		}
		temp += "= (tSensors)";
		temp += getNomCapteur(instructionDeclarationCapteur.getCapteurSlot());
		temp += ";\n";

		traduction = temp + "\n\n\n" + traduction;


	}

	@Override
	public void visiter(VariableCapteur variableCapteur) {
		traduction += "SensorValue((tSensors)";
		traduction += getNomCapteur(variableCapteur.getCapteurSlot());
		traduction += ")";



	}

	@Override
	public void visiter(InstructionMoteurRotate instructionMoteurRotate) {
		// TODO Auto-generated method stub
		
	}
}

package jscratch.traduction;

import nxtim.instruction.CapteurSlot;
import nxtim.instruction.ExpressionComplexe;
import nxtim.instruction.Instruction;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.InstructionDeclarationCapteur;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.InstructionMoteurRotate;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.TempsCourant;
import nxtim.instruction.Moteur;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableCapteur;

/**
 * Traducteur d'instructions dans le langage RobotC. Cette classe implémente le
 * design pattern Singleton.
 *
 * @author Ivan MELNYCHENKO, Adrien DUROY
 */
public class VisiteurRobotC extends VisiteurC {

	private static VisiteurRobotC instance;

	private VisiteurRobotC() {
		super();
	}

	public static synchronized VisiteurRobotC getInstance() {
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
	public void visiter(TempsCourant inst) {
		traduction += "CurrentTick()";
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

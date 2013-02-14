package jscratch.traduction;

import nxtim.instruction.CapteurSlot;
import nxtim.instruction.Expression;
import nxtim.instruction.Instruction;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.InstructionDeclarationCapteur;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.InstructionMoteurRotate;
import nxtim.instruction.InstructionRepeat;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.InstructionTempsCourant;
import nxtim.instruction.Moteur;
import nxtim.instruction.VariableCapteur;

/**
 * Traducteur d'instructions dans le langage NXC.
 * Cette classe implémente le design pattern Singleton.
 *
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class VisiteurNXC extends VisiteurC {

	private static VisiteurNXC instance;

	private VisiteurNXC() {
		super();
	}

	/**
	 * Donne l'instance unique de VisiteurNXC.
	 *
	 * @return l'instance de VisiteurNXC
	 */
	public static synchronized VisiteurNXC getInstance() {
		if (instance == null) {
			instance = new VisiteurNXC();
		}
		return instance;
	}

	private void ajouterNomMoteur(Moteur m) {
		if (m != null) {
			switch (m) {
				case A:
					traduction += "OUT_A";
					break;
				case B:
					traduction += "OUT_B";
					break;
				case C:
					traduction += "OUT_C";
					break;
				default:
					break;
			}
		}
	}

	private void ajouterNomCapteur(CapteurSlot c) {
		switch (c) {
			case A:
				traduction += "IN_1";
				break;
			case B:
				traduction += "IN_2";
				break;
			case C:
				traduction += "IN_3";
				break;
			case D:
				traduction += "IN_4";
				break;
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

		traduction += indent() + "}\n";
	}

	@Override
	public void visiter(InstructionAttente inst) {
		traduction += indent();
		traduction += "Wait(";
		Expression ex = inst.getExpression();
		if (ex != null) {
			ex.accepte(this);
		}
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		traduction += indent();

		if (inst.isReverse()) {
			traduction += "OnRev(";
		} else {
			traduction += "OnFwd(";
		}

		ajouterNomMoteur(inst.getMoteur());

		traduction += ", ";
		Expression ex = inst.getExpression();
		if (ex != null) {
			ex.accepte(this);
		}
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
		if (inst.getVariable() != null) {
			inst.getVariable().accepte(this);
			traduction += " = ";
		}
		traduction += "CurrentTick();\n";
	}

	@Override
	public void visiter(InstructionRepeat inst) {
		traduction += indent();

		traduction += "repeat(";
		Expression ex = inst.getExpression();
		if (ex != null) {
			ex.accepte(this);
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
	public void visiter(InstructionDeclarationCapteur instructionDeclarationCapteur) {
		traduction += indent();
		switch (instructionDeclarationCapteur.getCapteur()) {
			case TOUCH:
				traduction += "SetSensorTouch(";
				break;
			default:
				break;
		}
		ajouterNomCapteur(instructionDeclarationCapteur.getCapteurSlot());
		traduction += ");\n";
	}

	@Override
	public void visiter(VariableCapteur variableCapteur) {
		traduction += "Sensor(";
		ajouterNomCapteur(variableCapteur.getCapteurSlot());
		traduction += ")";
	}

	@Override
	public void visiter(InstructionMoteurRotate instructionMoteurRotate) {
		// TODO Auto-generated method stub
	}
}

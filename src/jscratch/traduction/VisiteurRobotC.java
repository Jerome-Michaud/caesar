/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
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

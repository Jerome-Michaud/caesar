package jscratch.interpreteur;

import jscratch.controleur.sim.RobotController;
import nxtim.instruction.Affectation;
import nxtim.instruction.Condition;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.InstructionFor;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.InstructionWhile;
import nxtim.instruction.Moteur;
import nxtim.instruction.Operateur;
import nxtim.instruction.Operation;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.VariableConstante;
import nxtim.instruction.VariableModifiable;

public class Interpreteur {

	private RobotController robot;
	
	public Interpreteur(RobotController robot) {
		this.robot = robot;
	}
	
	public void launchInterpreteur(){
		InstructionTache tache = new InstructionTache("Tache 1");
		InstructionDeclaration instD = new InstructionDeclaration();
		VariableModifiable varI = new VariableModifiable(TypeVariable.INT,"i", "");
		instD.setMembre(varI);
		
		tache.inserer(0,instD);
		
		Affectation aff = new Affectation(varI,new VariableConstante(TypeVariable.INT, "", "0") , true);
		tache.inserer(1, aff);
		
		tache.inserer(2, new InstructionMoteurMov(Moteur.C, new VariableConstante(TypeVariable.INT, "", "1")));
		tache.inserer(3, new InstructionAttente(new VariableConstante(TypeVariable.INT, "", "1")));
		tache.inserer(4, new InstructionMoteurMov(Moteur.C, new VariableConstante(TypeVariable.INT, "", "6")));
		tache.inserer(5, new InstructionMoteurOff(Moteur.C));
		
		VariableModifiable varA = new VariableModifiable(TypeVariable.INT, "a");
		
		InstructionFor instFor = new InstructionFor(new Affectation(varA,new VariableConstante(TypeVariable.INT,"0") , false),
													new Condition(Operateur.INFERIEUR,varA,new VariableConstante(TypeVariable.INT,"", "6")),
													//new Affectation(varA, new Operation(Operateur.ADDITION, varA, new VariableConstante(TypeVariable.INT, "1")), false));
													null);
		
		instFor.inserer(0, new InstructionMoteurMov(Moteur.B, new VariableConstante(TypeVariable.INT, "", "10")));
		
		InstructionWhile instWhile = new InstructionWhile(new Condition(Operateur.INFERIEUR, varI, new VariableConstante(TypeVariable.INT, "", "5")));
		instWhile.inserer(0, new InstructionMoteurMov(Moteur.C, new VariableConstante(TypeVariable.INT, "", "10")));
		instWhile.inserer(1, new InstructionAttente(new VariableConstante(TypeVariable.INT, "", "1")));
		instWhile.inserer(2, instFor);
		instWhile.inserer(3, new InstructionMoteurOff(Moteur.C));
		instWhile.inserer(4, new Affectation(varI, new Operation(Operateur.ADDITION, varI, new VariableConstante(TypeVariable.INT, "", "1")), true));
		tache.inserer(6, instWhile);
		
		tache.inserer(7, new InstructionMoteurOff(Moteur.C));
		tache.inserer(7, new InstructionMoteurOff(Moteur.B));
		
		VisiteurInterpreteur inter = VisiteurInterpreteur.getInstance(robot);
		tache.accepte(inter);
	}
}
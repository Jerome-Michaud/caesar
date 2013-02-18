package jscratch.interpreteur;

import java.util.LinkedList;
import java.util.List;

import jscratch.controleur.sim.RobotController;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.ModeleWidget;
import jscratch.vue.widgets.modeles.TypeModeleWidget;
import nxtim.instruction.Affectation;
import nxtim.instruction.Condition;
import nxtim.instruction.Instruction;
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

/**
 * Classe recuperant les taches des widget et les parcoure
 * @author Nicolas
 *
 */
public class Interpreteur {

	private RobotController robot;
	private boolean run = true;
	private boolean wait = false;
	private VisiteurInterpreteur visiteur;
	
	public Interpreteur(RobotController robot) {
		this.robot = robot;
		this.visiteur = VisiteurInterpreteur.getInstance(robot);
	}
	
	public void launchInterpreteur(){
		/*InstructionTache tache = new InstructionTache("Tache 1");
		InstructionDeclaration instD = new InstructionDeclaration();
		VariableModifiable varI = new VariableModifiable(TypeVariable.INT,"i", "");
		instD.setMembre(varI);
		
		tache.inserer(0,instD);
		
		Affectation aff = new Affectation(varI,new VariableConstante(TypeVariable.INT, "", "0") , true);
		tache.inserer(1, aff);
		
		tache.inserer(2, new InstructionMoteurMov(Moteur.B, new VariableConstante(TypeVariable.INT, "", "25")));
		tache.inserer(3, new InstructionAttente(new VariableConstante(TypeVariable.INT, "", "1")));
		tache.inserer(4, new InstructionMoteurMov(Moteur.C, new VariableConstante(TypeVariable.INT, "", "25")));
		tache.inserer(5, new InstructionMoteurOff(Moteur.C));
		tache.inserer(5, new InstructionMoteurOff(Moteur.B));
		
		VariableModifiable varA = new VariableModifiable(TypeVariable.INT, "a");
		
		InstructionFor instFor = new InstructionFor(new Affectation(varA,new VariableConstante(TypeVariable.INT,"0") , false),
													new Condition(Operateur.INFERIEUR,varA,new VariableConstante(TypeVariable.INT,"", "6")),
													//new Affectation(varA, new Operation(Operateur.ADDITION, varA, new VariableConstante(TypeVariable.INT, "1")), false));
													null);
		
		instFor.inserer(0, new InstructionMoteurMov(Moteur.B, new VariableConstante(TypeVariable.INT, "", "50")));
		
		InstructionWhile instWhile = new InstructionWhile(new Condition(Operateur.INFERIEUR, varI, new VariableConstante(TypeVariable.INT, "", "5")));
		instWhile.inserer(0, new InstructionMoteurMov(Moteur.C, new VariableConstante(TypeVariable.INT, "", "50")));
		instWhile.inserer(1, new InstructionAttente(new VariableConstante(TypeVariable.INT, "", "1")));
		instWhile.inserer(2, instFor);
		instWhile.inserer(3, new InstructionMoteurOff(Moteur.C));
		instWhile.inserer(4, new Affectation(varI, new Operation(Operateur.ADDITION, varI, new VariableConstante(TypeVariable.INT, "", "1")), true));
		tache.inserer(6, instWhile);
		
		tache.inserer(7, new InstructionMoteurOff(Moteur.C));
		tache.inserer(7, new InstructionMoteurOff(Moteur.B));*/
		
		while(run){
			if(wait){
				synchronized (this) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
				}
			}
			visiteur.setRun(true);
		//	tache.accepte(visiteur);
			for(Instruction l : trouveTaches()){
				l.accepte(visiteur);
			}
		}

	}
	
	public synchronized void setRun(boolean b){
		this.run = b;
	}
	
	public synchronized void setWait(boolean b){
		this.wait = b;
	}

	public VisiteurInterpreteur getVisiteur() {
		// TODO Stub de la méthode généré automatiquement
		return visiteur;
	}
	
	/**
	 * Trouve les tâches parmi les widgets.<br/>
	 * L'interpretation est effectuée à partir de celles-ci.
	 *
	 * @return les instructions à interpreter
	 */
	private List<Instruction> trouveTaches() {
		List<Instruction> list = new LinkedList<Instruction>();
		for (List<Widget> racine : ArborescenceTools.getInstance().getArborescence()) {
			if (!racine.isEmpty()) {
				Widget tache = racine.get(0);
				ModeleWidget m = tache.getModele();
				if (m.getType() == TypeModeleWidget.TACHE) {
					list.add((Instruction) m.getElementProgramme());
				}
			}
		}
		return list;
	}
	
	
}

package jscratch.interpreteur;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import jscratch.controleur.sim.ForwardCommand;
import jscratch.controleur.sim.RobotController;
import jscratch.controleur.sim.StopCommand;
import jscratch.modeles.sim.MotorPort;
import nxtim.instruction.Affectation;
import nxtim.instruction.Expression;
import nxtim.instruction.ExpressionComplexe;
import nxtim.instruction.Instruction;
import nxtim.instruction.InstructionAttente;
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
import nxtim.instruction.InstructionRepeat;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.TempsCourant;
import nxtim.instruction.InstructionWhile;
import nxtim.instruction.Moteur;
import nxtim.instruction.Operateur;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableCapteur;
import nxtim.instruction.VariableModifiable;
import nxtim.instruction.VisiteurElementProg;

/**
 * @since 1.0
 * @version 1.0
 */
public final class VisiteurInterpreteur implements VisiteurElementProg {

	private static VisiteurInterpreteur instance;
	
	/**
	 * Pile de double sauvegardant les valeurs des Instructions
	 */
	private Deque<Double> pile;
	
	private RobotController robot;
	private boolean wait = false;
	private boolean run = true;

	private VisiteurInterpreteur(RobotController robot) {
		this.pile = new ArrayDeque<Double>();
		this.robot = robot;
	}

	/**
	 *
	 * @return instance de VisiteurInterpreteur
	 */
	public synchronized static VisiteurInterpreteur getInstance(RobotController robot) {
		if (instance == null) {
			instance = new VisiteurInterpreteur(robot);
		}
		return instance;
	}

	@Override
	public void visiter(InstructionDeclaration inst) {
		try{
			if(run){
				this.testWait();
				// TODO Stub de la méthode généré automatiquement
				Variable var = inst.getMembre();
				if (var != null) {
					//TODO mettre la variable dans la table des variables
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(InstructionDeclarationAffectation inst) {
		try{
			if(run){
				this.testWait();
				Variable var = inst.getMembre();
				if (var != null) {
					//TODO mettre la variable dans la table des variables
					Expression exp = inst.getMembreDroit();
					if (exp != null) {
						exp.accepte(this);
						var.setValeur("" + pile.pop());
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(InstructionIf inst) {
		try{
			if(run){
				this.testWait();
				// TODO Enlevés les warning	
				ExpressionComplexe cond = inst.getCondition();
				if (cond != null) {
					cond.accepte(this);
					if (pile.pop() == 1) {
						for (Instruction is : inst.getEnfants()) {
							is.accepte(this);
						}
					}
				} else {
					System.out.println("WARNING : If sans condition ignoré");
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(InstructionIfElse inst) {
		try{
			if(run){
				this.testWait();
				// TODO Enlevés les warning	
				ExpressionComplexe cond = inst.getCondition();
				if (cond != null) {
					cond.accepte(this);
					if (pile.pop() == 1) {
						for (Instruction is : inst.getEnfantsIf()) {
							is.accepte(this);
						}
					} else {
						for (Instruction is : inst.getEnfantsElse()) {
							is.accepte(this);
						}
					}
				} else {
					System.out.println("WARNING : IfElse sans condition ignoré");
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	/**
	 * execute un While et effectue son contenu tant que la condition est respectée
	 *
	 */
	@Override
	public void visiter(InstructionWhile inst) {
		try{
			if(run){
				this.testWait();
				// TODO Enlevés les warning	
				ExpressionComplexe cond = inst.getCondition();
		
				if (cond != null) {
					cond.accepte(this);
					while (pile.pop() == 1) {
						for (Instruction is : inst.getEnfants()) {
							is.accepte(this);
						}
						cond.accepte(this);
					}
				} else {
					System.out.println("WARNING : While sans condition ignoré");
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(InstructionDoWhile inst) {
		try{
			if(run){
				this.testWait();
				// TODO Enlevés les warning
				ExpressionComplexe cond = inst.getCondition();
				if (cond != null) {
					do {
						for (Instruction is : inst.getEnfants()) {
							is.accepte(this);
						}
						cond.accepte(this);
					} while (pile.pop() == 1);
				} else {
					System.out.println("WARNING : DoWhile sans condition ignoré");
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(InstructionTache inst) {
		try{
			if(run){
				this.testWait();
				List<Instruction> list = inst.getEnfants();
				for (Instruction i : list) {
					i.accepte(this);
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(TempsCourant inst) { }

	@Override
	public void visiter(InstructionAttente inst) {
		try{
			if(run){
				this.testWait();
				// TODO Enlevés les warning
				Expression ex = inst.getExpression();
				if (ex != null) {
					ex.accepte(this);
				}
		
				Double d = pile.pop();
		
				System.out.println("Creation de la commande Attente : (" + d + ")");
				try {
					Thread.sleep((long) (d * 1000));
				} catch (InterruptedException e) {
					System.out.println("WARNING : interpreteur reveillé - sleep interrompu - Erreur temporelle possible");
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	/**
	 * envoie une commande avec l'ordre d'avancer
	 *
	 */
	@Override
	public void visiter(InstructionMoteurMov inst) {
		try{
			if(run){
				this.testWait();
				Expression ex = inst.getExpression();
				if (ex != null) {
					ex.accepte(this);
				}
		
				Moteur moteur = inst.getMoteur();
				double i = pile.pop();
				System.out.println("Creation de la commande Forward : (" + i + " , " + moteur.toString() + ")");
				robot.addCommand(new ForwardCommand(robot, (int) i, moteurToMotorPort(moteur)));
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	/**
	 * envoie une commande avec l'ordre d'arreter
	 *
	 */
	@Override
	public void visiter(InstructionMoteurOff inst) {
		try{
			if(run){
				this.testWait();
				Moteur moteur = inst.getMoteur();
				System.out.println("Creation de la commande Off : (" + moteur.toString() + ")");
				robot.addCommand(new StopCommand(robot, 0, moteurToMotorPort(moteur)));
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	/**
	 * execute un For
	 *
	 */
	@Override
	public void visiter(InstructionFor inst) {
		try{
			if(run){
				this.testWait();
				ExpressionComplexe cond = inst.getCondition();
				Affectation init = inst.getInitialisation();
				InstructionIncrementation iter = inst.getIteration();
				if (init != null) {
					if (cond != null) {
						if (iter != null) {
							init.accepte(this);
							cond.accepte(this);
							while (pile.pop() == 1) {
								for (Instruction is : inst.getEnfants()) {
									is.accepte(this);
								}
								iter.accepte(this);
								cond.accepte(this);
							}
						} else {
							System.out.println("WARNING : For sans iteration ignoré");
						}
					} else {
						System.out.println("WARNING : For sans condition ignoré");
					}
				} else {
					System.out.println("WARNING : For sans initialisation ignoré");
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	/**
	 * visite un Repeat et effectue un certain nombre de fois les memes taches
	 *
	 */
	@Override
	public void visiter(InstructionRepeat inst) {
		try{
			if(run){
				this.testWait();
				Expression exp = inst.getExpression();
				double cpt = 0;
				if (exp != null) {
					exp.accepte(this);
					cpt = pile.pop();
		
					for (int i = 0; i < cpt; i++) {
						for (Instruction is : inst.getEnfants()) {
							is.accepte(this);
						}
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	/**
	 * visite la variable et ajoute la valeur dans la pile
	 */
	@Override
	public void visiter(Variable var) {
		try{
			if(run){
				this.testWait();
				// TODO CHangé la sortie d'erreur
				if (!"".equals(var.getValeur())) {
					pile.push(Double.parseDouble(var.getValeur()));
				} else {
					pile.push((double) 0);
					System.out.println("WARNING : Variable vide");
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(Affectation affec) {
		try{
			if(run){
				this.testWait();
				Expression md = affec.getMembreDroit();
				VariableModifiable mg = (VariableModifiable) affec.getMembreGauche();
		
				double d = 0;
		
				if (md != null) {
					md.accepte(this);
					d = pile.pop();
				} else {
					//TODO Emettre une erreur
				}
				if (mg != null) {
					mg.setValeur("" + d);
					if (!affec.isInstruction()) {
						mg.accepte(this);
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		try{
			if(run){
				this.testWait();
				Operateur opt = expr.getOperateur();
				double d = 0;
				double g = 0;
				Expression mda = expr.getMembreDroit();
				Expression mdg = expr.getMembreGauche();
				
				if (mda != null) {
					mda.accepte(this);
					d = pile.pop();
		
				} else {
					//TODO Emettre une erreur
				}
		
				if (mdg != null) {
					mdg.accepte(this);
					g = pile.pop();
				} else {
					//TODO Emettre une erreur
				}
		
				switch (opt) {
					case ADDITION:
						pile.push(g + d);
						break;
					case SOUSTRACTION:
						pile.push(g - d);
						break;
					case MULTIPLICATION:
						pile.push(g * d);
						break;
					case DIVISION:
						pile.push(g / d);
						break;
					case SUPERIEUR:
						if (g > d) {
							pile.push((double) 1);
						} else {
							pile.push((double) 0);
						}
						break;
					case INFERIEUR:
						if (g < d) {
							pile.push((double) 1);
						} else {
							pile.push((double) 0);
						}
						break;
					case EGALITE:
						if (g == d) {
							pile.push((double) 1);
						} else {
							pile.push((double) 0);
						}
						break;
					case SUPEGAL:
						if (g >= d) {
							pile.push((double) 1);
						} else {
							pile.push((double) 0);
						}
						break;
					case INFEGAL:
						if (g <= d) {
							pile.push((double) 1);
						} else {
							pile.push((double) 0);
						}
						break;
					case ET:
						if (g == 0) {
							pile.push((double) 0);
						} else if (d == 0) {
							pile.push((double) 0);
						} else {
							pile.push((double) 1);
						}
						break;
					case OU:
						if (g == 1) {
							pile.push((double) 1);
						} else if (d == 1) {
							pile.push((double) 1);
						} else {
							pile.push((double) 0);
						}
						break;
					default:
						break;
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}

	@Override
	public void visiter(InstructionDeclarationCapteur arg0) { }

	@Override
	public void visiter(VariableCapteur arg0) { }

	@Override
	public void visiter(InstructionMoteurRotate arg0) { }

	private MotorPort moteurToMotorPort(Moteur moteur) {
		MotorPort motorPort = null;
		switch (moteur) {
			case A:
				motorPort = MotorPort.OUT_A;
				break;
			case B:
				motorPort = MotorPort.OUT_B;
				break;
			case C:
				motorPort = MotorPort.OUT_C;
				break;
			default:
				break;
		}
		return motorPort;
	}

	@Override
	public void visiter(InstructionIncrementation instructionIncrementation) { }
	
	private synchronized void testWait(){
		if(wait){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void setRun(boolean b){
		this.run = b;
	}
		
	public synchronized void setWait(boolean b){
		this.wait = b;
	}
}
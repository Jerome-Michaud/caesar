package traduction;

import instruction.Affectation;
import instruction.ExpressionComplexe;
import instruction.InstructionAttente;
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
import instruction.Operation;
import instruction.Variable;

public abstract class VisiteurTraduction {

	protected String traduction;
	protected int nivIndent;
	protected String indent;
	

	/**
	 * Donne la traduction.
	 * @return la traduction
	 */
	public String getTraduction() {
		return traduction;
	}

	/**
	 * Réinitialise la traduction.
	 */
	public void reset(){
		traduction = "";
		nivIndent = 0;
	}

	/**
	 * Donne l'indention du niveau d'indention courant
	 * @return la chaine correspondant à l'espace d'indention.
	 */
	protected String indent(){
		String indent = "";
		for (int i=0;i<nivIndent;i++){
			indent+="\t";
		}
		return indent;
	}
	
	/**
	 * Traduit une instruction if.
	 * @param instructionIf l'instruction à traduire
	 */
	public abstract void visiter(InstructionIf instructionIf);

	/**
	 * Traduit une instruction ifelse.
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionIfElse inst);

	/**
	 * Traduit une instruction while.
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionWhile inst);

	/**
	 * Traduit une instruction dowhile.
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionDoWhile inst);

	/**
	 * 
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionTache inst);

	/**
	 * Traduit une instruction obtenant le temps courant.
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionTempsCourant inst);

	/**
	 * Traduit une instruction d'attente.
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionAttente inst);
	
	/**
	 * Traduit une instruction de movement de moteur.
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionMoteurMov inst);
	
	/**
	 * Traduit une instruction d'arrêt de moteur.
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionMoteurOff inst);

	/**
	 * Traduit une instruction for.
	 * @param instructionFor l'instruction à traduire
	 */
	public abstract void visiter(InstructionFor instructionFor);

	/**
	 * Traduit une instruction de répétition.
	 * @param instructionRepeat l'instruction à traduire
	 */
	public abstract void visiter(InstructionRepeat instructionRepeat);
	
	/**
	 * Traduit une variable.
	 * @param variable la variable à traduire
	 */
	public abstract void visiter(Variable variable);

	/**
	 * Traduit une affectation.
	 * @param affectation l'affectation à traduire
	 */
	public abstract void visiter(Affectation affectation);

	/**
	 * Traduit une expression composée.
	 * @param expr l'expression à traduire
	 */
	public abstract void visiter(ExpressionComplexe expr);

}

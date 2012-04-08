package traduction;

import instruction.Affectation;
import instruction.ExpressionComplexe;
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

public abstract class VisiteurTraduction {

	protected String traduction;
	protected int nivIndent;
	protected String indent;
	protected boolean identationTabulation = false;
	
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
			if (identationTabulation)
				indent+="\t";
			else
				indent+="    ";
		}
		return indent;
	}
	
	/**
	 * Permet de savoir si le caractère tabulation est utilisé pour l'indention.
	 * pour faire l'indention.
	 * @return true si la tabulation est utilisée pour l'indention, false sinon.
	 */
	public boolean isIdentationTabulation() {
		return identationTabulation;
	}

	/**
	 * Modifie la façon d'effectuer l'indention dans la traduction.
	 * @param identationTabulation si false l'indention sera effectuée avec des espaces, sinon c'est le caractère '\t' qui est utilisé.
	 */
	public void setIdentationTabulation(boolean identationTabulation) {
		this.identationTabulation = identationTabulation;
	}

	/**
	 * Traduit une instruction Declaration.
	 * @param instructionDeclaration l'instruction à traduire
	 */
	public abstract void visiter(InstructionDeclaration instructionDeclaration);
	/**
	 * Traduit une instruction Declaration Affectation.
	 * @param instructionDeclarationAffectation l'instruction à traduire
	 */
	public abstract void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation);
	
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
	/**
	 * Traduit une declaration de capteur.
	 * @param expr l'expression à traduire
	 */
	public abstract void visiter( InstructionDeclarationCapteur instructionDeclarationCapteur) ;
	/**
	 * Traduit une valeur de capteur.
	 * @param variableCapteur
	 */
	public abstract void visiter ( VariableCapteur variableCapteur);

	/**
	 * Traduit une instruction de rotation d'un moteur.
	 * @param instructionMoteurRotate l'instruction à traduire
	 */
	public abstract void visiter(InstructionMoteurRotate instructionMoteurRotate);
}

package jscratch.traduction;

import nxtim.instruction.Affectation;
import nxtim.instruction.ExpressionComplexe;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.InstructionDeclarationAffectation;
import nxtim.instruction.InstructionDeclarationCapteur;
import nxtim.instruction.InstructionDoWhile;
import nxtim.instruction.InstructionFor;
import nxtim.instruction.InstructionIf;
import nxtim.instruction.InstructionIfElse;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.InstructionMoteurRotate;
import nxtim.instruction.InstructionRepeat;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.InstructionTempsCourant;
import nxtim.instruction.InstructionWhile;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableCapteur;
import nxtim.instruction.VisiteurElementProg;

public abstract class VisiteurTraduction implements VisiteurElementProg {

	/**
	 * La traduction.
	 */
	protected String traduction;
	/**
	 * Le niveau d'indentation.
	 */
	protected int nivIndent;
	/**
	 * L'indentation totale.
	 */
	protected String indent;
	/**
	 * La méthode d'indentation.
	 */
	protected boolean identationTabulation = false;

	/**
	 * Donne la traduction.
	 *
	 * @return la traduction
	 */
	public String getTraduction() {
		return traduction;
	}

	/**
	 * Réinitialise la traduction.
	 */
	public void reset() {
		traduction = "";
		nivIndent = 0;
	}

	/**
	 * Donne l'indentation du niveau d'indentation courant.
	 *
	 * @return la chaîne correspondant à l'espace d'indentation.
	 */
	protected String indent() {
		String indentation = "";
		for (int i = 0; i < nivIndent; i++) {
			if (identationTabulation) {
				indentation += "\t";
			} else {
				indentation += "    ";
			}
		}
		return indentation;
	}

	/**
	 * Permet de savoir si le caractère tabulation est utilisé pour l'indentation.
	 *
	 * @return <code>true</code> si la tabulation est utilisée pour l'indentation, sinon <code>false</code>
	 */
	public boolean isIdentationTabulation() {
		return identationTabulation;
	}

	/**
	 * Modifie la façon d'effectuer l'indentation dans la traduction.
	 *
	 * @param identationTabulation si <code>false</code> l'indentation sera effectuée avec des espaces, sinon des tabulations
	 */
	public void setIdentationTabulation(final boolean identationTabulation) {
		this.identationTabulation = identationTabulation;
	}

	/**
	 * Traduit une instruction Declaration.
	 *
	 * @param instructionDeclaration l'instruction à traduire
	 */
	public abstract void visiter(InstructionDeclaration instructionDeclaration);

	/**
	 * Traduit une instruction Declaration Affectation.
	 *
	 * @param instructionDeclarationAffectation l'instruction à traduire
	 */
	public abstract void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation);

	/**
	 * Traduit une instruction if.
	 *
	 * @param instructionIf l'instruction à traduire
	 */
	public abstract void visiter(InstructionIf instructionIf);

	/**
	 * Traduit une instruction ifelse.
	 *
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionIfElse inst);

	/**
	 * Traduit une instruction while.
	 *
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionWhile inst);

	/**
	 * Traduit une instruction dowhile.
	 *
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionDoWhile inst);

	/**
	 * Traduit une instruction obtenant la tâche.
	 *
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionTache inst);

	/**
	 * Traduit une instruction obtenant le temps courant.
	 *
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionTempsCourant inst);

	/**
	 * Traduit une instruction d'attente.
	 *
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionAttente inst);

	/**
	 * Traduit une instruction de mouvement de moteur.
	 *
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionMoteurMov inst);

	/**
	 * Traduit une instruction d'arrêt de moteur.
	 *
	 * @param inst l'instruction à traduire
	 */
	public abstract void visiter(InstructionMoteurOff inst);

	/**
	 * Traduit une instruction for.
	 *
	 * @param instructionFor l'instruction à traduire
	 */
	public abstract void visiter(InstructionFor instructionFor);

	/**
	 * Traduit une instruction de répétition.
	 *
	 * @param instructionRepeat l'instruction à traduire
	 */
	public abstract void visiter(InstructionRepeat instructionRepeat);

	/**
	 * Traduit une variable.
	 *
	 * @param variable la variable à traduire
	 */
	public abstract void visiter(Variable variable);

	/**
	 * Traduit une affectation.
	 *
	 * @param affectation l'affectation à traduire
	 */
	public abstract void visiter(final Affectation affectation);

	/**
	 * Traduit une expression complexe.
	 *
	 * @param expr l'expression à traduire
	 */
	public abstract void visiter(final ExpressionComplexe expr);

	/**
	 * Traduit une déclaration de capteur.
	 *
	 * @param instructionDeclarationCapteur l'expression à traduire
	 */
	public abstract void visiter(final InstructionDeclarationCapteur instructionDeclarationCapteur);

	/**
	 * Traduit une valeur de capteur.
	 *
	 * @param variableCapteur la variable à traduire
	 */
	public abstract void visiter(final VariableCapteur variableCapteur);

	/**
	 * Traduit une instruction de rotation d'un moteur.
	 *
	 * @param instructionMoteurRotate l'instruction à traduire
	 */
	public abstract void visiter(final InstructionMoteurRotate instructionMoteurRotate);
}
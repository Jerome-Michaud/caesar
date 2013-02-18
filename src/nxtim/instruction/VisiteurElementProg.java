package nxtim.instruction;

/**
 * Interface permettant de visiter les instructions et les expressions.
 *
 * @author Adrien DUROY
 */
public interface VisiteurElementProg {

	/**
	 * Visite une instruction Declaration.
	 *
	 * @param instructionDeclaration l'instruction à visiter
	 */
	public void visiter(InstructionDeclaration instructionDeclaration);

	/**
	 * Visite une instruction Declaration Affectation.
	 *
	 * @param instructionDeclarationAffectation l'instruction à visiter
	 */
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation);

	/**
	 * Visite une instruction if.
	 *
	 * @param instructionIf l'instruction à visiter
	 */
	public void visiter(InstructionIf instructionIf);

	/**
	 * Visite une instruction ifelse.
	 *
	 * @param inst l'instruction à visiter
	 */
	public abstract void visiter(InstructionIfElse inst);

	/**
	 * Visite une instruction while.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionWhile inst);

	/**
	 * Visite une instruction dowhile.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionDoWhile inst);

	/**
	 * Visite une tâche.
	 *
	 * @param inst l'instruction tâche.
	 */
	public void visiter(InstructionTache inst);

	/**
	 * Visite une instruction obtenant le temps courant.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(TempsCourant exp);

	/**
	 * Visite une instruction d'attente.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionAttente inst);

	/**
	 * Visite une instruction de mouvement de moteur.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionMoteurMov inst);

	/**
	 * Visite une instruction d'arrêt de moteur.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionMoteurOff inst);

	/**
	 * Visite une instruction for.
	 *
	 * @param instructionFor l'instruction à visiter
	 */
	public void visiter(InstructionFor instructionFor);

	/**
	 * Visite une instruction de répétition.
	 *
	 * @param instructionRepeat l'instruction à visiter
	 */
	public void visiter(InstructionRepeat instructionRepeat);

	/**
	 * Visite une variable.
	 *
	 * @param variable la variable à visiter
	 */
	public void visiter(Variable variable);

	/**
	 * Visite une affectation.
	 *
	 * @param affectation l'affectation à visiter
	 */
	public void visiter(Affectation affectation);

	/**
	 * Visite une expression composée.
	 *
	 * @param expr l'expression à visiter
	 */
	public void visiter(ExpressionComplexe expr);

	/**
	 * Visite une declaration de capteur.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionDeclarationCapteur inst);

	/**
	 * Visite une valeur de capteur.
	 *
	 * @param variableCapteur
	 */
	public void visiter(VariableCapteur variableCapteur);

	/**
	 * Visite une instruction de rotation d'un moteur.
	 *
	 * @param instructionMoteurRotate l'instruction à visiter
	 */
	public void visiter(InstructionMoteurRotate instructionMoteurRotate);
	
	/**
	 * Visite une instruction d'incrémentation.
	 * 
	 * @param instructionIncrementation l'instruction à visier
	 */
	public void visiter(InstructionIncrementation instructionIncrementation);
}

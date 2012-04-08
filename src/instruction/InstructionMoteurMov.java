package instruction;

import traduction.VisiteurTraduction;
/**
 * Instruction de mouvement pour un moteur.
 * @author Adrien DUROY, Bastien AUBRY
 */
public class InstructionMoteurMov extends InstructionMoteurCmd{

	private boolean reverse;
	private Expression exp;
	
	/**
	 * Crée une instruction de mouvement d'un moteur non initialisée.
	 */
	public InstructionMoteurMov() {
		super();
	}

	/**
	 * Crée une instruction de mouvement d'un moteur.
	 * @param moteur le moteur concerné
	 * @param exp l'expression donnant la valeur du movement
	 * @param reverse booléen inversant le sens du mouvement si la valeur est true
	 */
	public InstructionMoteurMov(Moteur moteur, Expression exp, boolean reverse) {
		super(moteur);
		this.exp = exp;
		this.reverse = reverse;
	}
	
	/**
	 * Crée une instruction de mouvement d'un moteur.
	 * Le sens du mouvement n'est pas inversé.
	 * @param moteur le moteur concerné
	 * @param exp l'expression donnant la valeur du movement
	 */
	public InstructionMoteurMov(Moteur moteur, Expression exp) {
		this(moteur, exp, false);
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
	/**
	 * Modifie le sens du mouvement.
	 * @param reverse Si true le mouvement est inversé.
	 */
	public void setReverse(boolean reverse){
		this.reverse = reverse;
	}
	
	/**
	 * Permet de savoir si le mouvement est inversé.
	 * @return true si le mouvement est inversé, sinon false.
	 */
	public boolean isReverse() {
		return reverse;
	}
	
	/**
	 * Modifie l'expression de la valeur du mouvement.
	 * @param exp la nouvelle expression
	 */
	public void setExpression (Expression exp) {
		this.exp = exp;
	}
	
	/**
	 * Accède à l'expression donnant la valeur du mouvement.
	 * @return l'expression.
	 */
	public Expression getExpression() {
		return exp;
	}
	
	@Override
	public String toString() {
		return "moteurMov("+getMoteur()+")";
	}
}
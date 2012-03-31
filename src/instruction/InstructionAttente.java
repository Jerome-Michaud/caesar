package instruction;

import traduction.VisiteurTraduction;
/**
 * Cette instruction permet de mettre en attente
 * le programme pendant un certain temps.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionAttente implements Instruction {
	private Expression expression;
	/**
	 * Créé une instruction d'attente non initialisé.
	 * L'expression donnant le temps d'attente à pour valeur null.
	 */
	public InstructionAttente() {
		super();
	}

	/**
	 * Créé une instruction d'attente.
	 * @param expression l'expression donnant le temps d'attente.
	 */
	public InstructionAttente(Expression expression) {
		super();
		this.expression = expression;
	}

	/**
	 * Accède à l'expression donnant le temps d'attente.
	 * @return l'expression.
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * Modifie l'expression donnant le temps d'attente.
	 * @param expr la nouvelle expression.
	 */
	public void setExpression(Expression expr) {
		this.expression = expr;
	}
	
	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

package instruction;

import traduction.VisiteurTraduction;

/**
 * Boucle de répétition.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionRepeat extends InstructionInconditionelle{
	
	private Expression expression;
	
	/**
	 * Crée une boucle de répétition vide sans précision du nombre de répétion.
	 * L'expression donnant ce nombre vaut null.
	 */
	public InstructionRepeat() {
		super();
	}

	/**
	 * Crée une boucle de répétition vide.
	 * @param expr l'expression donnant le nombre de répétition
	 */
	public InstructionRepeat(Expression expr) {
		super();
		this.expression = expr;
	}

	/**
	 * Accède à l'expression donnant le nombre de répétition.
	 * @return l'expression.
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * Modifie l'expression donnant le nombre de répétition.
	 * @param expr la nouvelle expression
	 */
	public void setExpression(Expression expr) {
		this.expression = expr;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.CONTROL;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}

package nxtim.instruction;

import nxtim.exception.NXTIMBadTypeElementException;

/**
 * Expression logique de négation.
 * 
 * @since 1.0
 */
public class NonLogique implements Expression {

	private Expression condition;
	
	/**
	 * Créer une expression de négation vide.
	 */
	public NonLogique() {
		condition = null;
	}

	/**
	 * Créé une expresssion de négation d'une condition binaire.
	 * 
	 * @param c la condition binaire sur laquelle faire la négation.
	 */
	public NonLogique(Condition c) {
		condition = c;
	}
	
	/**
	 * Accède à l'expression de la condition sur laquelle porte la négation.
	 * 
	 * @return l'expression de la condition.
	 */
	public Expression getCondition() {
		return condition;
	}
	
	/**
	 * Modifie la condition de l'expresssion de négation.
	 * 
	 * @param c une condition binaire sur laquelle faire la négation.
	 */
	public void setCondition(Condition c) {
		condition = c;
	}
	
	public void setCondition(Variable v) {
		if(v == null || v.isBooleenne()) {
			condition = v;
		} else {
			throw new NXTIMBadTypeElementException(v.getType(), "Utilisation d'une variable non booléenne dans un non logique !");
		}
	}
	
	/**
	 * Modifie la condition de l'expresssion de négation par une autre expression de négation.
	 * Cette méthode existe car la majorité des langages permettent de faire un non logique
	 * sur un autre non logique bien que le résultat est le même que si les deux négations étaient absentes.
	 * 
	 * @param c une expression de négation sur laquelle faire la négation.
	 */
	public void setCondition(NonLogique c) {
		assert c != this;
		condition = c;
	}
	
	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.EXPRESSIONS;
	}

	@Override
	public TypeElement getType() {
		return TypeElement.BOOL;
	}

	@Override
	public boolean isBooleenne() {
		return true;
	}
}

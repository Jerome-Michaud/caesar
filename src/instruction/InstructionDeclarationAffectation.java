package instruction;

import traduction.VisiteurTraduction;

/**
 * Déclaration d'une variable avec initialisation en même temps.
 * @author Adrien DUROY, Bastien AUBRY
 */
public class InstructionDeclarationAffectation extends InstructionDeclaration {
	
	private Expression membreDroit ;
	
	/**
	 * Créé une déclaration avec initialisation sans variable et expression.
	 * Ces dernières ont pour valeur null.
	 */
	public InstructionDeclarationAffectation() {
		super();
	}

	/**
	 * Modifie la variable à déclarer et l'expression pour l'initialiser.
	 * @param variable
	 * @param expression
	 * @deprecated
	 */
	public void setMembre( VariableModifiable variable, Expression expression ){
		super.setMembre(variable);
		this.membreDroit = expression;
	}
	
	/**
	 * Accède à l'expression d'initialisation de la variable à déclarer.
	 * @return l'expression
	 */
	public Expression getMembreDroit() {
		return membreDroit;
	}
	
	/**
	 * Modifie l'expression d'initialisation
	 * @param expression
	 */
	public void setMembreDroit(Expression expression) {
		membreDroit = expression;
	}
	
	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
	@Override
	public String toString() {
		return getMembreGauche().getType() +" "+ getMembreGauche().getNom() +" = "+ membreDroit.toString() ;
	}
}

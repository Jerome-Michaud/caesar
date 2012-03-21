package instruction;

import traduction.VisiteurTraduction;
/**
 * Modèle d'une affectation.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class Affectation extends ExpressionComplexe implements Instruction{

	private boolean isInstruction;
	/**
	 * Crée une affectation.
	 * @param membreGauche variable cible de l'affectation
	 * @param membreDroit expression dont la valeur sera affecter à la variable
	 * @param isInstruction booléen indiquant si l'affectation doit être considérée comme une instruction
	 */
	public Affectation(VariableModifiable membreGauche, Expression membreDroit,boolean isInstruction) {
		super(Operateur.AFFECTATION, membreGauche, membreDroit);
		this.isInstruction = isInstruction;
	}
	/**
	 * Crée une affectation sans membres. Ces derniers seront renseignés plus tard.
	 * @param isInstruction booléen indiquant si l'affectation doit être considérée comme une instruction
	 */
	public Affectation(boolean isInstruction) {
		super(Operateur.AFFECTATION);
		this.isInstruction = isInstruction;
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}

	public String toString(){
		return getMembreGauche().toString() + getOperateur() + getMembreDroit();
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.OPERATEURS;
	}
	
	/**
	 * Permet de savoir si l'affectation est utilisée comme instruction.
	 * @return true si l'affectation est utilisée comme instruction, false sinon.
	 */
	public boolean isInstruction() {
		return isInstruction;
	}
	
	/**
	 * Modifie l'utilisation de l'affection en tant que instruction ou expression
	 * @param b si true l'affectation sera considéré comme une instruction
	 */
	public void setIsInstruction(boolean b) {
		isInstruction = b;
	}
}

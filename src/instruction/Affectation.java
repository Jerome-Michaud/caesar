package instruction;

import traduction.VisiteurTraduction;

public class Affectation extends ExpressionComplexe implements Instruction{

	private boolean isInstruction;
	
	public Affectation(VariableModifiable membreGauche, Expression membreDroit,boolean isInstruction) {
		super(Operateur.AFFECTATION, membreGauche, membreDroit);
		this.isInstruction = isInstruction;
	}
	public Affectation(boolean isInstruction) {
		super(Operateur.AFFECTATION);
		this.isInstruction = isInstruction;
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}

	public String toString(){
		return membreGauche.toString() + operateur + membreDroit;
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
	 * @param b
	 */
	public void setIsInstruction(boolean b) {
		isInstruction = b;
	}
}

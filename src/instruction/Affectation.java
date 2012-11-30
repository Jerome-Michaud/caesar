package instruction;

/**
 * Modèle d'une affectation.
 */
public class Affectation extends ExpressionComplexe implements Instruction {

	/**
	 * Savoir si cette affectation est utilisée comme une instruction.
	 */
	private boolean isInstruction;

	/**
	 * Crée une affectation.
	 * <p/>
	 * @param membreGauche variable cible de l'affectation
	 * @param membreDroit expression dont la valeur sera affecter à la variable
	 * @param isInstruction booléen indiquant si l'affectation doit être considérée comme une instruction
	 */
	public Affectation(final VariableModifiable membreGauche, final Expression membreDroit, final boolean isInstruction) {
		super(Operateur.AFFECTATION, membreGauche, membreDroit);
		this.isInstruction = isInstruction;
	}

	/**
	 * Crée une affectation sans membres. Ces derniers seront renseignés plus tard.
	 * <p/>
	 * @param isInstruction booléen indiquant si l'affectation doit être considérée comme une instruction
	 */
	public Affectation(final boolean isInstruction) {
		super(Operateur.AFFECTATION);
		this.isInstruction = isInstruction;
	}

	@Override
	public void accepte(final VisiteurElementProg v) {
		v.visiter(this);
	}

	@Override
	public String toString() {
		return getMembreGauche().toString() + getOperateur() + getMembreDroit();
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.OPERATEURS;
	}

	/**
	 * Permet de savoir si l'affectation est utilisée comme instruction.
	 * <p/>
	 * @return true si l'affectation est utilisée comme instruction, false sinon.
	 */
	public boolean isInstruction() {
		return isInstruction;
	}

	/**
	 * Modifie l'utilisation de l'affection en tant que instruction ou expression.
	 * <p/>
	 * @param b true si l'affectation sera considéré comme une instruction
	 */
	public void setIsInstruction(final boolean b) {
		this.isInstruction = b;
	}
}

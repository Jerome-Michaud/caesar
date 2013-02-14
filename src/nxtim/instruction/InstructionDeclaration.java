package nxtim.instruction;

/**
 * La déclaration est une instruction déclarant une variable.
 *
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionDeclaration implements Instruction {

	private Variable membreGauche;

	/**
	 * Crée une déclaration d'une variable sans la variable. Cette dernière devra être précisée plus tard.
	 */
	public InstructionDeclaration() {
		this(null);
	}
	
	/**
	 * Crée une déclaration d'une variable.
	 * 
	 * @param var la variable à déclarer.
	 */
	public InstructionDeclaration(Variable var) {
		super();
		membreGauche = var;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.VARIABLES;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	/**
	 * Modifie la variable à déclarer.
	 *
	 * @param variable la nouvelle variable.
	 */
	public void setMembre(Variable variable) {
		this.membreGauche = variable;
	}

	/**
	 * Accède à la variable de la déclaration.
	 *
	 * @return la variable ou null si elle n'a pas été précisée.
	 */
	public Variable getMembre() {
		return this.membreGauche;
	}

	/**
	 * Accède à la variable de la déclaration.
	 *
	 * @return la variable.
	 * @deprecated
	 */
	public Variable getMembreGauche() {
		return membreGauche;
	}

	/**
	 * Modifie la variable à déclarer.
	 *
	 * @param variable la nouvelle variable.
	 * @deprecated
	 */
	public void setMembreGauche(Variable variable) {
		membreGauche = variable;
	}

	@Override
	public String toString() {
		return membreGauche.getType() + " " + membreGauche.getNom();
	}
}

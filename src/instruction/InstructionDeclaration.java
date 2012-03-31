package instruction;

import traduction.VisiteurTraduction;

/**
 * La déclaration est une instruction déclarant une variable.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionDeclaration implements Instruction{

	private Variable membreGauche;

	public InstructionDeclaration() {
		super();
	}
	
	@Override
	public Categorie getCategorie() {
		return null;
	}
	
	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
	/**
	 * Modifie la variable à déclarer.
	 * @param variable la nouvelle variable.
	 */
	public void setMembre(Variable variable)
	{
		this.membreGauche = variable;
	}
	
	/**
	 * Accède à la variable de la déclaration.
	 * @return la variable.
	 */
	public Variable getMembre() {
		return this.membreGauche;
	}
	
	/**
	 * Accède à la variable de la déclaration.
	 * @return la variable.
	 * @deprecated
	 */
	public Variable getMembreGauche()
	{
		return membreGauche;
	}
	
	/**
	 * Modifie la variable à déclarer.
	 * @param variable la nouvelle variable.
	 * @deprecated
	 */
	public void setMembreGauche(Variable variable){
		membreGauche = variable;
	}

	@Override
	public String toString()
	{
		return membreGauche.getType() + " " +membreGauche.getNom();
	}
}

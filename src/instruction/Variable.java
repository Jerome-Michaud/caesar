package instruction;

import traduction.VisiteurTraduction;
/**
 * Concept abstrait regroupant les variables.
 * @author Adrien DUROY, Bastien AUBRY
 */
public abstract class Variable implements Expression{
	
	private TypeVariable type;
	private String nom;
	private String valeur;
	
	/**
	 * Crée une variable sans valeur.
	 * @param type Le type de la variable
	 * @param nom Le nom de la variable
	 */
	public Variable(TypeVariable type, String nom) {
		this(type, nom, "");
	}

	/**
	 * Construit une variable.
	 * @param type Le type de la variable
	 * @param nom Le nom de la variable
	 * @param valeur La valeur initiale de la variable.
	 */
	public Variable(TypeVariable type, String nom,  String valeur){
		this.type = type;
		this.nom = nom;
		this.valeur = valeur;
	}
	
	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}
	
	/**
	 * Permet de savoir si la variable est constante.
	 * @return true si la variable est constante, sinon false.
	 */
	public abstract boolean isConstante();
	
	/**
	 * Accède au type de la variable.
	 * @return le type de la variable.
	 */
	public TypeVariable getType() {
		return type;
	}

	/**
	 * Modifie le type de la variable.
	 * @param type le nouveau type
	 */
	public void setType(TypeVariable type) {
		this.type = type;	
	}

	/**
	 * Accède à la valeur de la variable.
	 * @return la valeur.
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * Modifie la valeur de la variable
	 * @param valeur la nouvelle valeur
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return this.getNom();
	}
	/**
	 * Donne le nom de la variable ou sa valeur si la variable n'a pas de nom.
	 * @return le nom de la variable.
	 */
	public String getNom() {
		if(nom == null || nom.equals(""))
			return valeur;
		return nom;
	}
}

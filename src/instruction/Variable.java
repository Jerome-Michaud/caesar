package instruction;

import traduction.VisiteurTraduction;

/**
 * Concept abstrait regroupant les variables.
 */
public abstract class Variable implements Expression {

	/**
	 * Le type de la variable.
	 */
	private TypeVariable type;
	/**
	 * Le nom de la variable.
	 */
	private String nom;
	/**
	 * La valeur de la variable.
	 */
	private String valeur;

	/**
	 * Crée une variable sans valeur.<br/>
	 * La valeur est initialisée à <code>null</code>
	 *
	 * @param type le type de la variable
	 * @param nom le nom de la variable
	 */
	public Variable(final TypeVariable type, final String nom) {
		this(type, nom, "");
	}

	/**
	 * Construit une variable.
	 *
	 * @param type le type de la variable
	 * @param nom le nom de la variable
	 * @param valeur la valeur initiale de la variable
	 */
	public Variable(final TypeVariable type, final String nom, final String valeur) {
		this.type = type;
		this.nom = nom;
		this.valeur = valeur;
	}

	@Override
	public void accepte(final VisiteurTraduction v) {
		v.visiter(this);
	}

	/**
	 * Permet de savoir si la variable est constante.
	 *
	 * @return <code>true</code> si la variable est constante, sinon <code>false</code>
	 */
	public abstract boolean isConstante();

	/**
	 * Accède au type de la variable.
	 *
	 * @return le type de la variable
	 */
	public TypeVariable getType() {
		return type;
	}

	/**
	 * Modifie le type de la variable.
	 *
	 * @param type le nouveau type
	 */
	public void setType(final TypeVariable type) {
		this.type = type;
	}

	/**
	 * Accède à la valeur de la variable.
	 *
	 * @return la valeur
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * Modifie la valeur de la variable.
	 *
	 * @param valeur la nouvelle valeur
	 */
	public void setValeur(final String valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return this.getNom();
	}

	/**
	 * Donne le nom de la variable ou sa valeur si la variable n'a pas de nom.
	 *
	 * @return le nom de la variable
	 */
	public String getNom() {
		if (nom == null || "".equals(nom)) {
			return valeur;
		}
		return nom;
	}
}
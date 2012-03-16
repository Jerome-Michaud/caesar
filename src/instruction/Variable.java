package instruction;

public abstract class Variable implements Expression{
	
	private TypeVariable type;
	private String nom;
	private String valeur;
	
	public Variable(TypeVariable type, String nom,  String valeur){
		this.type = type;
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public TypeVariable getType() {
		return type;
	}

	public void setType(TypeVariable type) {
		this.type = type;	
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		if (isConstante())
			return valeur;
		return getNom();
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
	
	public abstract boolean isConstante();

}

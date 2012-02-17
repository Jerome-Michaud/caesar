package instruction;

public abstract class Variable {
	
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
		return new String(type+" "+nom+"="+valeur);
	}
	
	public abstract boolean isConstante();

}

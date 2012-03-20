package instruction;

import traduction.VisiteurTraduction;

public class InstructionTache extends InstructionInconditionelle {

	private String nom;
		
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public InstructionTache()
	{
		//TODO nom de tache par defaut
		this.nom = "main";
	}
	
	public InstructionTache ( String nom)
	{
		this.nom = nom;
	}
	@Override
	public Categorie getCategorie() {
		return Categorie.CONTROL;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
	
	@Override
	public String toString(){
		String res = "";
		res+=nom+"(){\n";
		for (Instruction is : getEnfants()){
			res += "\t" + is + ";\n";
		}
		res+="}";
		return res;
	}

}

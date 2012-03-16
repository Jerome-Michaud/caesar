package instruction;

import traduction.VisiteurTraduction;

public class InstructionTache extends InstructionInconditionelle {

	private String nom;
	
	public InstructionTache()
	{
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
	
	public String toString()
	{
		String temp = super.toString();
		return "Tache " + nom + " " + temp;
		
		
	}

}

package instruction;

import traduction.VisiteurTraduction;

public class InstructionDeclaration implements Instruction{

	private VariableModifiable membreGauche;

	public InstructionDeclaration() {
		super();
	}
	
	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public void setMembre ( VariableModifiable variable ){
		this.membreGauche = variable;
	}
	
	public String toString()
	{
		return membreGauche.getType() + " " +membreGauche.getNom();
	}
	
	public VariableModifiable getMembreGauche()
	{
		return membreGauche;
	}



	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

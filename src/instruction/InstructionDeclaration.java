package instruction;

import traduction.VisiteurTraduction;

public class InstructionDeclaration implements Instruction{

	private VariableModifiable membreGauche;
	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		// TODO Auto-generated method stub
		
	}
	
	public void setMembre ( VariableModifiable variable ){
		this.membreGauche = variable;
	}
	
	public String toString()
	{
		return "declaration "+ membreGauche.toString() ;
	}
	
	public VariableModifiable getMembreGauche()
	{
		return membreGauche;
	}

}

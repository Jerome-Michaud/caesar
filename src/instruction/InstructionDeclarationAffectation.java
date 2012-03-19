package instruction;

public class InstructionDeclarationAffectation extends InstructionDeclaration {
	

	protected Expression membreDroit ;
	
	public void setMembre( VariableModifiable variable, Expression expression ){
		super.setMembre(variable);
		this.membreDroit = expression;
	}
	
	public String toString()
	{
		return membreGauche.getType() +" "+ membreGauche.getNom() +" = "+ membreDroit.toString() ;
	}

}

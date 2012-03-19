package instruction;

public class InstructionDeclarationAffectation extends InstructionDeclaration {
	

	private Expression membreDroit ;
	
	public void setMembre( VariableModifiable variable, Expression expression ){
		super.setMembre(variable);
		this.membreDroit = expression;
	}
	
	public String toString()
	{
		return "declarationAffectation  "+ getMembreGauche().toString() +"  "+ membreDroit.toString() ;
	}
	public Expression getMembreDroit()
	{
		return membreDroit;
	}
}

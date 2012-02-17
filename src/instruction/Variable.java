package instruction;

public abstract class Variable {
	
	private TypeVariable type;
	private String nom;
	
	public abstract boolean isConstante();
	
	public abstract TypeVariable getTypeVariable()
	{
		return type;
	}
	
}

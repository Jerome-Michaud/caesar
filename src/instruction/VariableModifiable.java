package instruction;

public abstract class VariableModifiable extends Variable{

	public VariableModifiable(TypeVariable type, String nom,  String valeur){
		super(type, nom, valeur);
	}
	@Override
	public boolean isConstante() {
		return false;
	}
	
}

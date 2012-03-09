package instruction;

import traduction.VisiteurTraduction;

public class VariableConstante extends Variable{

	public VariableConstante(TypeVariable type, String nom,  String valeur){
		super(type, nom, valeur);
	}
	@Override
	public boolean isConstante() {
		return true;
	}
	@Override
	public void accepte(VisiteurTraduction v) {
		// TODO Auto-generated method stub
	}

}

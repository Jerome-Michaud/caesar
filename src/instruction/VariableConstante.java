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
	public void setMembreDroit(Expression expression) {
		// TODO Auto-generated method stub
	}
	@Override
	public void setMembreGauche(Expression expression) {
		// TODO Auto-generated method stub
	}
	@Override
	public void accepte(VisiteurTraduction v) {
		// TODO Auto-generated method stub
	}

}

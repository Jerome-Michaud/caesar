package instruction;

import traduction.VisiteurTraduction;

public class Affectation extends ExpressionComplexe implements Instruction{

	public Affectation(VariableModifiable membreGauche, Expression membreDroit) {
		super(Operateur.AFFECTATION, membreGauche, membreDroit);
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}

	public String toString(){
		return membreGauche.toString() + operateur + membreDroit;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.OPERATEURS;
	}
}

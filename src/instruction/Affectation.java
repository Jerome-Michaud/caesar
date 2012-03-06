package instruction;

import traduction.VisiteurTraduction;

public class Affectation extends ExpressionComplexe {

	public Affectation(VariableModifiable membreGauche, Expression membreDroit)
			throws Exception {
		super(TypeOperation.AFF, membreGauche, membreDroit);

		// TODO fix
		if (membreDroit instanceof Affectation)
			throw new Exception();
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}

	public String toString(){
		return membreGauche.toString() + typeOperation + membreDroit;
	}
}

package instruction;

import traduction.VisiteurTraduction;

public class Operation extends ExpressionComplexe {

	public Operation(TypeOperation typeOperation, Expression membreGauche,
			Expression membreDroit) throws Exception {
		super(typeOperation, membreGauche, membreDroit);
		// TODO fix
		if (membreGauche instanceof Affectation
				|| membreDroit instanceof Affectation)
			throw new Exception();
	}

	@Override
	public void accepte(VisiteurTraduction v) {

	}

}

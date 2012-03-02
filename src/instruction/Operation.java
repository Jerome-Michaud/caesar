package instruction;

import traduction.VisiteurTraduction;

public class Operation extends ExpressionComplexe {

	public Operation(TypeOperation typeOperation, Expression membreDroit, Expression membreGauche) throws Exception {
		super(typeOperation, membreDroit, membreGauche);
		//TODO fix
		if (membreGauche instanceof Affectation)
			throw new Exception();
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		
	}

	
	
}

package instruction;

import traduction.VisiteurTraduction;

public class Condition extends ExpressionComplexe {

	public Condition(TypeOperation typeOperation, Expression membreDroit,
			Expression membreGauche) {
		super(typeOperation, membreDroit, membreGauche);
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		// TODO Auto-generated method stub
	}
}

package instruction;

import traduction.VisiteurTraduction;

public class Condition extends ExpressionComplexe {

	public Condition(Operateur operation, Expression membreDroit, Expression membreGauche) throws Exception
	{
		super(operation, membreDroit, membreGauche);
		if(!Operateur.isLogique(operation))
			throw new Exception("Opérateur non logique dans Condition.");
	}

	public Condition(Operateur operateur) throws Exception {
		super(operateur);
		if(!Operateur.isLogique(operateur))
			throw new Exception("Opérateur non logique dans Condition.");
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}
}

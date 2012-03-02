package instruction;

import traduction.VisiteurTraduction;

public class Affectation extends ExpressionComplexe{

	public Affectation(Expression membreDroit,
			Expression membreGauche) {
		super(TypeOperation.AFF, membreDroit, membreGauche);
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}

}

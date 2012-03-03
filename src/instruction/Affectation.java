package instruction;

import traduction.VisiteurTraduction;

public class Affectation extends ExpressionComplexe {

	public Affectation(Expression membreGauche, Expression membreDroit)
			throws Exception {
		super(TypeOperation.AFF, membreGauche, membreDroit);

		// TODO fix
		if (!(membreGauche instanceof VariableModifiable)
				|| membreDroit instanceof Affectation)
			throw new Exception();
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}

}

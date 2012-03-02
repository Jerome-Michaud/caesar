package instruction;

public class Affectation extends ExpressionComplexe{

	public Affectation(Expression membreDroit,
			Expression membreGauche) {
		super(TypeOperation.AFF, membreDroit, membreGauche);
	}

	@Override
	public void acceptVisiteur(VisiteurTraduction v) {
		v.visiter(this);
	}

}

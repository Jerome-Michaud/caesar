package instruction;

import traduction.VisiteurTraduction;

public class InstructionAttente implements Instruction {

	private Expression expr;

	public InstructionAttente(Expression expr) {
		super();
		this.expr = expr;
	}

	public Expression getExpression() {
		return expr;
	}

	public void setExpression(Expression expr) {
		this.expr = expr;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

package instruction;

import traduction.VisiteurTraduction;

public class InstructionAttente implements Instruction {

	private Expression expression;

	public InstructionAttente(Expression expr) {
		super();
		this.expression = expr;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expr) {
		this.expression = expr;
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

package instruction;

import traduction.VisiteurTraduction;

public class InstructionAttente implements Instruction {


	public InstructionAttente() {
		super();
	}

	private Expression expression;

	public InstructionAttente(Expression expression) {
		super();
		this.expression = expression;
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

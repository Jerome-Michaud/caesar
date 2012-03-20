package instruction;

import traduction.VisiteurTraduction;

public class InstructionRepeat extends InstructionInconditionelle{
	
	private Expression expression;
	
	public InstructionRepeat() {
		super();
	}

	public InstructionRepeat(Expression expr) {
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
		return Categorie.CONTROL;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}

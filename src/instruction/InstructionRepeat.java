package instruction;

import traduction.VisiteurTraduction;

public class InstructionRepeat extends InstructionInconditionelle{
	
	private Expression expr;
	
	public InstructionRepeat(Expression expr) {
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
		return Categorie.CONTROL;
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}
}

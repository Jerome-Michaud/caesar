package instruction;

/**
 * Expression logique.
 */
public class Condition extends ExpressionComplexe {

	/**
	 * Crée une condition.
	 *
	 * @param operation l'opérateur logique à utiliser
	 * @param membreDroit le membre gauche de la condition
	 * @param membreGauche le membre droit de la condition
	 * @throws RuntimeException Si l'opérateur fourni n'est pas un opérateur logique.
	 */
	public Condition(Operateur operation, Expression membreGauche, Expression membreDroit) {
		super(operation, membreGauche, membreDroit);
		if (!Operateur.isLogique(operation)) {
			throw new RuntimeException("Opérateur non logique dans Condition.");
		}
	}

	/**
	 * Crée une condition.
	 *
	 * @param operateur l'opérateur logique à utiliser
	 * @throws RuntimeException Si l'opérateur fourni n'est pas un opérateur logique.
	 */
	public Condition(Operateur operateur) {
		super(operateur);
		if (!Operateur.isLogique(operateur)) {
			throw new RuntimeException("Opérateur non logique dans Condition.");
		}
	}

	@Override
	public void accepte(VisiteurElementProg v) {
		v.visiter(this);
	}

	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}
}

package instruction;

import traduction.VisiteurTraduction;

/**
 * Expression arithmétique.
 */
public class Operation extends ExpressionComplexe {

	/**
	 * Créé une opération à partir de deux autres.
	 *
	 * @param operation l'opérateur de l'opération
	 * @param membreGauche le membre de gauche
	 * @param membreDroit le membre de droit
	 * @throws RuntimeException Si l'opérateur fourni n'est pas un opérateur arithmétique
	 */
	public Operation(final Operateur operation, final Operation membreGauche, final Operation membreDroit) {
		super(operation, membreGauche, membreDroit);
		if (!Operateur.isArithmetique(operation)) {
			throw new RuntimeException("Opérateur non arithméthique dans Operation.");
		}
	}

	/**
	 * Créé une opération sur deux variables.
	 *
	 * @param operation l'opérateur de l'opération
	 * @param membreGauche le membre de gauche
	 * @param membreDroit le membre de droite
	 * @throws RuntimeException Si l'opérateur fourni n'est pas un opérateur arithmétique
	 */
	public Operation(final Operateur operation, final Variable membreGauche, final Variable membreDroit) {
		super(operation, membreGauche, membreDroit);
		if (!Operateur.isArithmetique(operation)) {
			throw new RuntimeException("Opérateur non arithméthique dans Operation.");
		}
	}

	/**
	 * Créé une opération à partir d'une variable et d'une autre opération.
	 *
	 * @param operation l'opérateur de l'opération
	 * @param membreGauche le membre de gauche
	 * @param membreDroit le membre de droite
	 * @throws RuntimeException Si l'opérateur fourni n'est pas un opérateur arithmétique
	 */
	public Operation(final Operateur operation, final Operation membreGauche, final Variable membreDroit) {
		super(operation, membreGauche, membreDroit);
		if (!Operateur.isArithmetique(operation)) {
			throw new RuntimeException("Opérateur non arithméthique dans Operation.");
		}
	}

	/**
	 * Créé une opération à partir d'une variable et d'une autre opération.
	 *
	 * @param operation l'opérateur de l'opération
	 * @param membreGauche le membre gauche
	 * @param membreDroit le membre de droite
	 * @throws RuntimeException Si l'opérateur fourni n'est pas un opérateur arithmétique
	 */
	public Operation(final Operateur operation, final Variable membreGauche, final Operation membreDroit) {
		super(operation, membreGauche, membreDroit);
		if (!Operateur.isArithmetique(operation)) {
			throw new RuntimeException("Opérateur non arithméthique dans Operation.");
		}
	}

	@Override
	public void accepte(final VisiteurTraduction v) {
		v.visiter(this);
	}
}
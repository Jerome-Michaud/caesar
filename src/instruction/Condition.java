package instruction;

import traduction.VisiteurTraduction;

/**
 * Expression logique.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class Condition extends ExpressionComplexe {

	/**
	 * Crée une condition.
	 * @param operation l'opérateur logique à utiliser
	 * @param membreDroit le membre gaughe de la condition
	 * @param membreGauche le membre droit de la condition
	 * @throws Exception Si l'opérateur fourni n'est pas un opérateur logique.
	 */
	public Condition(Operateur operation, Expression membreDroit, Expression membreGauche) throws Exception
	{
		super(operation, membreDroit, membreGauche);
		if(!Operateur.isLogique(operation))
			throw new Exception("Opérateur non logique dans Condition.");
	}

	/**
	 * Crée une condition.
	 * @param operateur l'opérateur logique à utiliser
	 * @throws Exception Si l'opérateur fourni n'est pas un opérateur logique.
	 */
	public Condition(Operateur operateur) throws Exception {
		super(operateur);
		if(!Operateur.isLogique(operateur))
			throw new Exception("Opérateur non logique dans Condition.");
	}

	@Override
	public void accepte(VisiteurTraduction v) {
		v.visiter(this);
	}
}

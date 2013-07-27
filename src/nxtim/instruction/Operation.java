package nxtim.instruction;

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
	public void accepte(VisiteurElementProg v) {
		v.visiter(this);
	}

	@Override
	public Categorie getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBooleenne() {
		return false;
	}

	@Override
	public TypeElement getType() {
		if(getMembreGauche() == null || getMembreDroit() == null)
			return null;
		return choixDuType(getMembreGauche().getType(), getMembreDroit().getType());
	}
	
	/**
	 * Donne le type acceptant deux autres.
	 * 
	 * @param e1 le premier type
	 * @param e2 le second type
	 * @return le type minimal pouvant recevoir les deux autres.
	 */
	private static TypeElement choixDuType(TypeElement e1, TypeElement e2) {
		//Si même type pas de soucis
		if(e1 == e2) {
			return e1;
		}
		//Si type différent => conversion possible ?
		switch(e1) {
			case BOOL:
				return TypeElement.BOOL;
			case DOUBLE:
				return TypeElement.DOUBLE;
			case FLOAT:
				if(e2 == TypeElement.DOUBLE)
					return TypeElement.DOUBLE;
				return TypeElement.FLOAT;
			case SHORT:
				if(e2 == TypeElement.INT)
					return TypeElement.INT;
				//Sinon même chose que si e1 est INT
			case INT:
				switch(e2) {
					case FLOAT:
					case DOUBLE:
						return e2;
					default:
						break;
				}
				return null;
			default:
				return null;
		}
	}
}
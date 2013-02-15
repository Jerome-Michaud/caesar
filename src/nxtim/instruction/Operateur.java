package nxtim.instruction;

import java.util.LinkedList;
import java.util.List;

/**
 * Cette énumération regroupe les différents opérateurs disponibles pour les expressions.
 */
public enum Operateur {

	/**
	 * Les opérateurs binaire.
	 */
	ADDITION, SOUSTRACTION, MULTIPLICATION, DIVISION,
	/**
	 * Les opérateurs logiques.
	 */
	ET, OU, SUPERIEUR, INFERIEUR, EGALITE, SUPEGAL, INFEGAL,
	/**
	 * Les opérateurs d'affectation.
	 */
	AFFECTATION;

	@Override
	public String toString() {
		switch (this) {
			case AFFECTATION:
				return "=";
			case ADDITION:
				return "+";
			case SOUSTRACTION:
				return "-";
			case MULTIPLICATION:
				return "*";
			case DIVISION:
				return "/";
			case ET:
				return "&&";
			case OU:
				return "||";
			case SUPERIEUR:
				return ">";
			case INFERIEUR:
				return "<";
			case EGALITE:
				return "==";
			case SUPEGAL:
				return ">=";
			case INFEGAL:
				return "<=";
			default:
				return null;
		}
	}

	/**
	 * Permet de savoir si un opérateur est arithmétique.
	 *
	 * @param o l'opérateur à tester
	 * @return <code>true</code> si l'opérateur est arithmétique, sinon <code>false</code>.
	 */
	public static boolean isArithmetique(final Operateur o) {
		switch (o) {
			case ADDITION:
				return true;
			case DIVISION:
				return true;
			case SOUSTRACTION:
				return true;
			case MULTIPLICATION:
				return true;
			default:
				return false;
		}
	}

	/**
	 * Permet de savoir si un opérateur est logique.
	 *
	 * @param o l'opérateur à tester
	 * @return <code>true</code> si l'opérateur est logique, sinon <code>false</code>
	 */
	public static boolean isLogique(final Operateur o) {
		if (!Operateur.isArithmetique(o) && o != AFFECTATION) {
			return true;
		}
		return false;
	}

	/**
	 * Donne la liste des opérateurs logiques sous forme d'une liste.
	 *
	 * @return la liste des opérateurs logiques.
	 */
	public static List<Operateur> logiques() {
		List<Operateur> ops = new LinkedList<Operateur>();
		for (Operateur o : values()) {
			if (isLogique(o)) {
				ops.add(o);
			}
		}
		return ops;
	}

	/**
	 * Donne la liste des opérateurs logiques sous forme d'un tableau.
	 *
	 * @return la liste des opérateurs logiques
	 */
	public static Operateur[] logiquesA() {
		return (Operateur[]) logiques().toArray(new Operateur[0]);
	}

	/**
	 * Donne la liste des opérateurs de comparaison sous forme d'une liste.
	 *
	 * @return la liste des opérateurs de comparaison
	 */
	public static List<Operateur> comparaison() {
		List<Operateur> ops = new LinkedList<Operateur>();
		ops.add(INFERIEUR);
		ops.add(INFEGAL);
		ops.add(SUPERIEUR);
		ops.add(SUPEGAL);
		return ops;
	}

	/**
	 * Donne la liste des opérateurs de comparaison sous forme d'un tableau.
	 *
	 * @return la liste des opérateurs de comparaison
	 */
	public static Operateur[] comparaisonA() {
		return (Operateur[]) comparaison().toArray(new Operateur[0]);
	}

	/**
	 * Donne la liste des opérateurs arithmétiques.
	 *
	 * @return la liste des opérateurs arithmétiques
	 */
	public static List<Operateur> arithmetiques() {
		List<Operateur> ops = new LinkedList<Operateur>();
		ops.add(ADDITION);
		ops.add(DIVISION);
		ops.add(SOUSTRACTION);
		ops.add(MULTIPLICATION);
		return ops;
	}
}
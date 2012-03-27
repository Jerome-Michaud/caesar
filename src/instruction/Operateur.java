package instruction;

import java.util.LinkedList;
import java.util.List;

/**
 * Cette énumération regroupe les différents opérateurs disponibles pour les expressions
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public enum Operateur {

	ADDITION, SOUSTRACTION, MULIPLICATION, DIVISION,/* Arithmétique */
	ET, OU, NON, SUPERIEUR, INFERIEUR, EGALITE, SUPEGAL, INFEGAL,/* Logique */
	AFFECTATION;

	public String toString() {
		switch (this) {
			case AFFECTATION:
				return "=";
			case ADDITION:
				return "+";
			case SOUSTRACTION:
				return "-";
			case MULIPLICATION:
				return "*";
			case DIVISION:
				return "/";
			case ET:
				return "&&";
			case OU:
				return "||";
			case NON:
				return "!";
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
				return "";
		}
	}

	/**
	 * Permet de savoir  si un opérateur est arithmétique.
	 * @param o l'opérateur à tester
	 * @return true si l'opérateur est arithmétique, false sinon.
	 */
	public static boolean isArithmetique(Operateur o)
	{
		switch(o)
		{
			case ADDITION:
			case DIVISION:
			case SOUSTRACTION:
			case MULIPLICATION:
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * Permet de savoir  si un opérateur est logique.
	 * @param o l'opérateur à tester
	 * @return true si l'opérateur est logique, false sinon.
	 */
	public static boolean isLogique(Operateur o)
	{
		if(!Operateur.isArithmetique(o) && o != AFFECTATION)
			return true;
		return false;
	}
	/**
	 * Donne la liste des opérateurs logiques.
	 * @return la liste des opérateurs logiques.
	 */
	public static List<Operateur> logiques()
	{
		List<Operateur> ops = new LinkedList<Operateur>();
		ops.add(EGALITE);
		ops.add(ET);
		ops.add(INFEGAL);
		ops.add(INFERIEUR);
		ops.add(OU);
		ops.add(SUPEGAL);
		ops.add(SUPERIEUR);
		return ops;
	}
	/**
	 * Donne la liste des opérateurs arithmetiques.
	 * @return la liste des opérateurs arithmetiques.
	 */
	public static List<Operateur> arithmetiques()
	{
		List<Operateur> ops = new LinkedList<Operateur>();
		ops.add(ADDITION);
		ops.add(DIVISION);
		ops.add(SOUSTRACTION);
		ops.add(MULIPLICATION);
		return ops;
	}
}

package instruction;
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
	
	public static boolean isLogique(Operateur o)
	{
		if(!Operateur.isArithmetique(o) && o != AFFECTATION)
			return true;
		return false;
	}
}

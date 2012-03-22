package instruction;

/**
 * Cette énumération donne la liste des différents types
 * possibles pour les variables.
 * @author Ivan MELNYCHENKO
 */
public enum TypeVariable {
	INT, SHORT, LONG, FLOAT, BOOL, STRING, LIST;

	public String toString(){
		switch (this){
			case INT:
				return "int";
			case SHORT:
				return "short";
			case LONG:
				return "long";
			case FLOAT:
				return "float";
			case BOOL:
				return "bool";
			case  STRING:
				return "string";
			case LIST:
				return "list";
		}
		return null;
	}
	
}

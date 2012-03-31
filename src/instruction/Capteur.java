package instruction;

/**
 * Cette énumération correspond aux différents capteurs.
 * @author Bastien AUBRY, Ivan MELNYCHENKO
 */
public enum Capteur {
	TOUCH;

	public String toString(){
		switch (this){
		case TOUCH : return "Capteur touch";
		}
		return null;
	}
}


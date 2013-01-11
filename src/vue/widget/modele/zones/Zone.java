package vue.widget.modele.zones;

/**
 * Interface définissant la structure d'une zone d'un widget.
 *
 * @author Vincent Besnard - Quentin Gosselin
 */
public interface Zone {

	/**
	 * Modifie la valeur de la zone.
	 *
	 * @param v La valeur de la zone
	 */
	public void setValeur(String v);

	/**
	 * Donne la valeur de la zone.
	 *
	 * @return le valeur de la zone.
	 */
	public String getValeur();
	
	public int getPositionX();
	
	public void setPositionX(int posX);
}

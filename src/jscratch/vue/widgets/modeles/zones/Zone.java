package jscratch.vue.widgets.modeles.zones;

import org.jdom2.Element;

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
	
	public int getPositionY();
	
	public void setPositionX(int posX);
	
	public void setPositionY(int posY);
	/**
	 * Dit si la zone est utilisée par un widget ou pas ou si c'est impossible.
	 *
	 * @return -1, si impossible de mettre. 0 si possible mais pas attaché. 1 si attaché.
	 */
	public int getEtat();
	
	/**
	 * Permet d'avoir comment le widget doit se sérialiser.
	 */
	public Element toXml();
}

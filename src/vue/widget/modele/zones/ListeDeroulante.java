package vue.widget.modele.zones;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;
import org.jdom2.Element;

/**
 * Classe représentant une liste déroulante particulière qui pourra être insérée au sein d'un widget.
 *
 * @author Vincent Besnard - Quentin Gosselin
 * @param <T> Le type des valeurs de la liste.
 */
public class ListeDeroulante<T> extends JComboBox implements Zone {

	/**
	 * La liste regroupant les items de la liste déroulante
	 */
	private List<T> lesItems;

	/**
	 * Constructeur du composant faisant appel au constructeur équivalent de la
	 * classe mère et initialisant la liste d'items.
	 */
	public ListeDeroulante() {
		super();
		this.lesItems = new LinkedList<T>();
	}

	/**
	 * Constructeur du composant faisant appel au constructeur équivalent de la classe mère.
	 *
	 * @param a un tableau représentant les items qui seront présents dans la liste déroulante
	 */
	public ListeDeroulante(T[] a) {
		super(a);
	}

	/**
	 * Modifie la liste d'items du composant.
	 *
	 * @param l La nouvelle liste d'items
	 */
	public void setLesItems(List<T> l) {
		this.lesItems = l;
	}

	/**
	 * Modifie la valeur selectionée de la liste déroulante.
	 *
	 * @param v L'indice de l'élèment à sélectionner
	 */
	@Override
	public void setValeur(String v) {
		this.setSelectedIndex(Integer.parseInt(v));
	}

	/**
	 * Récupère la valeur de l'élément selectionné.
	 *
	 * @return la valeur de l'élément.
	 */
	@Override
	public String getValeur() {
		return String.valueOf(this.getSelectedIndex());
	}

	@Override
	public int getEtat() {
		return -1;
	}

	@Override
	public Element toXml() {
		Element zone = new Element("zone");
		zone.setAttribute("valeur", this.getValeur());
				
		return zone;
	}
}

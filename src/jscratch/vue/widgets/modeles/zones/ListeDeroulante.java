package jscratch.vue.widgets.modeles.zones;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import jscratch.traduction.LanceurTraduction;
import jscratch.vue.widgets.modeles.ModeleWidget;

import org.jdom2.Element;

/**
 * Classe représentant une liste déroulante particulière qui pourra être insérée au sein d'un widget.
 *
 * @author Vincent Besnard - Quentin Gosselin
 * @param <T> Le type des valeurs de la liste.
 */
public class ListeDeroulante<T> extends JComboBox implements Zone {

	/**
	 * Constructeur du composant faisant appel au constructeur équivalent de la classe mère.
	 *
	 * @param a un tableau représentant les items qui seront présents dans la liste déroulante
	 */
	public ListeDeroulante(T[] a, final ModeleWidget widgetParent) {
		super(a);
		
		// Détection des changements pour la mise à jour de la traduction
		this.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				widgetParent.applyChangeModele();
				LanceurTraduction.getInstance().lancerTraduction();
			}
		});
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

	@Override
	public int getPositionX() {
		return this.getX();
	}

	@Override
	public void setPositionX(int posX) {
		this.setLocation(posX, this.getY());
	}

	@Override
	public int getPositionY() {
		return this.getY();
	}

	@Override
	public void setPositionY(int posY) {
		this.setLocation(this.getX(),posY);
	}
}

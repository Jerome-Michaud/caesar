package vue.widget.modele.zones;

import javax.swing.JTextField;

/**
 * Cette classe représente un champ texte particulier intégrable dans un widget.
 */
public class ChampTexte extends JTextField implements Zone {
	/**
	 * Constructeur faisant appel au constructeur équivalent de la classe mère.
	 */
	public ChampTexte() {
		super();
	}
	
	/**
	 * Récupère le texte du champ texte.
	 * @return la valeur du champ texte.
	 */
	@Override
	public String getValeur() {
		return this.getText();
	}
	/**
	 * Modifie le texte du champ texte.
	 * @param v le nouveau texte du champ.
	 */
	@Override
	public void setValeur(String v) {
		this.setText(v);
	}
}
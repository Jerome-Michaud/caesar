package vue.Widget.modele.zones;

import javax.swing.JTextField;

public class ChampTexte extends JTextField implements Zone {
	
	public ChampTexte() {
		super();
	}

	public String getValeur() {
		return this.getText();
	}

	public void setValeur(String v) {
		this.setText(v);
	}
}
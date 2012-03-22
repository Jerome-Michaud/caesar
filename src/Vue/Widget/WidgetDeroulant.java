package Vue.Widget;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;

public class WidgetDeroulant<T> extends Widget implements WidgetComposant {

	private JComboBox zone;
	private List<T> lesValeurs;

	public WidgetDeroulant(ModeleWidget modele, int xTexte, int yTexte) {
		super(modele);
		this.setLayout(null);

		this.lesValeurs = new LinkedList<T>();

		this.zone = new JComboBox();
		this.zone.setBounds(xTexte, yTexte, 50, 20);
		this.add(this.zone);
	}

	@Override
	public int getValeur() {
		return this.zone.getSelectedIndex();
	}

	@Override
	public void setValeur(int v) {
		this.zone.setSelectedIndex(v);
	}

	public void setLesValeurs(List<T> l) {
		this.lesValeurs = l;
	}
}

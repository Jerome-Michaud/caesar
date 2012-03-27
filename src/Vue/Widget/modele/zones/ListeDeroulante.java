package Vue.Widget.modele.zones;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JComboBox;

public class ListeDeroulante<T> extends JComboBox implements Zone {
	private List<T> lesItems;
	
	public ListeDeroulante() {
		super();
		this.lesItems = new LinkedList<T>();
	}
	
	public ListeDeroulante(T[] a) {
		super(a);
	}
	
	public void setLesItems(List<T> l) {
		this.lesItems = l;
	}

	@Override
	public void setValeur(String v) {
		this.setSelectedIndex(Integer.parseInt(v));
	}

	@Override
	public String getValeur() {
		return String.valueOf(this.getSelectedIndex());
	}
}

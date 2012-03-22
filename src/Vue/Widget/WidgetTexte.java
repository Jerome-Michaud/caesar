package Vue.Widget;

import Vue.Widget.modele.ModeleWidget;
import Vue.Tools.IntegerTextField;

public class WidgetTexte extends Widget implements WidgetComposant {

	private IntegerTextField zone;

	public WidgetTexte(ModeleWidget modele, int xTexte, int yTexte) {
		super(modele);
		this.setLayout(null);

		this.zone = new IntegerTextField();
		this.zone.setBounds(xTexte, yTexte, 20, 20);
		this.add(this.zone);
	}

	@Override
	public int getValeur() {
		return this.zone.getInt();
	}

	@Override
	public void setValeur(int v) {
		this.zone.setInt(v);
	}
}

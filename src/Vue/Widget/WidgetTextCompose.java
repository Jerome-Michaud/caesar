package Vue.Widget;

import java.util.LinkedList;
import java.util.List;

public class WidgetTextCompose extends WidgetTexte {

	private List<Widget> lesFils;

	public WidgetTextCompose(ModeleWidget modele, int x, int y) {
		super(modele, x, y);
		this.lesFils = new LinkedList<Widget>();
	}

	public boolean ajouterWidget(Widget widget) {
		return this.lesFils.add(widget);
	}

	public boolean supprimerWidget(Widget widget) {
		return this.lesFils.remove(widget);
	}
}

package jscratch.comparateurs;

import java.awt.Component;
import java.util.Comparator;
import jscratch.vue.widgets.Widget;

public class ComparateurWidgetZ implements Comparator<Component> {

	@Override
	public int compare(Component t, Component t1) {
		Widget wT = (Widget) t;
		Widget wT1 = (Widget) t1;
		return wT.getParent().getComponentZOrder(wT) - wT1.getParent().getComponentZOrder(wT1);
	}
}
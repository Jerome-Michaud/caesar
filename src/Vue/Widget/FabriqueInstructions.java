package Vue.Widget;

import Vue.Interface.PanelWidget;

public class FabriqueInstructions {

	public Widget creerWidgetInstruction() {
		return new Widget(new ModeleWidget(TypeWidget.INSTRUCTION));
	}

	public WidgetCompose creerWidgetIf() {
		return new WidgetCompose(new ModeleWidget(TypeWidget.IF));
	}

	public Widget creerWidgetNegation() {
		return new WidgetTexte(new ModeleWidget(TypeWidget.NEGATION), 100, 3);
	}

	public Widget cloner(Widget comp) {
		Widget j = null;
		if (comp.getType() == TypeWidget.INSTRUCTION) {
			j = PanelWidget.getInstance().getFabrique().creerWidgetInstruction();
		} else if (comp.getType() == TypeWidget.IF) {
			j = PanelWidget.getInstance().getFabrique().creerWidgetIf();
		} else if (comp.getType() == TypeWidget.NEGATION) {
			j = PanelWidget.getInstance().getFabrique().creerWidgetNegation();
		}
		j.setBounds(comp.getBounds());
		return j;
	}
}

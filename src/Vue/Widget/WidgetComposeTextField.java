package Vue.Widget;

import javax.swing.JTextField;

import Vue.Tools.IntegerTextField;
import Vue.Widget.modele.ModeleWidget;

public class WidgetComposeTextField extends WidgetCompose {

	private JTextField zone;
	
	public WidgetComposeTextField(ModeleWidget comp,int xTexte , int yTexte ) {
		super(comp);
		this.setLayout(null);

		this.zone = new JTextField();
		this.zone.setBounds(xTexte, yTexte, 20, 20);
		this.add(this.zone);
	}
	
	
	public String getString() {
		return this.zone.getText();
	}


	public void setString(String s) {
		this.zone.setText(s);
	}

}

package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Polygon;

public class WaitWidget extends ModeleWidget {

	int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
	int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};
	
	
	public WaitWidget() {
		super();
		
		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setType(TypeWidget.WAIT);
		this.setMessage("Wait");
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

	}
}

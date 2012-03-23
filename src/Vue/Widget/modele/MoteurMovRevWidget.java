package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Color;
import java.awt.Polygon;

public class MoteurMovRevWidget extends ModeleWidget {

	public MoteurMovRevWidget() {
		super();
		
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};
		
		this.tabX = tX;
		this.tabY = tY;
		
		this.type = TypeWidget.MOTEURMOVREV;
		this.couleur = Color.BLUE;
		this.message = "MoteurMovRev";
		this.forme = new Polygon(this.tabX, this.tabY, this.tabX.length);
	}
}

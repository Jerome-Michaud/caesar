package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Color;
import java.awt.Polygon;

public class DoWhileWidget extends ModeleWidget {

	public DoWhileWidget() {
		super();
		
		int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,             /**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                     /**/135,130,/**/50,45,35,30,/**/5,0};
		int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,                   /**/ 10, 15,/**/15,20,20,15, /**/15, 20,/**/ 25, 30,/**/30,35,35,30,/**/30, 35,                               /**/50,55,/**/55,60,60,55,/**/55,50};
		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setType(TypeWidget.DOWHILE);
		this.setCouleur(Color.BLUE);
		this.setMessage("Do");
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
	}
}

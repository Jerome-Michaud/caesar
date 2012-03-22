package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Color;
import java.awt.Polygon;

public class WhileWidget extends ModeleWidget {
		
		public WhileWidget(){
			super();
			
			int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                                 /**/135,130,/**/50,45,35,30,/**/5,0};
			int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,                         /**/50,55,/**/55,60,60,55,/**/55,50};
		 
			this.tabX = tX;
			this.tabY = tY;
			this.type = TypeWidget.WHILE;
			this.couleur = Color.YELLOW;
			this.message = "While";
			this.forme = new Polygon(this.tabX, this.tabY, this.tabX.length);
		}

}

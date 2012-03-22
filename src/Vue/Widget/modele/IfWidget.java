package Vue.Widget.modele;

import java.awt.Color;
import java.awt.Polygon;

public class IfWidget extends ModeleWidget{

	private int tabX[]={0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                    135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                /**/135,130,/**/50,45,35,30,/**/5,0};
	private int tabY[]={5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,       50, 55,/**/55,60,60,55, /**/55, 60,/**/ 65, 70,/**/70,75,75,70,/**/70, 75,                              /**/80,85,/**/85,90,90,85,/**/85,80};
    
	
		public IfWidget(){
			super();
			this.type=TypeWidget.IF;
			this.couleur = Color.BLUE;
			this.message = "répéter";
			this.forme = new Polygon(this.tabX, this.tabY, this.tabX.length);
		}
}

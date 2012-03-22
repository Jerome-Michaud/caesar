package Vue.Widget.modele;

import java.awt.Color;
import java.awt.Polygon;

public class TacheWidget extends ModeleWidget{

	private int tabX[]={0, 5,/**/ /**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                                 /**/135,130,/**/5,0};
	private int tabY[]={5, 0,/**/ /**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,                         /**/50,55,/**/55,50};
   
	
		public TacheWidget(){
			super();
			this.type=TypeWidget.TACHE;
			this.couleur = Color.BLUE;
			this.message = "Tache";
			this.forme = new Polygon(this.tabX, this.tabY, this.tabX.length);
		}
}

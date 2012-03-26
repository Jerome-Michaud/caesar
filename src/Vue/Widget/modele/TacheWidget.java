package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Polygon;
import java.io.Serializable;

public class TacheWidget extends ModeleWidget implements Serializable{

	
    public TacheWidget(){
        super();

        int[] tX = {0, 5,/**/ /**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,/**/135,130,/**/5,0};
        int[] tY = {5, 0,/**/ /**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,/**/50,55,/**/55,50};

        this.setTabX(tX);
        this.setTabY(tY);
        this.setType(TypeWidget.TACHE);
        this.setMessage("Tâche");
        this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
        this.attachableBas = false;
        this.attachableHaut = false;
    }
}

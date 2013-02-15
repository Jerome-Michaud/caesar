package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import jscratch.parametrages.Variables;
import nxtim.instruction.InstructionTache;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type Tâche
 *
 * @since 1.0
 * @version 1.0
 */
public class TacheWidget extends ModeleWidget {

    /**
     * Constructeur du modèle définissant les différents paramètres du Tâche
     */
    public TacheWidget() {
        int[] tX = {0, 5,/**/ /**/ 130, 135,/**/ 135, 130,/**/ 55, 50, 40, 35, /**/ 10, 5,/**/ 5, 10,/**/ 35, 40, 50, 55,/**/ 130, 135,/**/ 135, 130,/**/ 5, 0};
        int[] tY = {5, 0,/**/ /**/ 0, 5,/**/ 20, 25,/**/ 25, 30, 30, 25, /**/ 25, 30,/**/ 35, 40,/**/ 40, 45, 45, 40,/**/ 40, 45,/**/ 50, 55,/**/ 55, 50};

        this.setTabX(tX);
        this.setTabY(tY);
        this.setType(TypeModeleWidget.TACHE);

        message.put(new Point(5, 17), "Tâche principale");

        this.setElementProgramme(new InstructionTache());
        this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
        this.attachableBas = false;
        this.attachableHaut = false;
        this.imbricable = false;

        this.zonesAccroches.add(Variables.ZONE_ACCROCHE_PAR_DEFAULT);
		
		this.decalageX(-30);
    }

    @Override
    public void decalageX(int a) {
        int i;
        for (i = 2; i < 6; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
        }
        for (i = 18; i < 22; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
        }
        this.setForme(this.getForme());
        this.setTailleX();
    }
    
    @Override

    public void decalageY(int b,Rectangle r) {

        int i;
        for (i = 12; i < tabY.length; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }
    
    @Override
    public void initListeners() { }
}
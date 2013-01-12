package jscratch.vue.widget.modele;

import java.awt.Point;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.Serializable;

import jscratch.modeles.TypeWidget;
import jscratch.vue.tools.Variables;
import nxtim.instruction.InstructionWhile;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type While.
 * 
 * @author Bastien Aubry - Vincent Besnard - Quentin Gosselin
 */
public class WhileWidget extends ModeleWidget implements Serializable{
	/**
	 * Constructeur du modèle définissant les différents paramètres du While.
	 */
    public WhileWidget(){
        int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                                 /**/135,130,/**/50,45,35,30,/**/5,0};
        int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,                         /**/50,55,/**/55,60,60,55,/**/55,50};

        this.setTabX(tX);
        this.setTabY(tY);
        this.setType(TypeWidget.WHILE);
        
		//this.setMessage("While");
		message.put(new Point(5, 17), "Tant que");
		message.put(new Point(85, 17), "faire");
		
		this.setElementProgramme(new InstructionWhile());
        this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
        this.zonesAccroches.add(Variables.ZONE_ACCROCHE_PAR_DEFAULT);
    }
    
    /**
     * Méthode permettant d'augmenter la hauteur du composant.
     *
     * @param b La valeur de l'agrandissement à appliquer
     * @param r Le rectangle à augmenter également
     */
    @Override
    public void decalageY(int b,Rectangle r) {
        int i;
        for (i = 16; i < tabY.length; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }
    
    /**
     * Méthode d'initialisation des listeners.
     */
    @Override
	public void initListeners() {}
}
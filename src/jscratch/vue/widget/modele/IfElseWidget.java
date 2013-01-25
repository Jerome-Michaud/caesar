package jscratch.vue.widget.modele;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.Serializable;

import jscratch.vue.tools.Variables;
import jscratch.vue.widget.modele.zones.ChampTexte;
import nxtim.instruction.InstructionIfElse;

/**
 * Classe héritant de ModeleWidget et implémentant Serializable modélisant la
 * forme d'un widget de type IfElse
 * 
 * @since 1.0
 * @version 1.0
 */
public class IfElseWidget extends ModeleWidget implements Serializable {
	
	/**
	 * Constructeur du modèle définissant les différents paramètres du IfElse.
	 */
	public IfElseWidget() {
		int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                    135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                /**/135,130,/**/50,45,35,30,/**/5,0};
		int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,       50, 55,/**/55,60,60,55, /**/55, 60,/**/ 65, 70,/**/70,75,75,70,/**/70, 75,                              /**/80,85,/**/85,90,90,85,/**/85,80};
    
		this.setTabX(tX);
		this.setTabY(tY);
		this.setType(TypeModeleWidget.IFELSE);
		
		message.put(new Point(5, 17), "Si");
		message.put(new Point(80, 17), "alors");
		message.put(new Point(5, 52), "sinon");
		
		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(55, 3, 20, 20);
		f.supprimerTexte();
		this.getLesZonesSaisies().add(f);

		this.setElementProgramme(new InstructionIfElse());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		this.zonesAccroches.add(Variables.ZONE_ACCROCHE_PAR_DEFAULT);
		this.zonesAccroches.add(Variables.ZONE_ACCROCHE_ELSE);
		
		this.decalageX(-20);
	}

    @Override
    public void decalageX(int x) {
    	int i;
        for (i = 6; i < 10; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + x;
        }
        for (i = 22; i < 26; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + x;
        }
        for (i = 38; i < 42; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + x;
        }
        this.setForme(this.getForme());
        this.setTailleX();
    }
	
    @Override
    public void decalageY(int x,Rectangle r) {
    	 if(r.getY()==Variables.ZONE_ACCROCHE_PAR_DEFAULT.getY()){
    		int i;
	        for (i = 16; i < tabY.length; i++) {
	            this.getForme().ypoints[i] = this.getForme().ypoints[i] + x;
	        }
	        this.setForme(this.getForme());
	        this.setTailleY();
         }
		 else {
        	 int i;
 	        for (i = 32; i < tabY.length; i++) {
 	            this.getForme().ypoints[i] = this.getForme().ypoints[i] + x;
 	        }
 	        this.setForme(this.getForme());
 	        this.setTailleY();
         }       
    }
    
	@Override
	public void initListeners() {}
}
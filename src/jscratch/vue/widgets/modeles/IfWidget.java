package jscratch.vue.widgets.modeles;

import java.awt.Point;

import java.awt.Polygon;
import java.awt.Rectangle;

import jscratch.parametrages.Variables;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.InstructionIf;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la 
 * forme d'un widget de type If.
 * 
 * @since 1.0
 * @version 1.0
 */
public class IfWidget extends ModeleWidget{
	
	/**
	 * Constructeur du modèle définissant les différents paramètres du If.
	 */
	public IfWidget(){
		int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                /**/135,130,/**/50,45,35,30,/**/5,0};
		int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,                             /**/50,55,/**/55,60,60,55,/**/55,50};
		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.IF);
		
		this.message.put(new Point(5, 17), "Si");
		this.message.put(new Point(80, 17), "alors");
		
		int widthChamp = 20;
		ChampTexte f = new ChampTexte(widthChamp);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(55, 3, widthChamp, 20);
		f.supprimerTexte();
		this.getLesZonesSaisies().add(f);

		this.setElementProgramme(new InstructionIf());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		this.zonesAccroches.add(Variables.ZONE_ACCROCHE_PAR_DEFAULT);

		this.decalageX(-20);
	}
	
	@Override
	public void decalageX(int a) {
        int i;
        for (i = 6; i < 10; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
        }
        for (i = 22; i < 26; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
        }
        this.setForme(this.getForme());
        this.setTailleX();
    }
	
    @Override
    public void decalageY(int b,Rectangle r) {
        int i;
        for (i = 16; i < tabY.length; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }
    
	@Override
	public void initListeners() { }
}
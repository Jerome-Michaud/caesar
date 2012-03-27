package Vue.Widget.modele;

import Modeles.TypeWidget;
import Vue.Tools.Variables;
import instruction.InstructionDoWhile;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.Serializable;

public class DoWhileWidget extends ModeleWidget implements Serializable{

	public DoWhileWidget() {
		super();
		
		int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,             /**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                     /**/135,130,/**/50,45,35,30,/**/5,0};
		int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,                   /**/ 10, 15,/**/15,20,20,15, /**/15, 20,/**/ 25, 30,/**/30,35,35,30,/**/30, 35,                               /**/50,55,/**/55,60,60,55,/**/55,50};
		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setType(TypeWidget.DOWHILE);
		this.setMessage("Do");
		this.setElementProgramme(new InstructionDoWhile());
		this.setConditionHaute(false);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		this.zonesAccroches.add(Variables.ZONE_ACCROCHE_DOWHILE);
		
		initListeners();
	}

	public void decalageXout(int a) {
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

    public void decalageXin(int a) {
        int i;
        for (i = 6; i < 10; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] - a;
        }
        for (i = 22; i < 26; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] - a;
        }
        this.setForme(this.getForme());
        this.setTailleX();
    }

    public void decalageYout(int b,Rectangle r) {
        int i;
        for (i = 16; i < tabY.length; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }

    public void decalageYin(int b,Rectangle r) {
        int i;
        for (i = 16; i < tabY.length; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] - b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }
	
	public void initListeners() {
		
	}
}

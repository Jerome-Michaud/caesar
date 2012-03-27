package Vue.Widget.modele;

import Modeles.TypeWidget;
import Vue.Widget.modele.zones.ChampTexte;
import instruction.InstructionMoteurMov;
import java.awt.Polygon;

public class MoteurMovFwdWidget extends ModeleWidget {

		
	
	public MoteurMovFwdWidget() {
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.MOTEURMOVFWD);
		this.setMessage("Moteurmovfwd");
		this.setElementProgramme(new InstructionMoteurMov());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		
		
		ChampTexte f = new ChampTexte();
		f.setBounds(110, 3, 20, 20);
		this.getLesZonesSaisies().add(f);
	}

	public void decalageXout(int a) {
        int i;
        for (i = 6; i < 10; i++) {
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
        this.setForme(this.getForme());
        this.setTailleX();
    }

    public void decalageYout(int b) {
        int i;
        for (i = 8; i < 16; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }

    public void decalageYin(int b) {
        int i;
        for (i = 8; i < 16; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] - b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }
}

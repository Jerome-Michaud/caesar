package jscratch.vue.widget.modele;

import jscratch.vue.widget.modele.zones.ChampTexte;
import jscratch.vue.widget.modele.zones.Zone;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;


import java.awt.Rectangle;
import jscratch.vue.tools.Variables;
import nxtim.instruction.InstructionRepeat;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.VariableConstante;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type Repeat
 * 
 * @author Bastien Aubry - Vincent Besnard - Quentin Gosselin
 */
public class RepeatWidget extends ModeleWidget {

	public RepeatWidget() {
		int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55, 50, 40, 35, /**/ 10, 5,/**/ 5, 10,/**/ 35, 40, 50, 55,/**/ 130, 135, /**/ 135, 130,/**/ 50, 45, 35, 30,/**/ 5, 0};
		int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/ 25, 30, 30, 25, /**/ 25, 30,/**/ 35, 40,/**/ 40, 45, 45, 40,/**/ 40, 45, /**/ 50, 55,/**/ 55, 60, 60, 55,/**/ 55, 50};


		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.REPEAT);
		
		//this.setMessage("Repeat");
		message.put(new Point(5, 17), "Répéter");
		message.put(new Point(85, 17), "fois");
		
		this.setElementProgramme(new InstructionRepeat());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		this.zonesAccroches.add(Variables.ZONE_ACCROCHE_PAR_DEFAULT);


		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(60, 3, 20, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);

		this.setInstructionValeur(f.getValeur());
		
		
		initListeners();
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
	public void initListeners() {
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent arg0) {
				setInstructionValeur(((Zone) getLesZonesSaisies().get(0)).getValeur());
			}
		});
	}
	
	/**
	 * Méthode permettant de définir la valeur de l'instruction moteur
	 * 
	 * @param nom La valeur de l'instruction moteur
	 */
	private void setInstructionValeur(String nom) {
		((InstructionRepeat) getElementProgramme()).setExpression(new VariableConstante(TypeVariable.INT, "", nom));
	}
}

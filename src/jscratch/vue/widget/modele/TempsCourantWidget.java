package jscratch.vue.widget.modele;


import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComponent;

import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.Variable;
import nxtim.instruction.InstructionTempsCourant;
import nxtim.instruction.VariableModifiable;

import jscratch.modeles.DicoVariables;
import jscratch.vue.widget.modele.zones.ChampTexte;
import jscratch.vue.widget.modele.zones.ListeDeroulante;
import jscratch.vue.widget.modele.zones.Zone;



/**
 *
 * @author zubair
 */


public class TempsCourantWidget extends ModeleWidget{

	private ChampTexte f;
	/**
	 * Constructeur du modèle TempsCourantWidget.
	 */
	public TempsCourantWidget(){
		super();

		
		this.setElementProgramme(new InstructionTempsCourant());
		int tX[] = {0, 5, 30, 35, 45, 50, 170, 175, 175, 170, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0,  5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};


		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.TEMPSCOURANT);


		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.setBounds(170, 3, 20, 20);
		f.supprimerTexte();
		this.getLesZonesSaisies().add(f);
		
		message.put(new Point(5, 17), "Affecter Temps Courant à");

		initListeners();
		this.decalageX(20);
	}

	
	@Override
	public void applyChangeModele(){

		InstructionTempsCourant tempCour = ((InstructionTempsCourant) getElementProgramme());

		if(f.isContentWidget()){
	
			VariableModifiable var = (VariableModifiable)f.getContentWidget().getElementProgramme();
			tempCour.setVariable(var);
		}else{
			tempCour.setVariable(null);
		}

	}

	@Override
	public void initListeners() {
		
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {
		
			@Override
			public void focusLost(FocusEvent arg0) {
				applyChangeModele();
			}
		});
	}


}

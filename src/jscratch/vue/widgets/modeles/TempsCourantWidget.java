package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import nxtim.instruction.InstructionTempsCourant;
import nxtim.instruction.VariableModifiable;
import jscratch.vue.widgets.modeles.zones.ChampTexte;

/**
 * @since 1.0
 * @version 1.0
 */
public class TempsCourantWidget extends ModeleWidget {
	
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

		int widthChamp = 20;
		f = new ChampTexte(widthChamp);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.setBounds(170, 3, widthChamp, 20);
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

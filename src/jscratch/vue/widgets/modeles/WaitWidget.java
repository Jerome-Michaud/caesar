package jscratch.vue.widgets.modeles;

import jscratch.vue.widgets.modeles.zones.ChampTexte;
import jscratch.vue.widgets.modeles.zones.Zone;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.TypeElement;
import nxtim.instruction.VariableConstante;
import nxtim.instruction.VariableModifiable;

/**
 * Cette classe modèlise la forme d'un widget de type Wait.
 * 
 * @since 1.0
 * @version 1.0
 */
public class WaitWidget extends ModeleWidget {
	private ChampTexte f;
	/**
	 * Constructeur du modèle définissant les différents paramètres du Wait.
	 */
	public WaitWidget() {
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.WAIT);
		
		//this.setMessage("Wait");
		message.put(new Point(5, 17), "Attendre");
		message.put(new Point(108, 17), "ms");
		
		this.setElementProgramme(new InstructionAttente());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		int widthChamp = 40;
		f = new ChampTexte(widthChamp, this);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.setBounds(65, 3, widthChamp, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);

		this.setInstructionValeur(f.getValeur());
		
		this.decalageX(-5);
		
		initListeners();
	}
	@Override
	public void applyChangeModele(){

		InstructionAttente attenteIns = ((InstructionAttente) getElementProgramme());

		if (f.getContentWidget() != null) {
			VariableModifiable var = (VariableModifiable)f.getContentWidget().getElementProgramme();
			attenteIns.setExpression(var);
		}
		else {
			attenteIns.setExpression(new VariableConstante(TypeElement.INT, f.getValeur()));
		}
	
	}
	@Override
	public void decalageY(int b, Rectangle r) {
		int i;
		for (i = 8; i < 16; i++) {
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
	 * Définie le temps d'attente de l'instruction Wait.
	 * 
	 * @param nom La valeur du temps d'attente
	 */
	private void setInstructionValeur(String nom) {
		((InstructionAttente) getElementProgramme()).setExpression(new VariableConstante(TypeElement.INT, "", nom));
	}
}

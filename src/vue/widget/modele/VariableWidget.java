package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import vue.widget.modele.zones.Zone;
import instruction.InstructionAttente;
import instruction.VariableConstante;
import instruction.TypeVariable;
import instruction.VariableModifiable;

import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComponent;
import modeles.TypeWidget;



/**
 *
 * @author zubair
 */
public class VariableWidget extends ModeleWidget {
	/**
	 * Constructeur du modèle définissant les différents paramètres du Variable.
	 */

	private VariableWidget(){
		
	}
	public VariableWidget(VariableModifiable variableModifiable) {
		
		super();
        
                       
		int tX[] = {0, 3, 20, 23, 23, 20, 3, 0};
                
		int tY[] = {3, 0, 0,  3,  10, 13, 13,10};
	
		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.VARIABLE);
	
		message.put(new Point(7, 11), variableModifiable.getNom());
		this.setElementProgramme(variableModifiable);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte f = new ChampTexte();
		f.setBounds(65, 3, 40, 20);
		f.setText("0");
		this.getLesZonesSaisies().add(f);

		
		this.decalageXout(-5);
		
		initListeners();
	}

	@Override
	public void decalageXout(int a) {
		/*int i;
		for (i = 6; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		this.setForme(this.getForme());
		this.setTailleX();*/
	}

	@Override
	public void decalageXin(int a) {
		/*int i;
		for (i = 6; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] - a;
		}
		this.setForme(this.getForme());
		this.setTailleX();*/
	}

	@Override
	public void decalageYout(int b, Rectangle r) {
		/*int i;
		for (i = 8; i < 16; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
		}
		this.setForme(this.getForme());
		this.setTailleY();*/
	}

	@Override
	public void decalageYin(int b, Rectangle r) {
	/*	int i;
		for (i = 8; i < 16; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] - b;
		}
		this.setForme(this.getForme());
		this.setTailleY();*/
	}

	@Override
	public void initListeners() {
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {

	
		});
	}
	
	/**
	 * 
	 * @return nom de variable
	 */
	public String getNomVariable() {
		return ((VariableModifiable)this.getElementProgramme()).getNom();
	}

}

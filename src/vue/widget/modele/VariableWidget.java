package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import vue.widget.modele.zones.Zone;
import instruction.InstructionAttente;
import instruction.VariableConstante;
import instruction.TypeVariable;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import javax.swing.JButton;
import modeles.TypeWidget;



/**
 *
 * @author zubair
 */
public class VariableWidget extends ModeleWidget {
	/**
	 * Constructeur du modèle définissant les différents paramètres du Variable.
	 */
	public VariableWidget() {
		super();
                
                
                       
		int tX[] = {0, 3, 20, 23, 23, 20, 3, 0};
                
		int tY[] = {3, 0, 0,  3,  10, 13, 13,10};
	
		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.VARIABLE);
		//recupère type variable avec son nom
               // Variable var = new Variable()
		message.put(new Point(7, 11), "a");
		//message.put(new Point(108, 17), "ms");
		
		this.setElementProgramme(new InstructionAttente());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte f = new ChampTexte();
		f.setBounds(65, 3, 40, 20);
		f.setText("0");
		this.getLesZonesSaisies().add(f);

		this.setInstructionValeur(f.getText());
		
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
		((InstructionAttente) getElementProgramme()).setExpression(new VariableConstante(TypeVariable.INT, "", nom));
	}
}

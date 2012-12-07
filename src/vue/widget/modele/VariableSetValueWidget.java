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
import vue.widget.modele.zones.ListeDeroulante;
import modeles.TypeWidget;
import modeles.DicoVars;
import instruction.*;



/**
 *
 * @author zubi
 */
public class VariableSetValueWidget extends ModeleWidget {
	/**
	 * Constructeur du modèle définissant les différents paramètres du Variable.
	 */
	public VariableSetValueWidget() {
		super();



		int tX[] = {0, 5, 30, 35, 45, 50, 170, 175, 175, 170, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.VARIABLE);


		message.put(new Point(5, 17), "Var:");
		message.put(new Point(100, 17), " = ");

		this.setElementProgramme(new InstructionAttente());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ListeDeroulante l = new ListeDeroulante<Variable>(DicoVars.getInstance().getLesvariables());
		l.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add(l);

		ChampTexte f = new ChampTexte();
		f.setBounds(65, 3, 40, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);

		this.setInstructionValeur(l.getValeur());
		this.setInstructionValeur(f.getValeur());

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

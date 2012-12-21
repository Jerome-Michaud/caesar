package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import vue.widget.modele.zones.ListeDeroulante;
import vue.widget.modele.zones.Zone;
import instruction.InstructionAttente;
import instruction.Variable;
import instruction.VariableConstante;
import instruction.TypeVariable;
import instruction.VariableModifiable;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import modeles.DicoVars;
import modeles.TypeWidget;



/**
 *
 * @author zubair
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
		this.setType(TypeWidget.SETVALUEVARIABLE);

		message.put(new Point(5, 17), "set");
		message.put(new Point(100, 17), " to ");

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		/*variables = new JComboBox(DicoVars.getInstance().getLesvariables());
		variables.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add((Zone) variables);*/
		ListeDeroulante l = new ListeDeroulante<Variable>(DicoVars.getInstance().getLesvariables());
		l.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add(l);


		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
		f.setBounds(65, 3, 40, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);



		this.decalageX(-5);

		initListeners();
	}

	@Override
	public void decalageX(int a) {
		int i;
		for (i = 2; i < this.getTabX().length-2; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a ;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}
	/*
	@Override
	public void decalageXin(int a) {
		int i;
		for (i = 2; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] - a;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}
	 */
	@Override
	public void decalageY(int b, Rectangle r) {
		int i;
		for (i = 8; i < 16; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
		}
		this.setForme(this.getForme());
		this.setTailleY();
	}
	/*
	@Override
	public void decalageYin(int b, Rectangle r) {
		int i;
		for (i = 8; i < 16; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] - b;
		}
		this.setForme(this.getForme());
		this.setTailleY();
	}
	 */
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

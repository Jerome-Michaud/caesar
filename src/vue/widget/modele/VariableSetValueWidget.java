package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import vue.widget.modele.zones.ListeDeroulante;
import instruction.Variable;
import instruction.VariableModifiable;

import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;

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
		int tY[] = {5, 0, 0,  5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};


		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.SETVALUEVARIABLE);

		message.put(new Point(5, 17), "set");
		message.put(new Point(100, 17), " to ");

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

	
		ListeDeroulante l = new ListeDeroulante<Variable>(DicoVars.getInstance().getLesvariables());
		l.setBounds(55, 3, 40, 20);
		this.getLesZonesSaisies().add(l);
		

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeWidget.SETVALUEVARIABLE);
		f.setBounds(130, 3, 30, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);
		


		initListeners();
	}

	@Override
	public void decalageX(int a) {
		int i;
		for (i = 2; i < this.getTabX().length - 2; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		this.setForme(this.getForme());
		this.setTailleX();
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
	}

	/**
	 * Retourne le nom de la variable.
	 *
	 * @return nom de variable
	 */
	public String getNomVariable() {
		return ((VariableModifiable) this.getElementProgramme()).getNom();
	}
}

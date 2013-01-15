package jscratch.vue.widget.modele;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import jscratch.modeles.DicoVariables;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableModifiable;
import jscratch.vue.widget.modele.zones.ChampTexte;
import jscratch.vue.widget.modele.zones.ListeDeroulante;




/**
 *
 * @author zubair
 */
public class VariableSetValueWidget extends ModeleWidget {


	/**
	 * Constructeur du modèle définissant les différents paramètres du Variable.
	 */



	public VariableSetValueWidget() {

		int tX[] = {0, 5, 30, 35, 45, 50, 170, 175, 175, 170, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};


		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.SETVALUEVARIABLE);

		message.put(new Point(5, 17), "set");
		message.put(new Point(100, 17), " to ");

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		/*variables = new JComboBox(DicoVars.getInstance().getLesvariables());
		variables.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add((Zone) variables);*/
		ListeDeroulante l = new ListeDeroulante<Variable>(DicoVariables.getInstance().getLesvariables());
		l.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add(l);


		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.setBounds(65, 3, 40, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);



		this.decalageX(-5);

		initListeners();
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
	public void initListeners() { }

	/**
	 * 
	 * @return nom de variable
	 */
	public String getNomVariable() {
		return ((VariableModifiable)this.getElementProgramme()).getNom();
	}
}
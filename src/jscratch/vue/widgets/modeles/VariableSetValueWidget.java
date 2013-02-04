package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import nxtim.instruction.VariableModifiable;
import jscratch.vue.widgets.modeles.zones.ChampTexte;

/**
 *
 * @since 1.0
 * @version 1.0
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

		message.put(new Point(5, 17), "Mettre");
		message.put(new Point(95, 17), "dans");

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		int widthChamp = 35;
		ChampTexte f = new ChampTexte(widthChamp);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(55, 3, widthChamp, 20);
		f.setValeur("0");	
		this.getLesZonesSaisies().add(f);

		widthChamp = 40;
		f = new ChampTexte(widthChamp);
		f.supprimerTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.setBounds(128, 3, widthChamp, 20);
		this.getLesZonesSaisies().add(f);
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
	 * Permet de récupérer le nom de la variable.
	 * 
	 * @return le nom de variable
	 */
	public String getNomVariable() {
		return ((VariableModifiable)this.getElementProgramme()).getNom();
	}
}
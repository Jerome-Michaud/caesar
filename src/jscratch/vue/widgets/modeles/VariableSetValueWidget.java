package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import nxtim.instruction.Affectation;
import nxtim.instruction.Expression;
import nxtim.instruction.VariableModifiable;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.TypeElement;
import nxtim.instruction.VariableConstante;

/**
 *
 * @since 1.0
 * @version 1.0
 */
public class VariableSetValueWidget extends ModeleWidget {
	private ChampTexte g,d;
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
		g = new ChampTexte(widthChamp, this);
		g.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		g.ajouterTypeWidgetAccepte(TypeModeleWidget.TEMPSCOURANT);
		g.ajouterTypeWidgetAccepte(TypeModeleWidget.CAPTEUR);
		g.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		g.ajouterTypeWidgetAccepte(TypeModeleWidget.MOTEURNOMBREROTATION);
		g.setBounds(55, 3, widthChamp, 20);
		g.setValeur("0");
		this.getLesZonesSaisies().add(g);

		widthChamp = 40;
		d = new ChampTexte(widthChamp, this);
		d.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		d.setBounds(128, 3, widthChamp, 20);
		d.supprimerTexte();
		this.getLesZonesSaisies().add(d);
		
		this.setElementProgramme(new Affectation(true));
	}

	@Override
	public void applyChangeModele() {
		if (g != null && d != null) {
			Widget contentWidget = g.getContentWidget();
			Widget contentWidgetVar = d.getContentWidget();

			Affectation setValueIns = ((Affectation) getElementProgramme());

			// On met à jour le contenu dans l'elementProgramme
			if (contentWidget != null) {
				Expression expComp = (Expression) contentWidget.getElementProgramme();
				setValueIns.setMembreDroit(expComp);
			}
			else {
				setValueIns.setMembreDroit(new VariableConstante(TypeElement.INT, g.getValeur()));
			}
			if (contentWidgetVar != null) {
				VariableModifiable var  = (VariableModifiable) contentWidgetVar.getElementProgramme();
				setValueIns.setMembreGauche(var);
				setValueIns.setIsInstruction(true);
			}
			else {
				setValueIns.setMembreGauche(new VariableConstante(TypeElement.INT, d.getValeur()));
			}
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

	/**
	 * Permet de récupérer le nom de la variable.
	 * 
	 * @return le nom de variable
	 */
	public String getNomVariable() {
		return ((VariableModifiable)this.getElementProgramme()).getNom();
	}
}

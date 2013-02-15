package jscratch.vue.widgets.modeles;

import nxtim.instruction.Condition;
import nxtim.instruction.Expression;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionWhile;
import nxtim.instruction.Moteur;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.VariableConstante;
import nxtim.instruction.VariableModifiable;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import jscratch.vue.widgets.modeles.zones.ListeDeroulante;
import jscratch.vue.widgets.modeles.zones.Zone;

public class MoteurMarcheWidget extends ModeleWidget{
	private ChampTexte f;
	public MoteurMarcheWidget(){
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 183, 188, 188, 183, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.MOTEURMARCHE);
		message.put(new Point(5, 17), "Moteur");
		message.put(new Point(94, 17), "puissance");

		this.setElementProgramme(new InstructionMoteurMov());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ListeDeroulante<Moteur> l = new ListeDeroulante<Moteur>(Moteur.values());
		l.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add(l);

		int widthChamp = 40;
		f = new ChampTexte(widthChamp, this);

		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(155, 3, widthChamp, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);

		setInstructionMoteur(l.getValeur());
		setInstructionValeur(f.getValeur());

		this.decalageX(11);

		initListeners();
	}
	@Override
	public void applyChangeModele(){
		Widget contentWidget = f.getContentWidget();
		InstructionMoteurMov moteurMarcheIns = ((InstructionMoteurMov) getElementProgramme());

		// On met à jour la condition dans l'elementProgramme si elle existe
		if (contentWidget != null) {
			Expression exp = (Expression) contentWidget.getElementProgramme();
			moteurMarcheIns.setExpression(exp);
		} else {
			moteurMarcheIns.setExpression(new VariableConstante(TypeVariable.INT, f.getValeur()));
		}
	}

	@Override
	public void decalageX(int a) {
		int i;
		for (i = 6; i < 10; i++) {
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
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setInstructionMoteur(((Zone) getLesZonesSaisies().get(0)).getValeur());
			}
		});
		((JComponent) this.getLesZonesSaisies().get(1)).addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setInstructionValeur(((Zone) getLesZonesSaisies().get(1)).getValeur());
			}
		});
	}

	/**
	 * Méthode permettant de définir l'instruction moteur du widget.
	 *
	 * @param nom L'instruction Moteur à définir sur le modèle
	 */
	private void setInstructionMoteur(String nom) {
		((InstructionMoteurMov) getElementProgramme()).setMoteur(Moteur.values()[Integer.parseInt(nom)]);
	}

	/**
	 * Méthode permettant de définir la valeur de l'instruction moteur
	 *
	 * @param nom La valeur de l'instruction moteur
	 */
	private void setInstructionValeur(String nom) {
		((InstructionMoteurMov) getElementProgramme()).setReverse(false);
		((InstructionMoteurMov) getElementProgramme()).setExpression(new VariableConstante(TypeVariable.INT, "", nom));
	}
}

package jscratch.vue.widget.modele;

import jscratch.vue.widget.modele.zones.ChampTexte;
import jscratch.vue.widget.modele.zones.ListeDeroulante;
import jscratch.vue.widget.modele.zones.Zone;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.Moteur;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.VariableConstante;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type MoteurFwd.
 * 
 * @author Bastien Aubry - Vincent Besnard - Quentin Gosselin
 */
public class MoteurMovFwdWidget extends ModeleWidget {
	
	/**
	 * Constructeur du modèle définissant les différents paramètres du MoteurFwd.
	 */
	public MoteurMovFwdWidget() {
		int tX[] = {0, 5, 30, 35, 45, 50, 170, 175, 175, 170, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.MOTEURMOVFWD);

		//this.setMessage("Moteur           avance de");
		message.put(new Point(5, 17), "Moteur");
		message.put(new Point(94, 17), "avance à");
		//recupere le element prog
		this.setElementProgramme(new InstructionMoteurMov());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ListeDeroulante<Moteur> l = new ListeDeroulante<Moteur>(Moteur.values());
		l.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add(l);

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.setBounds(142, 3, 40, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);

		setInstructionMoteur(l.getValeur());
		setInstructionValeur(f.getValeur());

		this.decalageX(11);

		initListeners();
	}//fin constructeur
	
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
package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import vue.widget.modele.zones.Zone;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.VariableConstante;
import nxtim.instruction.TypeVariable;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import modeles.TypeWidget;

/**
 * Cette classe modèlise la forme d'un widget de type Wait.
 *
 * @author Bastien Aubry - Vincent Besnard - Quentin Gosselin
 */
public class WaitWidget extends ModeleWidget {

	/**
	 * Constructeur du modèle définissant les différents paramètres du Wait.
	 */
	public WaitWidget() {
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);

		this.setTailleX();
		this.setTailleY();

		this.setType(TypeWidget.WAIT);

		message.put(new Point(5, 17), "Attendre");
		message.put(new Point(108, 17), "ms");

		this.setElementProgramme(new InstructionAttente());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
		f.setBounds(65, 3, 40, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);

		this.setInstructionValeur(f.getValeur());

		this.decalageX(-5);

		initListeners();
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

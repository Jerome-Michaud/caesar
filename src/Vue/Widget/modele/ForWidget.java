package Vue.Widget.modele;

import Modeles.DicoVars;
import Modeles.TypeWidget;
import Vue.Tools.Variables;
import Vue.Widget.modele.zones.ChampTexte;
import Vue.Widget.modele.zones.ListeDeroulante;
import Vue.Widget.modele.zones.Zone;
import instruction.*;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

public class ForWidget extends ModeleWidget {

	public ForWidget() {
		super();
		int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55, 50, 40, 35, /**/ 10, 5,/**/ 5, 10,/**/ 35, 40, 50, 55,/**/ 130, 135, /**/ 135, 130,/**/ 50, 45, 35, 30,/**/ 5, 0};
		int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/ 25, 30, 30, 25, /**/ 25, 30,/**/ 35, 40,/**/ 40, 45, 45, 40,/**/ 40, 45, /**/ 50, 55,/**/ 55, 60, 60, 55,/**/ 55, 50};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.FOR);
		this.setMessage("For");
		this.setElementProgramme(new InstructionFor());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		this.zonesAccroches.add(Variables.ZONE_ACCROCHE_PAR_DEFAULT);

		ListeDeroulante l;
		ChampTexte f;

		//variable
		l = new ListeDeroulante<Variable>(/*DicoVars.getInstance().getLesvariables()*/);
		l.setBounds(55, 3, 35, 20);
		l.setToolTipText("variable");
		this.getLesZonesSaisies().add(l);

		//valeur depart
		f = new ChampTexte();
		f.setBounds(95, 3, 20, 20);
		f.setText("0");
		f.setToolTipText("valeur de départ");
		this.getLesZonesSaisies().add(f);

		//condition
		l = new ListeDeroulante<Operateur>(Operateur.values());
		l.setBounds(120, 3, 35, 20);
		l.setToolTipText("opérateur");
		this.getLesZonesSaisies().add(l);

		//valeur fin
		f = new ChampTexte();
		f.setBounds(160, 3, 20, 20);
		//f.setText("0");
		f.setToolTipText("valeur de fin");
		this.getLesZonesSaisies().add(f);

		//pas
		f = new ChampTexte();
		f.setBounds(185, 3, 20, 20);
		f.setText("1");
		f.setToolTipText("opération d'incrémentation");
		this.getLesZonesSaisies().add(f);

		this.decalageXout(73);
		
		initListeners();

	}

	public void decalageXout(int a) {
		int i;
		for (i = 6; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		for (i = 22; i < 26; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}

	public void decalageXin(int a) {
		int i;
		for (i = 6; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] - a;
		}
		for (i = 22; i < 26; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] - a;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}

	public void decalageYout(int b, Rectangle r) {
		int i;
		for (i = 16; i < tabY.length; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
		}
		this.setForme(this.getForme());
		this.setTailleY();
	}

	public void decalageYin(int b, Rectangle r) {
		int i;
		for (i = 16; i < tabY.length; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] - b;
		}
		this.setForme(this.getForme());
		this.setTailleY();
	}

	public void initListeners() {
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent arg0) {
				Variable v = DicoVars.getInstance().getLesvariables()[Integer.parseInt(((Zone) getLesZonesSaisies().get(0)).getValeur())];
				String deb = ((Zone) getLesZonesSaisies().get(1)).getValeur();
				Operateur o = Operateur.values()[Integer.parseInt(((Zone) getLesZonesSaisies().get(2)).getValeur())];
				String fin = ((Zone) getLesZonesSaisies().get(3)).getValeur();
				String pas = ((Zone) getLesZonesSaisies().get(4)).getValeur();

				setCondition();
				setIteration();
				setInitialization();
			}
		});
	}

	public void setCondition() {
		((InstructionFor) getElementProgramme()).setCondition(null);
	}

	public void setInitialization() {
		((InstructionFor) getElementProgramme()).setIntialization(null);
	}

	public void setIteration() {
		((InstructionFor) getElementProgramme()).setIteration(null);
	}
}

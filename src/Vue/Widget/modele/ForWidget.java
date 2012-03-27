package Vue.Widget.modele;

import Modeles.DicoVars;
import Modeles.Erreur;
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

		

		//variable
		ListeDeroulante lv = new ListeDeroulante<Variable>(DicoVars.getInstance().getLesvariables());
		lv.setBounds(55, 3, 35, 20);
		lv.setToolTipText("variable");
		this.getLesZonesSaisies().add(lv);

		//valeur depart
		ChampTexte fd = new ChampTexte();
		fd.setBounds(95, 3, 20, 20);
		fd.setText("0");
		fd.setToolTipText("valeur de départ");
		this.getLesZonesSaisies().add(fd);

		//condition
		ListeDeroulante lo = new ListeDeroulante<Operateur>(Operateur.comparaisonA());
		lo.setBounds(120, 3, 40, 20);
		lo.setToolTipText("opérateur");
		this.getLesZonesSaisies().add(lo);

		//valeur fin
		ChampTexte ff = new ChampTexte();
		ff.setBounds(165, 3, 20, 20);
		ff.setText("5");
		ff.setToolTipText("valeur de fin");
		this.getLesZonesSaisies().add(ff);

		//pas
		ChampTexte fp = new ChampTexte();
		fp.setBounds(190, 3, 20, 20);
		fp.setText("1");
		fp.setToolTipText("opération d'incrémentation");
		this.getLesZonesSaisies().add(fp);

		this.decalageXout(78);
		
		setCondition(DicoVars.getInstance().getLesvariables()[Integer.parseInt(lv.getValeur())], Operateur.comparaisonA()[Integer.parseInt(lo.getValeur())], ff.getValeur());
		setIteration(DicoVars.getInstance().getLesvariables()[Integer.parseInt(lv.getValeur())], fp.getValeur());
		setInitialization(DicoVars.getInstance().getLesvariables()[Integer.parseInt(lv.getValeur())], fd.getValeur());
		
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
		for (Zone z : this.getLesZonesSaisies()) {
			((JComponent) z).addFocusListener(new FocusAdapter() {

				@Override
				public void focusLost(FocusEvent arg0) {
					Variable v = DicoVars.getInstance().getLesvariables()[Integer.parseInt(((Zone) getLesZonesSaisies().get(0)).getValeur())];
					String deb = ((Zone) getLesZonesSaisies().get(1)).getValeur();
					Operateur o = Operateur.comparaisonA()[Integer.parseInt(((Zone) getLesZonesSaisies().get(2)).getValeur())];
					String fin = ((Zone) getLesZonesSaisies().get(3)).getValeur();
					String pas = ((Zone) getLesZonesSaisies().get(4)).getValeur();

					setCondition(v, o, fin);
					setIteration(v, pas);
					setInitialization(v, deb);
				}
			});
		}
		
	}

	public void setCondition(Variable v, Operateur o, String fin) {
		Condition cond = null;
		try {
			cond = new Condition(o, v, new VariableConstante(TypeVariable.INT, "", fin));
		} catch (Exception e) {
			Erreur.afficher(e);
		}
		((InstructionFor) getElementProgramme()).setCondition(cond);
	}

	public void setInitialization(Variable v, String deb) {
		Affectation aff = new Affectation(false);
		aff.setMembreGauche(v);
		aff.setMembreDroit(new VariableConstante(TypeVariable.INT, "", deb));
		((InstructionFor) getElementProgramme()).setIntialization(aff);
	}

	public void setIteration(Variable v, String pas) {
		Affectation aff = new Affectation(false);
		aff.setMembreGauche(v);
		Operation op = null;
		try {
			op = new Operation(Operateur.ADDITION, v, new VariableConstante(TypeVariable.INT, "", pas));
		} catch (Exception e) {
			Erreur.afficher(e);
		}
		aff.setMembreDroit(op);
		((InstructionFor) getElementProgramme()).setIteration(aff);
	}
}

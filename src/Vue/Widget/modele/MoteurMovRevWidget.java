package Vue.Widget.modele;

import Modeles.TypeWidget;
import Vue.Widget.modele.zones.ChampTexte;
import Vue.Widget.modele.zones.ListeDeroulante;
import Vue.Widget.modele.zones.Zone;
import instruction.InstructionMoteurMov;
import instruction.Moteur;
import instruction.TypeVariable;
import instruction.VariableModifiable;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

public class MoteurMovRevWidget extends ModeleWidget {

		
	
	public MoteurMovRevWidget() {
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.MOTEURMOVREV);
		this.setMessage("MoteurMovRev");
		this.setElementProgramme(new InstructionMoteurMov());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ListeDeroulante<Moteur> l = new ListeDeroulante<Moteur>(Moteur.values());
		l.setBounds(50, 3, 30, 20);
		this.getLesZonesSaisies().add(l);
		
		ChampTexte f = new ChampTexte();
		f.setBounds(110, 3, 20, 20);
		f.setText("0");
		this.getLesZonesSaisies().add(f);
		
		initListeners();
	}

	@Override
	public void decalageXout(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decalageXin(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decalageYout(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decalageYin(int x) {
		// TODO Auto-generated method stub
		
	}
	
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
	
	private void setInstructionMoteur(String nom) {
		((InstructionMoteurMov) getElementProgramme()).setMoteur(Moteur.values()[Integer.parseInt(nom)]);
	}

	private void setInstructionValeur(String nom) {
		((InstructionMoteurMov) getElementProgramme()).setReverse(true);
		((InstructionMoteurMov) getElementProgramme()).setExpression(new VariableModifiable(TypeVariable.INT, "", nom));
	}
}

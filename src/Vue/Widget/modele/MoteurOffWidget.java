package Vue.Widget.modele;

import Modeles.TypeWidget;
import Vue.Widget.modele.zones.ListeDeroulante;
import Vue.Widget.modele.zones.Zone;
import instruction.InstructionDoWhile;
import instruction.InstructionMoteurMov;
import instruction.InstructionMoteurOff;
import instruction.Moteur;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

public class MoteurOffWidget extends ModeleWidget {

	
	
	public MoteurOffWidget() {
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};
		
		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.MOTEUROFF);
		this.setMessage("Moteur off");
		this.setElementProgramme(new InstructionMoteurOff());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ListeDeroulante<Moteur> l = new ListeDeroulante<Moteur>(Moteur.values());
		l.setBounds(50, 3, 35, 20);
		this.getLesZonesSaisies().add(l);
		
		setInstructionMoteur(l.getValeur());
		
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
	}
	
	private void setInstructionMoteur(String nom) {
		((InstructionMoteurOff) getElementProgramme()).setMoteur(Moteur.values()[Integer.parseInt(nom)]);
	}
}

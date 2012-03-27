package Vue.Widget.modele;

import Modeles.TypeWidget;
import Vue.Widget.modele.zones.ChampTexte;
import Vue.Widget.modele.zones.Zone;
import Vue.Tools.Variables;
import instruction.InstructionTache;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.Serializable;
import javax.swing.JComponent;

public class TacheWidget extends ModeleWidget implements Serializable{
	private Zone temp;
	
    public TacheWidget(){
        super();

        int[] tX = {0, 5,/**/ /**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,/**/135,130,/**/5,0};
        int[] tY = {5, 0,/**/ /**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,/**/50,55,/**/55,50};

        this.setTabX(tX);
        this.setTabY(tY);
        this.setType(TypeWidget.TACHE);
        this.setMessage("Tâche");
		this.setElementProgramme(new InstructionTache());
        this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
        this.attachableBas = false;
        this.attachableHaut = false;
		
		ChampTexte f = new ChampTexte();
		f.setBounds(50, 3, 80, 20);
		f.setText("main");
		this.getLesZonesSaisies().add(f);
		
		initListeners();

		this.zonesAccroches.add(Variables.ZONE_ACCROCHE_PAR_DEFAULT);
    }

    @Override
    public void decalageXout(int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void decalageXin(int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void decalageYout(int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void decalageYin(int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	@Override
	public void initListeners() {
		for (Zone z : this.getLesZonesSaisies()) {
			this.temp = z;
			((JComponent)z).addFocusListener(new FocusAdapter() {

				@Override
				public void focusLost(FocusEvent arg0) {
					setInstruction(temp.getValeur());
				}
				
			});
		}
	}
	
	private void setInstruction(String nom) {
		((InstructionTache)getElementProgramme()).setNom(nom);
	}
}

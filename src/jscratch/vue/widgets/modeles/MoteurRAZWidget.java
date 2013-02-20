package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComponent;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import jscratch.vue.widgets.modeles.zones.ListeDeroulante;
import jscratch.vue.widgets.modeles.zones.Zone;
import nxtim.instruction.InstructionRAZRotationMoteur;
import nxtim.instruction.Moteur;

/**
 * @since 1.0
 * @version 1.0
 */
public class MoteurRAZWidget extends ModeleWidget {

	private ListeDeroulante<Moteur> l;
	
	public MoteurRAZWidget(){
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 108, 113, 113, 108, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.MOTEURRAZ);
		message.put(new Point(5, 17), "RAZ Moteur");

		this.setElementProgramme(new InstructionRAZRotationMoteur());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		l = new ListeDeroulante<Moteur>(Moteur.values(), this);
		l.setBounds(75, 3, 35, 20);
		this.getLesZonesSaisies().add(l);

		initListeners();
	}

	@Override
	public void initListeners() {
		l.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				((InstructionRAZRotationMoteur)getElementProgramme()).setMoteur((Moteur)l.getSelectedItem());
			}
		});
	}	
	
	@Override
	public void applyChangeModele(){
		
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
}
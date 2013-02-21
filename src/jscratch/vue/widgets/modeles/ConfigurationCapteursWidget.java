package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import jscratch.vue.widgets.modeles.zones.ListeDeroulante;
import nxtim.instruction.Capteur;
import nxtim.instruction.CapteurSlot;
import nxtim.instruction.InstructionConfigCapteurs;

/**
 * @since 1.0
 * @version 1.0
 */
public class ConfigurationCapteursWidget extends ModeleWidget {

	private ListeDeroulante<Capteur> l1, l2, l3, l4;
	
	/**
	 * Constructeur par défaut de <code>CapteursConfigurationWidget</code>.
	 */
	public ConfigurationCapteursWidget() {
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 380, 385, 385, 380, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.CAPTEURCONFIG);
		message.put(new Point(5, 17), "Configuration");

		InstructionConfigCapteurs ins = new InstructionConfigCapteurs();
		ins.setCapteurAuSlot(CapteurSlot.A, Capteur.NONE);
		ins.setCapteurAuSlot(CapteurSlot.B, Capteur.NONE);
		ins.setCapteurAuSlot(CapteurSlot.C, Capteur.NONE);
		ins.setCapteurAuSlot(CapteurSlot.D, Capteur.NONE);
		
		this.setElementProgramme(ins);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		int widthChamp = 70;
		l1 = new ListeDeroulante<Capteur>(Capteur.values(), this);
		l1.setBounds(85, 3, widthChamp, 20);
		this.getLesZonesSaisies().add(l1);
		
		l2 = new ListeDeroulante<Capteur>(Capteur.values(), this);
		l2.setBounds(160, 3, widthChamp, 20);
		this.getLesZonesSaisies().add(l2);
		
		l3 = new ListeDeroulante<Capteur>(Capteur.values(), this);
		l3.setBounds(235, 3, widthChamp, 20);
		this.getLesZonesSaisies().add(l3);
		
		l4 = new ListeDeroulante<Capteur>(Capteur.values(), this);
		l4.setBounds(310, 3, widthChamp, 20);
		this.getLesZonesSaisies().add(l4);
		
		initListeners();
	}

	@Override
	public void initListeners() {
		l1.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					InstructionConfigCapteurs ins = (InstructionConfigCapteurs)getElementProgramme();
					ins.setCapteurAuSlot(CapteurSlot.A, (Capteur)l1.getSelectedItem());
				}
			});
		l2.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					InstructionConfigCapteurs ins = (InstructionConfigCapteurs)getElementProgramme();
					ins.setCapteurAuSlot(CapteurSlot.B, (Capteur)l2.getSelectedItem());
				}
			});
		
		l3.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					InstructionConfigCapteurs ins = (InstructionConfigCapteurs)getElementProgramme();
					ins.setCapteurAuSlot(CapteurSlot.C, (Capteur)l3.getSelectedItem());
				}
			});
		
		l4.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					InstructionConfigCapteurs ins = (InstructionConfigCapteurs)getElementProgramme();
					ins.setCapteurAuSlot(CapteurSlot.D, (Capteur)l4.getSelectedItem());
				}
			});
	}
}

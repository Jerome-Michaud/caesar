package jscratch.vue.widgets.modeles;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

import jscratch.helpers.FontHelper;
import jscratch.vue.widgets.modeles.zones.ListeDeroulante;
import jscratch.vue.widgets.modeles.zones.Zone;
import nxtim.instruction.CapteurSlot;
import nxtim.instruction.ValeurCapteur;

/**
 *
 * @author Adrien DUROY
 */
public class CapteurWidget extends ModeleWidget {
	private int largeur;
	private final int LARG_EXTREMITE;
	
	public CapteurWidget() {
		super();
		
		this.setElementProgramme(new ValeurCapteur(CapteurSlot.A));
		
		attachableInterne = true;
		attachableHaut = false;
		attachableBas = false;
		imbricable = false;
		
		final String label = "Capteur";
		Font font = FontHelper.getWidgetFont();
		FontMetrics metrics = new FontMetrics(font) {};
		Rectangle2D sizesText = metrics.getStringBounds(label, null);
		
		message.put(new Point(5, 15), label);
		
		
		ListeDeroulante<CapteurSlot> l = new ListeDeroulante<CapteurSlot>(CapteurSlot.values(), this);
		l.setBounds((int) sizesText.getWidth() + 10, 3, 45, 15);
		this.getLesZonesSaisies().add(l);
		
		LARG_EXTREMITE = 5;
		largeur = (int) sizesText.getWidth() + LARG_EXTREMITE + l.getWidth();
		int tX[] = {0, 5, this.LARG_EXTREMITE + largeur, largeur + 10, largeur + 10, this.LARG_EXTREMITE + largeur, 5, 0};
		int tY[] = {5, 0, 0, 5, 15, 20, 20, 15};
		this.setTabX(tX);
        this.setTabY(tY);
		setType(TypeModeleWidget.CAPTEUR);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		
		initListeners();
	}
	
	@Override
	public void initListeners() {
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent arg0) {
				setSlot(((Zone) getLesZonesSaisies().get(0)).getValeur());
			}
		});
	}
	
	private void setSlot(String nameSlot) {
		System.out.println("setSlot " + nameSlot);
		((ValeurCapteur) getElementProgramme()).setSlot(CapteurSlot.values()[Integer.parseInt(nameSlot)]);
	}
}

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
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.Affectation;
import nxtim.instruction.TempsCourant;
import nxtim.instruction.VariableModifiable;

/**
 * @since 1.0
 * @version 1.0
 */
public class TempsCourantWidget extends ModeleWidget {
	private int largeur;
	
	private final int LARG_EXTREMITE;
	/**
	 * Constructeur du modèle TempsCourantWidget.
	 */
	public TempsCourantWidget(){
		super();
		
		attachableInterne = true;
		attachableHaut = false;
		attachableBas = false;
		imbricable = false;
		
		message.put(new Point(5, 17), "Temps Courant");
		Font font = FontHelper.getWidgetFont();
		FontMetrics metrics = new FontMetrics(font) {};
		String l = "";
		for (String s : message.values()) {
			l += s;
		}
		Rectangle2D bounds = metrics.getStringBounds(l, null);
		
		this.LARG_EXTREMITE = 5;
		this.largeur = (int) bounds.getWidth();
				
		this.setElementProgramme(new TempsCourant());
		int tX[] = {0, 5, this.LARG_EXTREMITE + largeur, largeur + 10, largeur + 10, this.LARG_EXTREMITE + largeur, 5, 0};
		int tY[] = {5, 0, 0, 5, 15, 20, 20, 15};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.TEMPSCOURANT);

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
	}
}

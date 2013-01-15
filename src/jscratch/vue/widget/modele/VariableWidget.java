package jscratch.vue.widget.modele;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import nxtim.instruction.VariableModifiable;

/**
 *
 * @author zubair
 */
public class VariableWidget extends ModeleWidget {

	/**
	 * Constructeur du modèle définissant les différents paramètres du Variable.
	 */
	private VariableWidget() { }
	
	public VariableWidget(VariableModifiable variableModifiable) {
		int tX[] = {0, 3, 7, 10, 10, 7, 3, 0};
		int tY[] = {3, 0, 0,  3,  11, 14, 14,10};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.VARIABLE);

		message.put(new Point(7, 11), variableModifiable.getNom());
		this.setElementProgramme(variableModifiable);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		
        this.attachableBas = false;
        this.attachableHaut = false;
        this.imbricable = false;
        this.attachableInterne = true;

		Font font = new Font("TimesRoman ", Font.PLAIN, 12);
		FontMetrics metrics = new FontMetrics(font){};  
		Rectangle2D bounds = metrics.getStringBounds(variableModifiable.getNom(), null);  
		
		this.decalageX((int) bounds.getWidth()+2);

		initListeners();
	}

	@Override
	public void decalageX(int a) {
		int i;
		for (i = 2; i < this.getTabX().length-2; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a ;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}
	
	@Override
	public void initListeners() { }

	/**
	 * 
	 * @return nom de variable
	 */
	public String getNomVariable() {
		return ((VariableModifiable)this.getElementProgramme()).getNom();
	}

}

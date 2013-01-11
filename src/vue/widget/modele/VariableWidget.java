package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import instruction.VariableModifiable;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import modeles.TypeWidget;

/**
 *
 * @author zubair
 */
public class VariableWidget extends ModeleWidget {

	public VariableWidget(VariableModifiable variableModifiable) {
		super();

		int tX[] = {0, 3, 7, 10, 10, 7, 3, 0};
		int tY[] = {3, 0, 0, 3, 11, 14, 14, 10};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.VARIABLE);

		message.put(new Point(7, 11), variableModifiable.getNom());
		this.setElementProgramme(variableModifiable);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte f = new ChampTexte();
		f.setBounds(65, variableModifiable.getNom().length(), 40, 20);
		f.setToolTipText("0");
		this.getLesZonesSaisies().add(f);

		Font font = new Font("TimesRoman ", Font.PLAIN, 12);
		FontMetrics metrics = new FontMetrics(font) {
		};
		Rectangle2D bounds = metrics.getStringBounds(variableModifiable.getNom(), null);

		this.decalageX((int) bounds.getWidth() + 2);

		initListeners();
	}

	@Override
	public void decalageX(int a) {
		int i;
		for (i = 2; i < this.getTabX().length - 2; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}

	@Override
	public void decalageY(int b, Rectangle r) {
	}

	@Override
	public void initListeners() {
	}

	/**
	 * Retourne le nom de la variable.
	 *
	 * @return nom de variable
	 */
	public String getNomVariable() {
		return ((VariableModifiable) this.getElementProgramme()).getNom();
	}
}

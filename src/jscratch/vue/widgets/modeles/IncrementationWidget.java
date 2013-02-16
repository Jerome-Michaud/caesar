package jscratch.vue.widgets.modeles;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import nxtim.instruction.InstructionIncrementation;
import nxtim.instruction.Operateur;
import nxtim.instruction.Variable;

/**
 * @since 1.0
 * @version 1.0
 */
public class IncrementationWidget extends ModeleWidget {

	private int largeur;

	private final int LARG_EXTREMITE;
	
	/**
	 * Default constructor of <code>IncrementationPlusWidget</code>.
	 */
	public IncrementationWidget(Operateur op) {
		InstructionIncrementation ins;
		if (op == Operateur.INC_PLUS){
			ins = new InstructionIncrementation((Variable) null, true);
		}
		else {
			ins = new InstructionIncrementation((Variable) null, false);
		}
		this.setElementProgramme(ins);
		this.attachableBas = false;
		this.attachableHaut = false;
		this.imbricable = false;
		this.attachableInterne = true;
		this.setType(TypeModeleWidget.EXPRESSION_INC);

		//graphisme
		this.LARG_EXTREMITE = 5;

		message.put(new Point(LARG_EXTREMITE, 15), op.toString());

		Font font = new Font("TimesRoman ", Font.PLAIN, 12);
		FontMetrics metrics = new FontMetrics(font) {
		};
		Rectangle2D bounds = metrics.getStringBounds(op.toString(), null);

		this.largeur = (int) bounds.getWidth();
		int tabX[] = {0, 5, this.LARG_EXTREMITE + largeur, largeur + 10, largeur + 10, this.LARG_EXTREMITE + largeur, 5, 0};
		int tabY[] = {5, 0, 0, 5, 15, 20, 20, 15};

		this.setTabX(tabX);
		this.setTabY(tabY);

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		this.setTailleX();
		this.setTailleY();

		initListeners();
	}

	@Override
	public void initListeners() { }
}
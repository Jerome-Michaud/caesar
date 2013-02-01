package jscratch.vue.widgets.modeles;


import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import jscratch.vue.widgets.modeles.zones.ChampTexte;

import nxtim.instruction.Operateur;
import nxtim.instruction.Operation;
import nxtim.instruction.Variable;


/**
 * Classe heritant de ModeleWidget et implementant Seriliazable modelisant la
 * forme d'un widget de type Expression arethmetique.
 * 
 * @since 1.0
 * @version 1.0
 */
public class ExpressionArithmeticWidget extends ModeleWidget {
	private int largeur;
	private final int LARG_EXTREMITE;
	/**
	 * Constructeur du modele definissant les differents parametres du ExpressionSum .
	 */
	public ExpressionArithmeticWidget(Operateur op) {

		this.setElementProgramme(new Operation(op, (Variable)null, (Variable)null));
		this.attachableBas = false;
		this.attachableHaut = false;
		this.imbricable = false;
		this.attachableInterne = true;
		this.setType(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);

		//graphisme
		this.LARG_EXTREMITE = 5;
		final int LARG_CHAMP = 14;


		ChampTexte l = new ChampTexte();
		l.setBounds(10, 3, LARG_CHAMP, 14);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);

		message.put(new Point(29, 15), op.toString());

		Font font = new Font("TimesRoman ", Font.PLAIN, 12);
		FontMetrics metrics = new FontMetrics(font){};  
		Rectangle2D bounds = metrics.getStringBounds(op.toString(), null);
		this.getLesZonesSaisies().add(l);

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);

		//f.setBounds(40, 3, 14, 14);
		f.setBounds(29 + (int) bounds.getWidth() + 5, 3, LARG_CHAMP, 14);
		this.getLesZonesSaisies().add(f);
		/* int tabX[] = {0, 5, 62, 67, 67, 62,  5, 0};
		int tabY[] = {5, 0, 0, 5, 15, 20,20, 15};
		 */

		this.largeur = LARG_CHAMP * 2 + 24 + (int) bounds.getWidth();
		int tabX[] = {0, 5, this.LARG_EXTREMITE  + largeur, largeur+10, largeur+10, this.LARG_EXTREMITE  + largeur, 5, 0};
		int tabY[] = {5, 0, 0, 5, 15, 20,20, 15};

		this.setTabX(tabX);
		this.setTabY(tabY);

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		this.setTailleX();
		this.setTailleY();

		initListeners();
	}

	public void initListeners() { }

	@Override
	public void decalageX(int x) {
		int i;
		for (i = 2; i < this.getTabX().length-2; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + x ;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}
}

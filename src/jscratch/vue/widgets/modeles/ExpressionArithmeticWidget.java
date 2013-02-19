package jscratch.vue.widgets.modeles;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import jscratch.helpers.FontHelper;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.Expression;
import nxtim.instruction.Operateur;
import nxtim.instruction.Operation;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableConstante;

/**
 * Classe heritant de ModeleWidget et implementant Seriliazable modelisant la
 * forme d'un widget de type Expression arithmetique.
 *
 * @since 1.0
 * @version 1.0
 */
public class ExpressionArithmeticWidget extends ModeleWidget {

	private int largeur;
	
	private final int LARG_EXTREMITE;
	
	private ChampTexte f, l;
	
	/**
	 * Constructeur du modele definissant les differents parametres du ExpressionSum .
	 */
	public ExpressionArithmeticWidget(Operateur op) {

		this.setElementProgramme(new Operation(op, (Variable) null, (Variable) null));
		this.attachableBas = false;
		this.attachableHaut = false;
		this.imbricable = false;
		this.attachableInterne = true;
		this.setType(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);

		//graphisme
		this.LARG_EXTREMITE = 5;
		final int LARG_CHAMP = 14;


		l = new ChampTexte(LARG_CHAMP, this);
		l.setBounds(10, 3, LARG_CHAMP, 14);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.TEMPSCOURANT);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.CAPTEUR);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		this.getLesZonesSaisies().add(l);

		message.put(new Point(29, 15), op.toString());

		Font font = FontHelper.getWidgetFont();
		FontMetrics metrics = new FontMetrics(font) {
		};
		Rectangle2D bounds = metrics.getStringBounds(op.toString(), null);

		f = new ChampTexte(LARG_CHAMP, this);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.TEMPSCOURANT);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.CAPTEUR);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(29 + (int) bounds.getWidth() + 5, 3, LARG_CHAMP, 14);
		this.getLesZonesSaisies().add(f);

		this.largeur = LARG_CHAMP * 2 + 24 + (int) bounds.getWidth();
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
	public void applyChangeModele() {
		Operation expArith = ((Operation) getElementProgramme());
		
		Widget widgetG = l.getContentWidget();
		if (widgetG != null) {
			Expression varMemGauche = (Expression) widgetG.getElementProgramme();
			expArith.setMembreGauche(varMemGauche);
		} else {
			expArith.setMembreGauche(new VariableConstante(TypeVariable.INT, l.getValeur()));
		}
		
		Widget widgetD = f.getContentWidget();
		if (widgetD != null) {
			Expression varMemDroite = (Expression) widgetD.getElementProgramme();
			expArith.setMembreDroit(varMemDroite);
		} else {
			expArith.setMembreDroit(new VariableConstante(TypeVariable.INT, f.getValeur()));
		}
	}

	@Override
	public void decalageX(int x) {
		int i;
		for (i = 2; i < this.getTabX().length - 2; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + x;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}
}

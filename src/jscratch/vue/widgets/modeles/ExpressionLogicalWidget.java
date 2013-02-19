package jscratch.vue.widgets.modeles;

import jscratch.helpers.FontHelper;
import jscratch.vue.widgets.modeles.zones.ChampTexte;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import jscratch.vue.widgets.Widget;

import nxtim.instruction.Condition;
import nxtim.instruction.Expression;
import nxtim.instruction.Operateur;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.VariableConstante;

/**
 * Classe heritant de ModeleWidget et implementant Seriliazable modelisant la
 * forme d'un widget de type Expression logique.
 * 
 * @since 1.0
 * @version 1.0
 */
public class ExpressionLogicalWidget extends ModeleWidget {
	
	private int largeur;
	
	private final int LARG_EXTREMITE;
	
	private ChampTexte f, l;
	
	/**
	 * Constructeur du modele definissant les differents parametres du ExpressionSum .
	 */
	public ExpressionLogicalWidget(Operateur op) {
		//modèle
		this.setElementProgramme(new Condition(op));

		//propriétés d'attachement du widget
		this.attachableBas = false;
		this.attachableHaut = false;
		this.imbricable = false;
		this.attachableInterne = true;
		this.setType(TypeModeleWidget.EXPRESSION_LOGIQUE);

		//graphisme
		this.LARG_EXTREMITE = 10;
		final int LARG_CHAMP = 14;

		l = new ChampTexte(LARG_CHAMP, this);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.TEMPSCOURANT);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.CAPTEUR);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		l.setBounds(this.LARG_EXTREMITE, 3, LARG_CHAMP, 14);
		this.getLesZonesSaisies().add(l);

		message.put(new Point(29, 15), op.toString());

		Font font = FontHelper.getWidgetFont();
		FontMetrics metrics = new FontMetrics(font){};  
		Rectangle2D bounds = metrics.getStringBounds(op.toString(), null);

		f = new ChampTexte(LARG_CHAMP, this);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.TEMPSCOURANT);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.CAPTEUR);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(29 + (int) bounds.getWidth() + 5, 3, LARG_CHAMP, 14);
		this.getLesZonesSaisies().add(f);

		this.largeur = LARG_CHAMP * 2 + 10 + (int) bounds.getWidth();
		int tabX[] = {0, 10, 10 + largeur, largeur + this.LARG_EXTREMITE * 2, this.LARG_EXTREMITE + largeur, 10};
		int tabY[] = {10, 0, 0, 10, 20, 20};		

		this.setTabX(tabX);
		this.setTabY(tabY);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		// Recalcule la largeur du widget.
		this.setTailleX();
		this.setTailleY();
	}

	@Override
	public void applyChangeModele(){
		Condition expLog = ((Condition) getElementProgramme());

		Widget widgetG = l.getContentWidget();
		if (widgetG != null) {
			Expression varMemGauche = (Expression) widgetG.getElementProgramme();
			expLog.setMembreGauche(varMemGauche);
		} else {
			expLog.setMembreGauche(new VariableConstante(TypeVariable.INT, l.getValeur()));
		}
		Widget widgetD = f.getContentWidget();
		if (widgetD != null) {
			Expression varMemDroite = (Expression) widgetD.getElementProgramme();
			expLog.setMembreDroit(varMemDroite);
		} else {
			expLog.setMembreDroit(new VariableConstante(TypeVariable.INT, f.getValeur()));
		}
	}
	
	@Override
	public void decalageX(int x) {
		for (int i = 2; i < this.getTabX().length-1; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + x ;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}
}

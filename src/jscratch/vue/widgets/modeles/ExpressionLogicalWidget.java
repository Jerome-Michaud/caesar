package jscratch.vue.widgets.modeles;

import jscratch.vue.widgets.modeles.zones.ChampTexte;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import nxtim.instruction.Condition;
import nxtim.instruction.Operateur;
import nxtim.instruction.Operation;
import nxtim.instruction.VariableModifiable;

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

		l = new ChampTexte(LARG_CHAMP);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		l.setBounds(this.LARG_EXTREMITE, 3, LARG_CHAMP, 14);

		message.put(new Point(29, 15), op.toString());


		Font font = new Font("TimesRoman ", Font.PLAIN, 12);
		FontMetrics metrics = new FontMetrics(font){};  
		Rectangle2D bounds = metrics.getStringBounds(op.toString(), null);


		this.getLesZonesSaisies().add(l);

		f = new ChampTexte(LARG_CHAMP);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(29 + (int) bounds.getWidth() + 5, 3, LARG_CHAMP, 14);
		//f.setBounds(40, expressionModifiable.getnom().length(), 14, 14);
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

		Condition expLogique = ((Condition) getElementProgramme());

		VariableModifiable varMemGauche = (VariableModifiable)l.getContentWidget().getElementProgramme();
		expLogique.setMembreGauche(varMemGauche);
		
		VariableModifiable varMemDroite = (VariableModifiable)f.getContentWidget().getElementProgramme();
		expLogique.setMembreGauche(varMemDroite);
		

	}
	@Override
	public void decalageX(int x) {
		int i;
		for (i = 2; i < this.getTabX().length-1; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + x ;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}

	public void initListeners() { }
}

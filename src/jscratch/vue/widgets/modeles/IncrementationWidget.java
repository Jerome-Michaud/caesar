package jscratch.vue.widgets.modeles;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import jscratch.helpers.FontHelper;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.InstructionIncrementation;
import nxtim.instruction.Operateur;
import nxtim.instruction.VariableModifiable;

/**
 * @since 1.0
 * @version 1.0
 */
public class IncrementationWidget extends ModeleWidget {

	private int largeur;

	private final int LARG_EXTREMITE;
	private ChampTexte chmpVar;
	
	/**
	 * Créé un widget d'incrémentation.
	 * 
	 * @param op l'opérateur d'incrémentation ou de décrémentation.
	 * @param isAvant <code>true</code> indique que l'opérateur est avant la variable, <code>false</code> qu'il est après.
	 */
	public IncrementationWidget(Operateur op, final boolean isAvant) {
		InstructionIncrementation ins;
		if (op == Operateur.INCREMENTATION_PLUS){
			ins = new InstructionIncrementation(null, true, isAvant);
		}
		else {
			ins = new InstructionIncrementation(null, false, isAvant);
		}
		this.setElementProgramme(ins);
		this.attachableBas = false;
		this.attachableHaut = false;
		this.imbricable = false;
		this.attachableInterne = true;
		this.setType(TypeModeleWidget.EXPRESSION_INC);

		//graphisme
		this.LARG_EXTREMITE = 5;
		final int widthChmp = 14;
		chmpVar = new ChampTexte(widthChmp, this);
		chmpVar.supprimerTexte();
		chmpVar.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		
		Font font = FontHelper.getWidgetFont();
		FontMetrics metrics = new FontMetrics(font) {
		};
		Rectangle2D bounds = metrics.getStringBounds(op.toString(), null);
		if(isAvant) {
			message.put(new Point(LARG_EXTREMITE, 3), op.toString());
			chmpVar.setBounds(LARG_EXTREMITE + (int) bounds.getWidth() + 5, 15, widthChmp, 14);
		} else {
			message.put(new Point(LARG_EXTREMITE + widthChmp + 5, 15), op.toString());
			chmpVar.setBounds(LARG_EXTREMITE, 3, widthChmp, 14);
		}
		this.getLesZonesSaisies().add(chmpVar);
		
		this.largeur = (int) bounds.getWidth() + 5 + widthChmp;
		int tabX[] = {0, 5, LARG_EXTREMITE + largeur, largeur + 10, largeur + 10, this.LARG_EXTREMITE + largeur, 5, 0};
		int tabY[] = {5, 0, 0, 5, 15, 20, 20, 15};

		this.setTabX(tabX);
		this.setTabY(tabY);
		this.setTailleX();
		this.setTailleY();

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		initListeners();
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
	
	@Override
	public void applyChangeModele() {
		InstructionIncrementation exp = ((InstructionIncrementation) getElementProgramme());
		
		Widget widgetVar = chmpVar.getContentWidget();
		if (widgetVar != null) {
			VariableModifiable variable = (VariableModifiable) widgetVar.getElementProgramme();
			exp.setVariable(variable);
		} else {
			exp.setVariable(null);
		}
	}
}
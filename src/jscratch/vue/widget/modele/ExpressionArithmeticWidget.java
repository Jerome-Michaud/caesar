package jscratch.vue.widget.modele;

import jscratch.vue.widget.modele.zones.ChampTexte;

import java.awt.Point;
import java.awt.Polygon;
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

	/**
	 * Constructeur du modele definissant les differents parametres du ExpressionSum .
	 */
	public ExpressionArithmeticWidget(Operateur op) {
		int tabX[] = {0, 5, 62, 67, 67, 62,  5, 0};
		int tabY[] = {5, 0, 0, 5, 15, 20,20, 15};

		this.setTabX(tabX);
		this.setTabY(tabY);

		this.attachableBas = false;
        this.attachableHaut = false;
        this.imbricable = false;
        this.attachableInterne = true;
		
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);

		message.put(new Point(30, 17), op.toString());

		this.setElementProgramme(new Operation(op, (Variable)null, (Variable)null));
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte l = new ChampTexte();
		l.setBounds(10, 3, 14, 14);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);

		this.getLesZonesSaisies().add(l);

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.setBounds(40, 3, 14, 14);
		this.getLesZonesSaisies().add(f);
	}

	@Override
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
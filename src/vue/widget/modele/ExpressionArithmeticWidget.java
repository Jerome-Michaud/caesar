package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import instruction.Operateur;
import instruction.Operation;
import instruction.Variable;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import modeles.TypeWidget;

/**
 * Classe heritant de ModeleWidget et implementant Seriliazable modelisant la
 * forme d'un widget de type Expression arethmetique.
 *
 * @author CHOUKET Houda
 */
public class ExpressionArithmeticWidget extends ModeleWidget {

	/**
	 * Constructeur du modele definissant les differents parametres du
	 * ExpressionSum .
	 */
	public ExpressionArithmeticWidget(Operateur op) {
		super();

		int tabX[] = {0, 5, 62, 67, 67, 62, 5, 0};
		int tabY[] = {7, 0, 0, 7, 20, 25, 25, 20};

		this.setTabX(tabX);
		this.setTabY(tabY);

		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.EXPRESSION);

		message.put(new Point(30, 17), op.toString());

		this.setElementProgramme(new Operation(op, (Variable) null, (Variable) null));
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte l = new ChampTexte();
		l.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
		l.setBounds(10, 3, 20, 20);

		this.getLesZonesSaisies().add(l);

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
		f.setBounds(40, 3, 20, 20);
		this.getLesZonesSaisies().add(f);

		this.decalageX(-5);

		initListeners();
	}

	@Override
	public void decalageX(int x) {
		/*int i;
		 for (i = 6; i < 10; i++) {
		 this.getForme().xpoints[i] = this.getForme().xpoints[i] + x;
		 }
		 this.setForme(this.getForme());
		 this.setTailleX();*/
	}

	@Override
	public void decalageY(int b, Rectangle r) {
		/*int i;
		 for (i = 8; i < 16; i++) {
		 this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
		 }
		 this.setForme(this.getForme());
		 this.setTailleY();*/
	}

	@Override
	public void initListeners() {
	}
}

package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import instruction.Condition;
import instruction.Operateur;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import modeles.TypeWidget;

/**
 * Classe heritant de ModeleWidget et implementant Seriliazable modelisant la
 * forme d'un widget de type Expression logique.
 *
 * @author CHOUKET Houda
 */
public class ExpressionLogicalWidget extends ModeleWidget {

	/**
	 * Constructeur du modele definissant les differents parametres du ExpressionSum .
	 */
	public ExpressionLogicalWidget(Operateur op) {
		super();

		/*int tabX[] = {0, 5, 62, 67, 67, 62,  5, 0};
		int tabY[] = {7, 0, 0, 7, 20, 25,25, 20};
		 */

		int tabX[] = {0, 10, 57, 67, 57, 10};
		int tabY[] = {10, 0, 0, 10, 20, 20};

		this.setTabX(tabX);
		this.setTabY(tabY);

		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.EXPRESSION_LOGIQUE);

		this.setElementProgramme(new Condition(op));
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte l = new ChampTexte();
		l.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
		l.ajouterTypeWidgetAccepte(TypeWidget.EXPRESSION_ARITHMETIQUE);
		l.setBounds(10, 3, 14, 14);


		message.put(new Point((int) (l.getLocation().getX()+ l.getWidth()), 17), op.toString());
		
		this.getLesZonesSaisies().add(l);

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);

		f.ajouterTypeWidgetAccepte(TypeWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(40, 3, 14, 14);

		this.getLesZonesSaisies().add(f);
	}
	
	@Override
	public void decalageX(int x) { }

	@Override
	public void decalageY(int b, Rectangle r) { }

	@Override
	public void initListeners() {}
}

package vue.widget.modele;


import instruction.Operateur;
import instruction.Operation;
import instruction.Variable;
import java.awt.Point;
import java.awt.Polygon;
import modeles.TypeWidget;
import vue.widget.modele.zones.ChampTexte;


/**
 * Classe heritant de ModeleWidget et implementant Seriliazable modelisant la
 * forme d'un widget de type Expression arethmetique.
 * 
 * @author CHOUKET Houda
 */

public class ExpressionArithmeticWidget extends ModeleWidget {


	/**
	 * Constructeur du modele definissant les differents parametres du ExpressionSum .
	 */

	public ExpressionArithmeticWidget(Operateur op) {
		super();

		/*int tabX[] = {0, 5, 62, 67, 67, 62,  5, 0};
			int tabY[] = {7, 0, 0, 7, 20, 25,25, 20};
		 */
		int tabX[] = {0, 5, 62, 67, 67, 62,  5, 0};
		int tabY[] = {5, 0, 0, 5, 15, 20,20, 15};

		this.attachableBas = false;
        this.attachableHaut = false;
        this.imbricable = false;
        this.attachableInterne = true;
		
		/**
		 * Méthode permettant de définir un tableau représentant les coordonnées des
		 * ordonnées de la forme du widget.
		 *
		 * @param tabY Le tableau représentant les coordonnées des ordonnées de la
		 * forme du widget.
		 */
		this.setTabX(tabX);
		this.setTabY(tabY);
		/**
		 * Recalcule la largeur du widget.
		 */
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.EXPRESSION_ARITHMETIQUE);

		message.put(new Point(30, 17), op.toString());


		this.setElementProgramme(new Operation(op, (Variable)null, (Variable)null));
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));



		ChampTexte l = new ChampTexte();
		l.setBounds(10, 3, 14, 14);
		l.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);

		this.getLesZonesSaisies().add(l);


		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
		//f.setBounds(80, 3, 20, 20);
		f.setBounds(40, 3, 14, 14);
		this.getLesZonesSaisies().add(f);

		initListeners();
	}
	//		fin constructeur
	
	public void initListeners() {

	}

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

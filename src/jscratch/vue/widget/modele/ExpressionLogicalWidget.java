package jscratch.vue.widget.modele;

import jscratch.vue.widget.modele.zones.ChampTexte;

import java.awt.Point;
import java.awt.Polygon;
import jscratch.modeles.TypeWidget;
import nxtim.instruction.Condition;
import nxtim.instruction.Operateur;

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
		int tabX[] = {0, 10, 57, 67, 57, 10};
		int tabY[] = {10, 0, 0, 10, 20, 20};

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
		
		// Recalcule la largeur du widget.
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.EXPRESSION_LOGIQUE);

		message.put(new Point(30, 17), op.toString());

		this.setElementProgramme(new Condition(op));
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte l = new ChampTexte();
		
		l.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
		l.ajouterTypeWidgetAccepte(TypeWidget.EXPRESSION_ARITHMETIQUE);
		l.setBounds(10, 3, 14, 14);
		//l.setBounds(10, expressionModifiable.getnom().length(), 14, 14);
		//System.out.println("___"+expressionModifiable.getnom().length());
		
		//l.validate();//force à recalculer les positions
		
		/*
		 *
		 * for (int i = 0; i<nombreChoisi; i++){
		   JTextField field = new JTextField();
		   listeFields.add(field);
		   fenetre.getContentPane().add(field);
		}
		fenetre.getContentPane().validate(); //force à recalculer les positions
		 * */
 

		//message.put(new Point((int) (l.getLocation().getX()+ l.getWidth()), 17), op.toString()+expressionModifiable);
		//message.put(new Point((int) (l.getLocation().getX()+ l.getWidth()), 17), op.toString());
		this.getLesZonesSaisies().add(l);

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(40, 3, 14, 14);
		//f.setBounds(40, expressionModifiable.getnom().length(), 14, 14);
		this.getLesZonesSaisies().add(f);
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

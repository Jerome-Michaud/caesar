
package vue.widget.modele;


import vue.widget.modele.zones.ChampTexte;
import vue.widget.modele.zones.ListeDeroulante;
import vue.widget.modele.zones.Zone;
import instruction.Operateur;
import instruction.Operation;
import instruction.Variable;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

import modeles.TypeWidget;
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

			/*
			int tabX[] = {0, 5, 62, 67, 67, 62,  5, 0};
			int tabY[] = {7, 0, 0, 7, 20, 25,25, 20};
*/
			int tabX[] = {0, 5, 62, 67, 67, 62,  5, 0};
			int tabY[] = {5, 0, 0, 5, 19, 24,24, 19};
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
			l.setBounds(10, 3, 18, 18);
			l.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);

			this.getLesZonesSaisies().add(l);

			ChampTexte f = new ChampTexte();
			f.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
			//f.setBounds(80, 3, 20, 20);
			f.setBounds(40, 3, 18, 18);
			this.getLesZonesSaisies().add(f);



			
		}
//		fin constructeur
		/**
		 * Methode abstraite permettant de diminuer la largeur du composant
		 *
		 * @param x La valeur de la reduction à appliquer
		 */
		public void decalageXin(int x) {
			// TODO Auto-generated method stub
			
		}
		/**
		 * Méthode abstraite permettant d'augmenter la largeur du composant.
		 *
		 * @param x La valeur de l'agrandissement à appliquer
		 */
		@Override
		public void decalageXout(int x) {
			// TODO Auto-generated method stub
			
		}
		/**
		 * Méthode abstraite permettant de réduire la hauteur du composant.
		 *
		 * @param b La valeur de la réduction à appliquer
		 * @param r Le rectangle à réduire également
		 */
		@Override
		public void decalageYin(int b, Rectangle r) {
			// TODO Auto-generated method stub
		
		}

		@Override
		/**
		 * Méthode abstraite permettant d'augmenter la hauteur du composant
		 *
		 * @param b La valeur de l'agrandissement à appliquer
		 * @param r Le rectangle à augmenter également
		 */
		public void decalageYout(int b, Rectangle r) {
			// TODO Auto-generated method stub
		
		}

		public void initListeners() {
			
		}

	}
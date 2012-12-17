package vue.widget.modele;

import instruction.*;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import modeles.TypeWidget;
import vue.widget.modele.zones.ChampTexte;

/**
 * Classe heritant de ModeleWidget et implementant Seriliazable modelisant la
 * forme d'un widget de type ExpressionSum.
 *
 * @author CHOUKET Houda
 */
public class ExpressionSumWidget extends ModeleWidget {

    /**
     * Constructeur du modele definissant les differents parametres du
     * ExpressionSum .
     */
    public ExpressionSumWidget() {
        super();
        /*int tabX[] = {0, 5, 170, 175, 175, 170,  5, 0};
         int tabY[] = {7, 0, 0, 7, 20, 25,25, 20};
         */
        /*int tabX[] = {0, 5, 110, 115, 115, 110,  5, 0};
         int tabY[] = {7, 0, 0, 7, 20, 25,25, 20};*/

        /*int tabX[] = {0, 5, 106, 111, 111, 106,  5, 0};
         int tabY[] = {7, 0, 0, 7, 20, 25,25, 20};*/
        int tabX[] = {0, 5, 62, 67, 67, 62, 5, 0};
        int tabY[] = {7, 0, 0, 7, 20, 25, 25, 20};

        /**
         * Méthode permettant de définir un tableau représentant les coordonnées
         * des ordonnées de la forme du widget.
         *
         * @param tabY Le tableau représentant les coordonnées des ordonnées de
         * la forme du widget.
         */
        this.setTabX(tabX);
        this.setTabY(tabY);
        /**
         * Recalcule la largeur du widget.
         */
        this.setTailleX();
        this.setTailleY();
        this.setType(TypeWidget.EXPRESSION);



        message.put(new Point(30, 17), "+");


        this.setElementProgramme(new InstructionAttente());
        this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));


        ChampTexte l = new ChampTexte();
        l.setBounds(10, 3, 20, 20);

        l.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);

        this.getLesZonesSaisies().add(l);

        ChampTexte f = new ChampTexte();
        f.ajouterTypeWidgetAccepte(TypeWidget.VARIABLE);
        //f.setBounds(80, 3, 20, 20);
        f.setBounds(40, 3, 20, 20);
        this.getLesZonesSaisies().add(f);



        this.decalageXout(-5);

        initListeners();
    }
//	fin constructeur

    /**
     * Methode abstraite permettant de diminuer la largeur du composant
     *
     * @param x La valeur de la reduction à appliquer
     */
    public void decalageXin(int x) {
        // TODO Auto-generated method stub
        int i;
        for (i = 6; i < 10; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] - x;
        }
        this.setForme(this.getForme());
        this.setTailleX();
    }

    /**
     * Méthode abstraite permettant d'augmenter la largeur du composant.
     *
     * @param x La valeur de l'agrandissement à appliquer
     */
    @Override
    public void decalageXout(int x) {
        // TODO Auto-generated method stub
		/*int i;
         for (i = 6; i < 10; i++) {
         this.getForme().xpoints[i] = this.getForme().xpoints[i] + x;
         }
         this.setForme(this.getForme());
         this.setTailleX();*/
    }

    /**
     * Méthode abstraite permettant de réduire la hauteur du composant.
     *
     * @param b La valeur de la réduction à appliquer
     * @param r Le rectangle à réduire également
     */
    @Override
    public void decalageYin(int b, Rectangle r) {
        /*// TODO Auto-generated method stub
         int i;
         for (i = 8; i < 16; i++) {
         this.getForme().ypoints[i] = this.getForme().ypoints[i] - b;
         }
         this.setForme(this.getForme());
         this.setTailleY();*/
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
		/*int i;
         for (i = 8; i < 16; i++) {
         this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
         }
         this.setForme(this.getForme());
         this.setTailleY();*/
    }

    public void initListeners() {
        ((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent arg0) {
            }
        });
    }
}
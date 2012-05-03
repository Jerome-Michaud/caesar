package vue.tools;

import vue.widget.Widget;
import java.awt.Point;
import java.awt.Rectangle;
/**
 * Classe utilisée au moment du survol et de la fusion d'un widget et permettant
 * d'encapsuler au sein d'un même objet un widget et le type de survol
 * (au dessus, en dessous ou bien survol d'un zone d'accroche).
 *
 * Cette objet peut également contenir d'autres objets utiles à certains endroits du programme.
 *
 * @author Bastien ANDRU
 */
public class Action {
	/**
	 * La valeur (au dessus, en dessous ou bien survol d'un zone d'accroche) associée au widget.
	 */
    private int val;
	/**
	 * Le point utilisé pour calculer la transtaion à appliquer à la ligne à
	 * dessiner lors du survol d'un zone d'accroche.
	 */
	private Point translate;
	/**
	 * La zone d'accroche en cours de survol.
	 */
	private Rectangle rect;
	/**
	 * Le widget survolé actuellement.
	 */
    private Widget comp;
    /**
     * Constructeur de la classe Action.
     *
     * @param comp Le widget survolé sur lequel va être basée la fusion en cas de drop
     * @param val La valeur du survol (0 : survol par le dessous, 1 : survol
     * d'un widget par le dessus, 2: survol d'une zone d'accroche, -1 : Pas de survol)
     */
    public Action(Widget comp, int val) {
        this.comp = comp;
        this.val = val;
    }
	/**
     * Récuperation du rectangle symbolisant la zone d'accroche en cours de survol.
     *
     * @return Le rectangle symbolisant la zone d'accroche survolée, null si on
     * ne survole pas un zone d'accroche
     */
	public Rectangle getRect() {
		return rect;
	}
	/**
	 * Définition du rectangle de zone d'accroche en cas de survol d'un de ces zones.
	 *
	 * @param rec Le Rectangle symbolisant la zone d'accroche
	 */
	public void setRect(Rectangle rec) {
		this.rect = rec;
	}
	/**
	 * Récupération du point sur lequel sera basée la translation de la ligne en
	 * cas de survol d'un zone d'accroche
	 *
	 * @return Le point de translation, null si on ne survole pas de zone d'accroche.
	 */
	public Point getTranslate() {
		return translate;
	}
	/**
	 * Définition du point permettant de calculer la translation à appliquer à
	 * la ligne en cas de survol d'une zone d'accroche.
	 *
	 * @param translate Le point permettant de calculer la translation de la zone d'accroche.
	 */
	public void setTranslate(Point translate) {
		this.translate = translate;
	}
	/**
	 * Récuperation du widget en cours de survol.
	 *
	 * @return Le widget survolé, null si on ne survole pas de widget
	 */
    public Widget getComp() {
        return comp;
    }
    /**
     * Récupération de la valeur associée au survol du widget
     *
     * @return La valeur associée au survol(0 : survol par le dessous, 1 :
     * survol d'un widget par le dessus, 2: survol d'une zone d'accroche, -1 : pas de survol)
     */
    public int getVal() {
        return val;
    }
}

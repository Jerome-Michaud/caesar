package vue.tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.SwingUtilities;
import vue.ginterface.GlassPane;
import vue.ginterface.PanelCodeGraphique;
import vue.widget.Widget;
import vue.widget.WidgetCompose;

/**
 * Classe regroupant différents outils destinés au calcul de la nécessité de
 * fusionner ou non un widget avec un autre.
 *
 * @author Bastien ANDRU - Quentin GOSSELIN
 */
public class FusionTools {

	/**
	 * Constante stockant la marge à appliquer lors du calcul du survol d'un
	 * widget
	 */
	public static final int MARGE_AIMENT = 10;

	/**
	 * Méthode statique permettant de définir si on survol ou non un widget. Si
	 * oui, définit si on le survole par le dessous, le dessus ou, dans le cas
	 * d'un widget complexe, si on survole l'une de ses zones d'accroche.
	 *
	 * @param comp Le widget en cours de draggage pour lequel on doit vérifier
	 * si il survole ou non un autre widget
	 * @return Une objet de type Action regroupant les informations nécessaires
	 * au traitement du survol.
	 */
	public static Action checkSurvolWidget(Widget comp) {
		Rectangle rectComp = new Rectangle(comp.getLocationOnScreen(), comp.getSize());
		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		Point pt = comp.getLocationOnScreen();
		SwingUtilities.convertPointFromScreen(pt, p);
		Component compRecup = p.getComponentAt(pt.x, pt.y - MARGE_AIMENT);

		Action act = null;

		if (!(compRecup instanceof Widget)) {
			compRecup = p.getComponentAt(pt.x + comp.getWidth(), pt.y - MARGE_AIMENT);
		}
		if (!(compRecup instanceof Widget)) {
			compRecup = p.getComponentAt(pt.x, pt.y + comp.getHeight() + MARGE_AIMENT);
		}
		if (!(compRecup instanceof Widget)) {
			compRecup = p.getComponentAt(pt.x + comp.getWidth(), pt.y + comp.getHeight() + MARGE_AIMENT);
		}
		if (compRecup instanceof Widget) {
			Widget widgetRecup = (Widget) compRecup;
			pt = widgetRecup.getLocationOnScreen();
			Dimension size = widgetRecup.getSize();
			boolean trouve = false;
			if (widgetRecup.isComplexe()) {
				WidgetCompose wComp = (WidgetCompose) widgetRecup;
				for (Rectangle r : wComp.getMapZone().keySet()) {
					Rectangle cpy = new Rectangle(r.x, r.y, r.width, r.height);
					cpy.translate(pt.x, pt.y);
					if (rectComp.intersects(cpy)) {
						List<Widget> l = wComp.getMapZone().get(r);
						if (l.isEmpty()) {
							act = new Action(wComp, 2);
							act.setRect(r);
							act.setTranslate(pt);
						}
						trouve = true;
						break;
					}

				}
			}
			if (!trouve) {
				Rectangle rectCUp = new Rectangle(pt.x, pt.y - MARGE_AIMENT, (int) size.getWidth(), (int) (size.getHeight() / 2) + MARGE_AIMENT);
				Rectangle rectCDown = new Rectangle(pt.x, (int) (pt.y + (size.getHeight() / 2)), (int) size.getWidth(), (int) (size.getHeight() / 2) + MARGE_AIMENT);
				boolean compAtt = (comp.getModele().isAttachableBas() || comp.getModele().isAttachableHaut());
				if (rectCUp.intersects(rectComp) && rectComp.getMinY() < rectCUp.getMinY() + MARGE_AIMENT && widgetRecup.getModele().isAttachableHaut() && compAtt) {
					// Survol d'un widget en haut
					act = new Action(widgetRecup, 1);
				} else if (rectCDown.intersects(rectComp) && widgetRecup.getModele().isAttachableBas() && compAtt) {
					// Survol d'un widget en bas
					act = new Action(widgetRecup, 0);
				}
			}

		}
		if (act == null) {
			act = new Action(null, -1);
		}
		return act;
	}

	/**
	 * Méthode permettant de de définir l'endroit et la largeur de la ligne à
	 * dessiner sur l'écran si on survol un widget ou une zone d'accroche.
	 *
	 * @param comp Le widget en cours de dragage pour lequel on doit calculer si
	 * oui ou non il doit donner lieu au dessin d'une ligne
	 */
	public static void dessinerLigne(Widget comp) {
		GlassPane g = GlassPane.getInstance();
		Action act = FusionTools.checkSurvolWidget(comp);
		Widget compRecup = act.getComp();
		switch (act.getVal()) {
			case 1:
				//Appliquer l'action au dessus du comp
				g.setPointLigneSurEcran(new Point((int) compRecup.getLocationOnScreen().getX(), (int) compRecup.getLocationOnScreen().getY() - GlassPane.EPAISSEUR_LIGNE + 1));
				g.setLongueurLigne(compRecup.getWidth());
				break;
			case 0:
				//Appliquer l'action au dessous du comp
				g.setPointLigneSurEcran(new Point((int) compRecup.getLocationOnScreen().getX(), (int) compRecup.getLocationOnScreen().getY() + compRecup.getHeight() + 3));
				g.setLongueurLigne(compRecup.getWidth());
				break;

			case 2:
				Rectangle r = act.getRect();
				Rectangle cpy = new Rectangle(r.x, r.y, r.width, r.height);
				cpy.translate(act.getTranslate().x, act.getTranslate().y);
				g.setPointLigneSurEcran(new Point((int) cpy.x, (int) cpy.getY() + Variables.LINE_STROKE_VALUE));
				g.setLongueurLigne(r.width);
				break;
			case -1:
				//Pas d'action à appliquer
				g.setPointLigneSurEcran(null);
				break;
		}
	}
}
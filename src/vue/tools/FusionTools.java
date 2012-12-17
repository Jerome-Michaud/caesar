package vue.tools;

import vue.tools.actions.Action;
import vue.tools.actions.TypeAction;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.SwingUtilities;
import vue.ginterface.GUI;
import vue.ginterface.GlassPane;
import vue.ginterface.PanelCodeGraphique;
import vue.tools.comparators.ComparateurWidgetZ;
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
	 * Méthode statique permettant de définir si on survol ou non un widget. Si
	 * oui, définit si on le survole par le dessous, le dessus ou, dans le cas
	 * d'un widget complexe, si on survole l'une de ses zones d'accroche.
	 *
	 * @param comp Le widget en cours de draggage pour lequel on doit vérifier
	 * si il survole ou non un autre widget
	 * @return Une objet de type Action regroupant les informations nécessaires
	 * au traitement du survol.
	 * 
	 * @deprecated
	 */
	public static Action checkSurvolWidget(Widget comp) {
		int margeAimant = Variables.MARGE_AIMENT;
		
		Rectangle rectComp = new Rectangle(comp.getLocationOnScreen(), comp.getSize());
		PanelCodeGraphique p = GUI.getPanelCodeGraphique();
		Point pt = comp.getLocationOnScreen();
		SwingUtilities.convertPointFromScreen(pt, p);
		Component compRecup = p.getComponentAt(pt.x, pt.y - margeAimant);

		Action act = null;

		if (!(compRecup instanceof Widget)) {
			compRecup = p.getComponentAt(pt.x + comp.getWidth(), pt.y - margeAimant);
		}
		if (!(compRecup instanceof Widget)) {
			compRecup = p.getComponentAt(pt.x, pt.y + comp.getHeight() + margeAimant);
		}
		if (!(compRecup instanceof Widget)) {
			compRecup = p.getComponentAt(pt.x + comp.getWidth(), pt.y + comp.getHeight() + margeAimant);
		}
		if (compRecup instanceof Widget) {
			Widget widgetRecup = (Widget) compRecup;
			pt = widgetRecup.getLocationOnScreen();
			Dimension size = widgetRecup.getSize();
			boolean trouve = false;
			if (widgetRecup.isComplexe() && comp.getModele().isImbricable()) {
				WidgetCompose wComp = (WidgetCompose) widgetRecup;
				for (Rectangle r : wComp.getMapZone().keySet()) {
					Rectangle cpy = new Rectangle(r.x, r.y, r.width, r.height);
					cpy.translate(pt.x, pt.y);
					if (rectComp.intersects(cpy)) {
						List<Widget> l = wComp.getMapZone().get(r);
						if (l.isEmpty()) {
							act = new Action(wComp, TypeAction.ACCROCHE);
							act.setRect(r);
							act.setTranslate(pt);
						}
						trouve = true;
						break;
					}

				}
			}
			if (!trouve) {
				Rectangle rectCUp = new Rectangle(pt.x, pt.y - margeAimant, (int) size.getWidth(), (int) (size.getHeight() / 2) + margeAimant);
				Rectangle rectCDown = new Rectangle(pt.x, (int) (pt.y + (size.getHeight() / 2)), (int) size.getWidth(), (int) (size.getHeight() / 2) + margeAimant);
				boolean compAtt = (comp.getModele().isAttachableBas() || comp.getModele().isAttachableHaut());
				if (rectCUp.intersects(rectComp) && rectComp.getMinY() < rectCUp.getMinY() + margeAimant && widgetRecup.getModele().isAttachableHaut() && compAtt) {
					// Survol d'un widget en haut
					act = new Action(widgetRecup, TypeAction.DESSUS);
				} else if (rectCDown.intersects(rectComp) && widgetRecup.getModele().isAttachableBas() && compAtt) {
					// Survol d'un widget en bas
					act = new Action(widgetRecup, TypeAction.DESSOUS);
				}
			}

		}
		if (act == null) {
			act = new Action(null, TypeAction.RIEN);
		}
		return act;
	}

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
	public static Action checkSurvolWidgetV2(Widget comp) {
		int margeAimant = Variables.MARGE_AIMENT;
		PanelCodeGraphique p = GUI.getPanelCodeGraphique();
		
		Point coorComp = comp.getLocationOnScreen();
		coorComp.y -= margeAimant;
		Rectangle rectComp = new Rectangle(coorComp, new Dimension(comp.getWidth(), margeAimant * 3));
		
		List<Component> composants = new ArrayList<Component>(Arrays.asList(p.getComponents()));
		
		Widget compRecup = null;
		int minY = -1;

		// On garde seulement les widgets survolés
		for (int i = 0;i < p.getComponents().length;i++) {
			Component c = p.getComponents()[i];
			if (!SwingUtilities.convertRectangle(GUI.getPanelCodeGraphique(), c.getBounds(), GUI.getGlassPane()).intersects(comp.getBounds())) {
				composants.remove(c);
			}
			else {
				// Récupération du widget le plus haut (en Y) des widgets survolés
				if (minY == -1 || minY > c.getBounds().y) {
					compRecup = (Widget)c;
					minY = c.getBounds().y;
				}
			}
		}
		
		Action act = null;
		boolean isAttachable = (comp.getModele().isAttachableBas() || comp.getModele().isAttachableHaut());
					
		if (!composants.isEmpty()) {
			Collections.sort(composants, new ComparateurWidgetZ());

			if (compRecup != null) {
				if (composants.size() == 1) {
					// Ajout du widget au dessus ou en dessus de l'unique composa nt survolé
					act = checkBords(compRecup, rectComp, isAttachable);
				} else {
					// Ajout en dessous du premier composant
					if (!compRecup.isComplexe()) {
						act = new Action((Widget) compRecup, TypeAction.DESSOUS);
					}
					else {
						for (Component c : composants) {
							act = checkBords((Widget)c, rectComp, isAttachable);
							if (act != null) {
								break;
							}
						}
					}
				}
			}
		}
		else {
			act = new Action(null, TypeAction.RIEN);
		}
		
		return act;
	}

	/**
	 * Permet de savoir si on doit s'accrocher sur le widget survolé.
	 * 
	 * @param compRecup le widget survolé
	 * @param rectComp le rectangle important du widget dragué
	 * @param compAtt true si le composant est attable haut ou bas
	 * @return l'action à réaliser (accroche en haut, bas ou zone d'accroche
	 */
	private static Action checkBords(Widget compRecup, Rectangle rectComp, boolean compAtt) {
		Action act = null;
		int margeAimant = Variables.MARGE_AIMENT;
		
		Point pt = compRecup.getLocationOnScreen();

		
		Rectangle rectCUp = new Rectangle(pt.x, pt.y - margeAimant/2, (int) compRecup.getWidth(), margeAimant);
		Rectangle rectCDown = new Rectangle(pt.x, (int) (pt.y + compRecup.getHeight() - margeAimant/2), (int) compRecup.getWidth(), margeAimant);

		if (rectCUp.intersects(rectComp) && rectComp.getMinY() < rectCUp.getMinY() + margeAimant && compRecup.getModele().isAttachableHaut() && compAtt) {
			// Survol d'un widget en haut
			act = new Action(compRecup, TypeAction.DESSUS);
		} else if (rectCDown.intersects(rectComp) && compRecup.getModele().isAttachableBas() && compAtt) {
			// Survol d'un widget en bas
			act = new Action(compRecup, TypeAction.DESSOUS);
		} else if (compRecup.isComplexe()) {
			// Survol d'une zone d'accroche
			act = checkZoneAccroche((WidgetCompose)compRecup, rectComp, pt);
		}
		return act;
	}
	
	/**
	 * Permet de retourner une action si l'on survole une des zone d'accroche du widget passé en paramètre.
	 * 
	 * @param cp le widget survolé
	 * @param rectComp les coordonnées importantes du widget dragué
	 * @param pt les coordonnées du widget survolé
	 * @return l'action à réalisers, null si la zone d'accroche n'est pas survolée
	 */
	private static Action checkZoneAccroche(WidgetCompose cp, Rectangle rectComp, Point pt) {
		Action act = null;
		for (Rectangle r : cp.getMapZone().keySet()) {
			Rectangle cpy = new Rectangle(r.x, r.y, r.width, r.height);
			cpy.translate(pt.x, pt.y);
			if (rectComp.intersects(cpy)) {
				List<Widget> l = cp.getMapZone().get(r);
				if (l.isEmpty()) {
					act = new Action(cp, TypeAction.ACCROCHE);
					act.setRect(r);
					act.setTranslate(pt);
				}
			}
		}
		return act;
	}
	
	/**
	 * Méthode permettant de de définir l'endroit et la largeur de la ligne à
	 * dessiner sur l'écran si on survol un widget ou une zone d'accroche.
	 *
	 * @param comp Le widget en cours de dragage pour lequel on doit calculer si oui ou non il doit donner lieu au dessin d'une ligne
	 */
	public static void dessinerLigne(Widget comp) {
		GlassPane g = GUI.getGlassPane();
		Action act = FusionTools.checkSurvolWidgetV2(comp);
		
		if (act != null) {
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
					g.setPointLigneSurEcran(new Point((int) cpy.x, (int) cpy.getY() + Variables.LINE_STROKE_VALUE + 2));
					g.setLongueurLigne(r.width);
					break;
				case -1:
					//Pas d'action à appliquer
					g.setPointLigneSurEcran(null);
					break;
			}
		}
	}
}
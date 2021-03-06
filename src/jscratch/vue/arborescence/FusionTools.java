/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.vue.arborescence;

import jscratch.parametrages.properties.VariableProperties;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import jscratch.vue.arborescence.actions.Action;
import jscratch.vue.arborescence.actions.TypeAction;
import jscratch.comparateurs.ComparateurWidgetZ;
import jscratch.vue.widgets.modeles.TypeModeleWidget;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.principales.panels.GlassPane;
import jscratch.vue.ginterface.principales.panels.PanelCodeGraphique;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.WidgetCompose;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import jscratch.vue.widgets.modeles.zones.Zone;

/**
 * Classe regroupant différents outils destinés au calcul de la nécessité de
 * fusionner ou non un widget avec un autre.
 *
 * @since 1.0
 * @version 1.0
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
	 */
	public static Action checkSurvolWidgetV2(Widget comp) {
		int margeAimant = VariableProperties.MARGE_AIMENT;
		PanelCodeGraphique p = GUI.getPanelCodeGraphique();

		Point coorComp = comp.getLocationOnScreen();
		coorComp.y -= margeAimant;
		Rectangle rectComp = new Rectangle(coorComp, new Dimension(comp.getWidth(), margeAimant * 3));

		List<Component> composants = new ArrayList<Component>(Arrays.asList(p.getComponents()));

		Widget compRecup = null;
		int minY = -1;

		// On garde seulement les widgets survolés
		for (int i = 0; i < p.getComponents().length; i++) {
			Component c = p.getComponents()[i];
			if (!SwingUtilities.convertRectangle(GUI.getPanelCodeGraphique(), c.getBounds(), GUI.getGlassPane()).intersects(comp.getBounds())) {
				composants.remove(c);
			} else {
				// Récupération du widget le plus haut (en Y) des widgets survolés
				if (minY == -1 || minY > c.getBounds().y) {
					compRecup = (Widget) c;
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
					// Ajout du widget au dessus ou en dessus de l'unique composant survolé
					act = checkBords(compRecup, comp, rectComp, isAttachable);
				} else {
					for (Component c : composants) {
						act = checkBords((Widget) c, comp, rectComp, isAttachable);
						if (act != null) {
							break;
						}
					}
				}
			}
		}
		if (act == null) {
			act = new Action(null, TypeAction.RIEN);
		}

		return act;
	}

	/**
	 * Permet de savoir si on doit s'accrocher sur le widget survolé.
	 *
	 * @param compRecup le widget survolé
	 * @param compDrague Le composant dragué
	 * @param rectComp le rectangle important du widget dragué
	 * @param compAtt true si le composant est attable haut ou bas
	 * @return l'action à réaliser (accroche en haut, bas ou zone d'accroche
	 */
	private static Action checkBords(Widget compRecup, Widget compDrague, Rectangle rectComp, boolean compAtt) {
		Action act = null;
		int margeAimant = VariableProperties.MARGE_AIMENT;

		Point pt = compRecup.getLocationOnScreen();


		Rectangle rectCUp = new Rectangle(pt.x, pt.y - margeAimant / 2, (int) compRecup.getWidth(), margeAimant);
		Rectangle rectCDown = new Rectangle(pt.x, (int) (pt.y + compRecup.getHeight() - margeAimant / 2), (int) compRecup.getWidth(), margeAimant);
		if (compDrague.getModele().isAttachableInterne()) {
			act = checkFusionZone(compRecup, rectComp, compDrague.getType(), compRecup, act);
		}
		if (act == null) {
			if (rectCUp.intersects(rectComp) && rectComp.getMinY() < rectCUp.getMinY() + margeAimant && compRecup.getModele().isAttachableHaut() && compAtt) {
				// Survol d'un widget en haut
				act = new Action(compRecup, TypeAction.DESSUS);
			} else if (rectCDown.intersects(rectComp) && compRecup.getModele().isAttachableBas() && compAtt) {
				// Survol d'un widget en bas
				act = new Action(compRecup, TypeAction.DESSOUS);
			} else if (compRecup.isComplexe() && compDrague.getModele().isImbricable()) {
				// Survol d'une zone d'accroche
				act = checkZoneAccroche((WidgetCompose) compRecup, rectComp, pt);
			}
		}
		return act;
	}

	/**
	 * Permet de retourner une action si l'on survole une des zone d'accroche du
	 * widget passé en paramètre.
	 *
	 * @param cp le widget survolé
	 * @param rectComp les coordonnées importantes du widget dragué
	 * @param pt les coordonnées du widget survolé
	 * @return l'action à réalisers, null si la zone d'accroche n'est pas
	 * survolée
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
	 * @param comp Le widget en cours de dragage pour lequel on doit calculer si
	 * oui ou non il doit donner lieu au dessin d'une ligne
	 */
	public static void dessinerIndicateursFusion(Widget comp) {
		GlassPane g = GUI.getGlassPane();
		Action act = FusionTools.checkSurvolWidgetV2(comp);

		if (act != null) {
			Widget compRecup = act.getComp();
			switch (act.getTypeAction()) {
				case DESSUS:
					//Appliquer l'action au dessus du comp
					g.setRectFusion(null);
					g.setPointLigneSurEcran(new Point((int) compRecup.getLocationOnScreen().getX(), (int) compRecup.getLocationOnScreen().getY() - GlassPane.EPAISSEUR_LIGNE + 1));
					g.setLongueurLigne(compRecup.getWidth());
					break;
				case DESSOUS:
					//Appliquer l'action au dessous du comp
					g.setRectFusion(null);
					g.setPointLigneSurEcran(new Point((int) compRecup.getLocationOnScreen().getX(), (int) compRecup.getLocationOnScreen().getY() + compRecup.getHeight() + 3));
					g.setLongueurLigne(compRecup.getWidth());
					break;

				case ACCROCHE:
					g.setRectFusion(null);
					Rectangle r = act.getRect();
					Rectangle cpy = new Rectangle(r.x, r.y, r.width, r.height);
					cpy.translate(act.getTranslate().x, act.getTranslate().y);
					g.setPointLigneSurEcran(new Point((int) cpy.x, (int) cpy.getY() + VariableProperties.LINE_STROKE_VALUE + 2));
					g.setLongueurLigne(r.width);
					break;

				case INTERNE:
					g.setPointLigneSurEcran(null);
					g.setRectFusion(SwingUtilities.convertRectangle(compRecup, ((ChampTexte) (compRecup.getModele().getLesZonesSaisies().get(act.getZoneIndex()))).getBounds(), GUI.getGlassPane()));
					break;

				case RIEN:
					//Pas d'action à appliquer
					g.setPointLigneSurEcran(null);
					//g.setRectFusion(null);
					break;
			}
		}
	}

	private static Action checkFusionZone(Widget compRecup, Rectangle rectComp, TypeModeleWidget type, JComponent ref, Action a) {
		Point p = GUI.getGlassPane().getLocationOnScreen();
		Rectangle rectComp2 = new Rectangle(rectComp.x, rectComp.y, rectComp.width, rectComp.height);
		rectComp2.translate(0 - p.x, 0 - p.y);
		Rectangle bnds = SwingUtilities.convertRectangle(GUI.getGlassPane(), rectComp2, ref);
		List< Zone> lstZones = compRecup.getModele().getLesZonesSaisies();
		for (Zone zone : lstZones) {
			if (zone instanceof ChampTexte) {
				ChampTexte champ = (ChampTexte) zone;
				if ((champ.getBounds().intersects(bnds))) {
					if (champ.getEtat() != ChampTexte.ETAT_CONTIENT_WIDGET && champ.accepteTypeWidget(type)) {
						a = new Action(compRecup, TypeAction.INTERNE);
						a.setZoneIndex(lstZones.indexOf(zone));
						break;
					} else {
						if (champ.getWidgetContenu() != null) {
							a = checkFusionZone(champ.getWidgetContenu(), rectComp, type, champ, a);
						}
					}
				}
			}
		}
		return a;
	}
}
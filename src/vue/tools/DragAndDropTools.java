package vue.tools;

import vue.Interface.*;
import vue.widget.IWidget;
import vue.widget.Widget;
import vue.widget.WidgetCompose;
import vue.widget.modele.ModeleWidget;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modeles.Erreur;

public class DragAndDropTools {

	private List<Widget> composantsDrague;
	private static DragAndDropTools instance = new DragAndDropTools();

	private DragAndDropTools() {
		this.composantsDrague = new LinkedList<Widget>();
	}

	public static DragAndDropTools getInstance() {
		return instance;
	}

	public void clickWidget(Widget comp, Point ptClick) {
		comp.setPtClick(ptClick);

		if (!comp.isDraggable()) {
			comp.setDraggable(true);
			Widget compNouv;
			try {
				compNouv = PanelWidget.getInstance().getFabrique().cloner(comp);
				compNouv.setBounds(comp.getBounds());
				PanelWidget pw = PanelWidget.getInstance();
				pw.add(compNouv);
				int ind = pw.getIndex(comp);
				pw.supprimerWidget(comp);
				pw.ajouterWidget(compNouv, ind);
			} catch (NonClonableException ex) {
				Erreur.afficher(ex);
			}
			composantsDrague = new LinkedList<Widget>();
			composantsDrague.add(comp);
		} else {
			ArborescenceTools arbo = ArborescenceTools.getInstance();
			try {
				//recuperation et detachement des widgets dragués
				composantsDrague = new LinkedList<Widget>(arbo.getSuivants(comp, true));

				//supression des widgets dans l'arborescence
				arbo.supprimerWidgets(composantsDrague);
				if ((comp != null) && (comp.parent() != null) && (!comp.parent().isRacine())) {
					/*
					 * List<Widget> widAssoc =
					 * ((WidgetCompose)comp.parent()).getWidgetsAssocies(comp);
					 * widAssoc.removeAll(composantsDrague);
					 */
					((Widget) comp.parent()).applyChangeModele();
					((WidgetCompose) comp.parent()).notifyChange();
				}
				comp.defParent(null);

				//repaint
				PanelCodeGraphique.getInstance().repaint();
				GlassPane.getInstance().repaint();
			} catch (ComposantIntrouvableException ex) {
				Erreur.afficher(ex);
			}

		}
		for (Widget w : composantsDrague) {
			passerSurAutrePanel(w, GlassPane.getInstance());
		}

		Point p = GlassPane.getInstance().getMousePosition();
		System.out.println("le point" + p);
		p.x -= ptClick.x;
		p.y -= ptClick.y;

		dragGroupeWidget(composantsDrague, p);
	}

	public void passerSurAutrePanel(Widget wi, JPanel destination) {
		if (wi.isComplexe()) {
			for (List<Widget> lw : ((WidgetCompose) wi).getMapZone().values()) {
				for (Widget w : lw) {
					passerSurAutrePanel(w, destination);
				}
			}
		}
		Point p = wi.getLocationOnScreen();
		SwingUtilities.convertPointFromScreen(p, destination);
		wi.setLocation(p);
		wi.getParent().remove(wi);
		destination.add(wi);
	}

	public void dragGroupeWidget(List<Widget> lst, Point p) {
		for (Widget w : lst) {
			w.setLocation(p.x, p.y);
			/*
			 * w.getLocation().getLocation(). = p.x; w.getLocation().y = p.y;
			 */
			if (w.isComplexe()) {
				((WidgetCompose) w).notifyChange();
			}
			p.y += w.getHeight() - ModeleWidget.OFFSET;
		}
	}

	public void dragWidget(Widget comp) {
		if (comp.isDraggable()) {
			Point ptClick = comp.getPtClick();
			Point p = MouseInfo.getPointerInfo().getLocation();
			Rectangle recZoneUtil = new Rectangle(ZoneUtilisateur.getInstance().getLocationOnScreen(), new Dimension(ZoneUtilisateur.getInstance().getWidth(), ZoneUtilisateur.getInstance().getHeight()));
			Rectangle boundsGroup = groupeWidgetBounds(composantsDrague, 0);

			Rectangle recWid = new Rectangle(new Point((int) (MouseInfo.getPointerInfo().getLocation().x - ptClick.getX()), (int) (MouseInfo.getPointerInfo().getLocation().y - ptClick.getY())), new Dimension((int) boundsGroup.getWidth(), (int) boundsGroup.getHeight()));
			recZoneUtil.setBounds(recZoneUtil.getBounds().x + 4, recZoneUtil.getBounds().y + 20, recZoneUtil.getBounds().width - 12, recZoneUtil.getBounds().height - 20 - 9);

			if (!recZoneUtil.contains(recWid)) {
				boolean noX = false;
				if (recWid.getMinX() <= recZoneUtil.getMinX()) {
					//System.out.println("a gauche");
					p.x = (int) recZoneUtil.getMinX() + 4;
					p.y -= ptClick.y;
					noX = true;
				} else if (recWid.getMaxX() > recZoneUtil.getMaxX()) {
					//System.out.println("a droite");
					p.x = (int) recZoneUtil.getMaxX() - recWid.width - 4;
					p.y -= ptClick.y;
					noX = true;
				}

				if (recWid.getMinY() <= recZoneUtil.getMinY()) {
					//System.out.println("en haut");
					p.y = (int) recZoneUtil.getMinY() + 4;
					if (!noX) {
						p.x -= ptClick.x;
					}
				} else if (recWid.getMaxY() >= recZoneUtil.getMaxY()) {
					//System.out.println("en bas");
					p.y = (int) recZoneUtil.getMaxY() - recWid.height - 4;
					if (!noX) {
						p.x -= ptClick.x;
					}
				}
			} else {
				p.x -= ptClick.x + 4;
				p.y -= ptClick.y + 4;

			}
			p.x -= Fenetre.getInstance().getLocation().getX();
			p.y -= Fenetre.getInstance().getLocation().getY();
			dragGroupeWidget(composantsDrague, p);
			GlassPane.getInstance().repaint();
			FusionTools.dessinerLigne(comp);
		}
	}

	public void dropWidget() {
		Widget comp = composantsDrague.get(0);

		Action a = FusionTools.checkSurvolWidget(comp);
		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		GlassPane g = GlassPane.getInstance();
		Rectangle r = (Rectangle) comp.getBounds().clone();

		Point pt = comp.getLocationOnScreen();

		int decal = (int) (Widget.TAUX_TRANSFERT_PANEL * comp.getWidth());
		int inter = (int) (r.getMaxX() - p.getBounds().getMinX());
		ArborescenceTools arbo = ArborescenceTools.getInstance();
		boolean complexe = false;

		try {
			if (inter >= decal) {
				p.add(comp);

				SwingUtilities.convertPointFromScreen(pt, p);
				if (inter < comp.getWidth()) {
					pt.x += (comp.getWidth() - inter) + 3;
				}

				Widget compSurvole = a.getComp();

				switch (a.getVal()) {
					case 1:         //Au dessus du compSurvole
						arbo.ajouterWidgets(composantsDrague, compSurvole, false);

						break;

					case 0:         //En dessous du compSurvole
						arbo.ajouterWidgets(composantsDrague, compSurvole, true);

						break;

					case -1:
						arbo.ajouterWidgets(composantsDrague, compSurvole, true);
						break;

					case 2:
						WidgetCompose wComp = (WidgetCompose) (a.getComp());
						List<Widget> lst = wComp.getMapZone().get(a.getRect());
						lst.addAll(composantsDrague);
						break;

				}
				for (Widget w : composantsDrague) {
					passerSurAutrePanel(w, p);
					if (compSurvole == null) {
						w.defParent((IWidget) p);//gestion du parent suivant element survole

					} else {
						if (compSurvole.isComplexe()) {
							if (a.getVal() == 2) {
								complexe = true;
								w.defParent((WidgetCompose) compSurvole);
							}
						} else {
							w.defParent(compSurvole.parent());
							/*
							 * if (!w.parent().isRacine() && ((Widget)
							 * w.parent()).isComplexe()) { List<Widget> lstAssoc
							 * = ((WidgetCompose)
							 * comp.parent()).getWidgetsAssocies(comp);
							 * lstAssoc.addAll(lstAssoc.indexOf(comp),
							 * composantsDrague); ((Widget)
							 * comp.parent()).applyChangeModele();
							 * ((WidgetCompose) comp.parent()).notifyChange(); }
							 */

						}
					}
				}
				p.repaint();
				if (compSurvole != null && compSurvole.isComplexe()) {
					compSurvole.applyChangeModele();
					((WidgetCompose) compSurvole).notifyChange();
				}
			} else {
				arbo.supprimerWidgets(composantsDrague);
				for (Widget w : composantsDrague) {
					deleteWidgetsFromGlassPane(w);
				}
			}
			switch (a.getVal()) {
				case 1:         //Au dessus du compSurvole
					pt = groupeWidgetBounds(arbo.getListe(comp), composantsDrague.size()).getLocation();
					for (Widget w : composantsDrague) {
						pt.y -= (w.getHeight() - ModeleWidget.OFFSET);
					}
					break;

				case 0:         //En dessous du compSurvole
					pt = arbo.getListe(comp).get(0).getLocation();
					break;

			}
			if (complexe) {
				dragGroupeWidget(arbo.getSuivants((Widget) (comp.parent()), true), ((Widget) comp.parent()).getLocation());
			} else {
				dragGroupeWidget(arbo.getListe(comp), pt);//penser a la conversion
			}
			p.repaint();
			composantsDrague.clear();

		} catch (ComposantIntrouvableException ex) {
			Erreur.afficher(ex);
		}
		g.repaint();
		g.setLinePointOnScreen(null);
	}

	private void deleteWidgetsFromGlassPane(Widget comp) {
		if (comp.isComplexe()) {
			for (List<Widget> lw : ((WidgetCompose) comp).getMapZone().values()) {
				for (Widget w : lw) {
					deleteWidgetsFromGlassPane(w);
				}
			}
		}
		GlassPane.getInstance().remove(comp);
	}

	private static Rectangle groupeWidgetBounds(List<Widget> lst, int index) {
		if (lst.isEmpty()) {
			return new Rectangle();
		} else {
			Rectangle rect = lst.get(0).getBounds();
			for (int i = index; i < lst.size(); i++) {
				Widget w = lst.get(i);
				rect = rect.union(w.getBounds());
			}
			return rect;
		}
	}
}
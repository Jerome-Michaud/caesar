package Vue.Tools;

import Vue.Interface.*;
import Vue.Widget.Widget;
import java.awt.*;
import java.util.List;
import javax.swing.SwingUtilities;

public class DragAndDropTools {

	public static final int MARGE_AIMENT = 10;

	public static void clickWidget(Widget comp, Point ptClick) {
		comp.setPtClick(ptClick);
		System.out.println(ptClick);
		if (!comp.isDraggable()) {

			comp.setDraggable(true);
			Widget compNouv = PanelWidget.getInstance().getFabrique().cloner(comp);
			compNouv.setBounds(comp.getBounds());
			PanelWidget.getInstance().add(compNouv);
		}
		if (comp.getParent().equals(PanelCodeGraphique.getInstance())) {
			((PanelCodeGraphique) (comp.getParent())).supprimerComposant(comp);
			System.out.println(PanelCodeGraphique.getInstance().getListComposants());
			if (!comp.isAlone()) {
				if (!comp.isTop()) {
					Widget top = comp.getTopWidget();
					List<Widget> l = top.getWidgetsAttaches();
					int id = l.indexOf(comp);
					if (id == -1) {
						System.err.println("suivant non trouve(" + comp + "dans la liste " + l);
					} else {
						System.err.println("id pour le comp trouve " + id);
					}
					System.out.println("index recupéré : " + id);
					top.enleverWidget(comp);
					while (id < l.size()) {
						System.out.println(id + " taille: " + l.size());
						Widget nextComp = l.get(id);
						comp.ajouterSuivant(nextComp, comp.getNbSuivants());
						top.enleverWidget(nextComp);
						nextComp.setTopWidget(comp);
					}
				}
			}

		}
		comp.getParent().remove(comp);

		Fenetre.getInstance().getGlassPane().add(comp);
		if (!comp.isAlone() && comp.isTop()) {
			for (Widget w : comp.getWidgetsAttaches()) {
				Fenetre.getInstance().getGlassPane().add(w);
			}
		}
		Point p = Fenetre.getInstance().getGlassPane().getMousePosition();
		p.x -= ptClick.x;
		p.y -= ptClick.y;
		comp.deplacer(p);
	}

	public static void dragWidget(Widget comp) {
		if (comp.isDraggable()) {
			Point ptClick = comp.getPtClick();
			Point p = MouseInfo.getPointerInfo().getLocation();
			Rectangle recZoneUtil = new Rectangle(ZoneUtilisateur.getInstance().getLocationOnScreen(), new Dimension(ZoneUtilisateur.getInstance().getWidth(), ZoneUtilisateur.getInstance().getHeight()));
			Rectangle recWid = new Rectangle(new Point((int) (MouseInfo.getPointerInfo().getLocation().x - ptClick.getX()), (int) (MouseInfo.getPointerInfo().getLocation().y - ptClick.getY())), new Dimension(comp.getWidth(), comp.getHeight()));
			recZoneUtil.setBounds(recZoneUtil.getBounds().x + 4, recZoneUtil.getBounds().y + 20, recZoneUtil.getBounds().width - 12, recZoneUtil.getBounds().height - 20 - 9);

			if (!recZoneUtil.contains(recWid)) {
				boolean noX = false;
				if (recWid.getMinX() <= recZoneUtil.getMinX()) {
					System.out.println("a gauche");
					p.x = (int) recZoneUtil.getMinX() + 4;
					p.y -= ptClick.y;
					noX = true;
				} else if (recWid.getMaxX() > recZoneUtil.getMaxX()) {
					System.out.println("a droite");
					p.x = (int) recZoneUtil.getMaxX() - recWid.width - 4;
					p.y -= ptClick.y;
					noX = true;
				}

				if (recWid.getMinY() <= recZoneUtil.getMinY()) {
					System.out.println("en haut");
					p.y = (int) recZoneUtil.getMinY() + 4;
					if (!noX) {
						p.x -= ptClick.x;
					}
				} else if (recWid.getMaxY() >= recZoneUtil.getMaxY()) {
					System.out.println("en bas");
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
			comp.deplacer(p);
			dessinerLigne(comp);
		}
	}

	public static void dropWidget(Widget comp) {
		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		Rectangle r = (Rectangle) comp.getBounds().clone();
		int decal = (int) (Widget.TAUX_TRANSFERT_PANEL * comp.getWidth());
		int inter = (int) (r.getMaxX() - p.getBounds().getMinX());
		System.out.println(inter);
		if (inter >= decal) {
			System.out.println("Widget déposé dans le panelCodeGraphique " + inter + "-" + comp.getWidth());
			Point pt = comp.getLocationOnScreen();
			p.add(comp);
			p.ajouterComposant(comp);
			if (comp.isTop()) {
				for (Widget w : comp.getWidgetsAttaches()) {
					p.add(w);
					p.ajouterComposant(w);
				}
			}
			SwingUtilities.convertPointFromScreen(pt, p);
			if (inter < comp.getWidth()) {
				pt.x += (comp.getWidth() - inter) + 3;
			}
			/*
			 * if(comp.isTop()){ comp.deplacer(pt); }else{
			 * comp.getTopWidget().deplacer(comp.getTopWidget().getLocation());
			 * }
			 */
			comp.deplacer(pt);
			p.repaint();
		}

		checkFusion(comp);

		Fenetre.getInstance().getGlassPane().remove(comp);
		if (comp.isTop()) {
			for (Widget w : comp.getWidgetsAttaches()) {
				Fenetre.getInstance().getGlassPane().remove(w);
			}
		}
		Fenetre.getInstance().getGlassPane().repaint();
		PanelCodeGraphique.getInstance().setLinePoint(null);
	}

	public static void dessinerLigne(Widget comp) {
		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		Action act = checkSurvolWidget(comp);
		Widget compRecup = act.getComp();
		switch (act.getVal()) {
			case 1:                //Appliquer l'action au dessus du comp
				p.setLinePoint(new Point((int) compRecup.getLocation().getX(), (int) compRecup.getLocation().getY() - PanelCodeGraphique.LINE_WIDTH + 1));
				p.setLineWidth(compRecup.getWidth());
				break;
			case 0:                //Appliquer l'action au dessous du comp
				p.setLinePoint(new Point((int) compRecup.getLocation().getX(), (int) compRecup.getLocation().getY() + compRecup.getHeight() + 3));
				p.setLineWidth(compRecup.getWidth());
				break;
			case -1:               //Pas d'action à appliquer

				p.setLinePoint(null);
				break;
		}
		p.repaint();


	}

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
			Rectangle rectCUp = new Rectangle(pt.x, pt.y - MARGE_AIMENT, (int) size.getWidth(), (int) (size.getHeight() / 2) + MARGE_AIMENT);
			System.out.println(rectComp + "-" + rectCUp);
			Rectangle rectCDown = new Rectangle(pt.x, (int) (pt.y + (size.getHeight() / 2)), (int) size.getWidth(), (int) (size.getHeight() / 2) + MARGE_AIMENT);
			if (rectCUp.intersects(rectComp) && rectComp.getMinY() < rectCUp.getMinY() + MARGE_AIMENT) {
				System.out.println("survol d'un widget en haut");
				act = new Action(widgetRecup, 1);
			} else if (rectCDown.intersects(rectComp)) {
				System.out.println("survol d'un widget en bas");
				act = new Action(widgetRecup, 0);
			}
		}
		if (act == null) {
			act = new Action(null, -1);
		}
		return act;
		//if(compr)
        /*
		 * for (Widget c : p.getListComposants()) { Point pt =
		 * c.getLocationOnScreen(); Dimension size = c.getSize(); Rectangle
		 * rectCUp = new
		 * Rectangle(pt.x,pt.y,(int)size.getWidth(),(int)size.getHeight()/2);
		 * Rectangle rectCDown = new
		 * Rectangle(pt.x,(int)(pt.y+(size.getHeight()/2)),(int)size.getWidth(),(int)size.getHeight()/2);
		 * if (rectCUp.intersects(rectComp)) { System.out.println("survol d'un
		 * widget en haut"); p.setLinePoint(new
		 * Point((int)c.getLocation().getX(),(int)
		 * c.getLocation().getY()-PanelCodeGraphique.LINE_WIDTH));
		 * p.setLineWidth(c.getWidth()); trouve = true; break; }else if
		 * (rectCDown.intersects(rectComp)) { System.out.println("survol d'un
		 * widget en bas"); p.setLinePoint(new
		 * Point((int)c.getLocation().getX(),(int)
		 * c.getLocation().getY()+c.getHeight())); p.setLineWidth(c.getWidth());
		 * trouve = true; break; } }
		 */

	}

	private static void checkFusion(Widget compGlassPane) {
		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		Action act = checkSurvolWidget(compGlassPane);
		Widget compPanelGraphique = act.getComp();
		switch (act.getVal()) {
			case 1:                //Appliquer l'action au dessus du comp récupéré
				if (compGlassPane.isTop() && !compGlassPane.getWidgetsAttaches().contains(compPanelGraphique)) {
					compGlassPane.ajouterSuivant(compPanelGraphique, compGlassPane.getNbSuivants());
				} else {
					//Normalement on ne rentre jamais dans ce cas
					System.err.println("Problème : On est rentré dans le cas 1 de checkfusion alors que le comp est pas top !!!");
				}
				compGlassPane.repaint();
				break;
			case 0:                //Appliquer l'action au dessous du comp récupéré
				if (compPanelGraphique.isTop()) {
					compPanelGraphique.ajouterSuivant(compGlassPane, 0);
					int indexAj = 1;
					compGlassPane.setTopWidget(compPanelGraphique);
					for (Widget w : compGlassPane.getWidgetsAttaches()) {
						compPanelGraphique.ajouterSuivant(w, indexAj++);
						w.setTopWidget(compPanelGraphique);
						compGlassPane.remove(w);
					}

				} else {
					Widget top = compPanelGraphique.getTopWidget();
					if (!top.getWidgetsAttaches().contains(compGlassPane)) {
						top.ajouterSuivant(compGlassPane, top.getWidgetsAttaches().indexOf(compPanelGraphique) + 1);
					}
					System.out.println(top.getWidgetsAttaches());
				}
				compPanelGraphique.repaint();
				break;
		}
	}

	private static class Action {

		private Widget comp;
		private int val;

		public Action(Widget comp, int val) {
			this.comp = comp;
			this.val = val;
		}

		public Widget getComp() {
			return comp;
		}

		public int getVal() {
			return val;
		}
	}
}

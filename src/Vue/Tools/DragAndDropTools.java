package Vue.Tools;

import Vue.Interface.*;
import Vue.Widget.Widget;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.SwingUtilities;

public class DragAndDropTools {

	public static void clickWidget(Widget comp, Point ptClick) {
		comp.setPtClick(ptClick);
		if (!comp.isDraggable()) {
			comp.setDraggable(true);
			PanelWidget.getInstance().add(PanelWidget.getInstance().getFabrique().cloner(comp));
		}
		if (comp.getParent().equals(PanelCodeGraphique.getInstance())) {
			((PanelCodeGraphique) (comp.getParent())).supprimerComposant(comp);
		}
		comp.getParent().remove(comp);

		Fenetre.getInstance().getGlassPane().add(comp);
		Point p = Fenetre.getInstance().getGlassPane().getMousePosition();
		p.x -= ptClick.x;
		p.y -= ptClick.y;
		comp.setLocation(p);
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
					p.x = (int) recZoneUtil.getMinX() - 4;
					p.y -= ptClick.y;
					noX = true;
				} else if (recWid.getMaxX() > recZoneUtil.getMaxX()) {
					p.x = (int) recZoneUtil.getMaxX() - recWid.width;
					p.y -= ptClick.y;
					noX = true;
				}

				if (recWid.getMinY() <= recZoneUtil.getMinY()) {
					p.y = (int) recZoneUtil.getMinY() - 4;
					if (!noX) {
						p.x -= ptClick.x;
					}
				} else if (recWid.getMaxY() >= recZoneUtil.getMaxY()) {
					p.y = (int) recZoneUtil.getMaxY() - recWid.height;
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
			comp.setLocation(p);
			checkSurvolWidget(comp);
		}
	}

	public static void dropWidget(Widget comp) {
		Rectangle r = (Rectangle) comp.getBounds().clone();
		int decal = (int) (Widget.TAUX_TRANSFERT_PANEL * comp.getWidth());
		int inter = (int) (r.getMaxX() - PanelCodeGraphique.getInstance().getBounds().getMinX());
		if (inter >= decal) {
			Point p = comp.getLocationOnScreen();
			PanelCodeGraphique.getInstance().add(comp);
			PanelCodeGraphique.getInstance().ajouterComposant(comp);
			SwingUtilities.convertPointFromScreen(p, PanelCodeGraphique.getInstance());
			if (inter < comp.getWidth()) {
				p.x += (comp.getWidth() - inter) + 3;
			}
			comp.setLocation(p);
			PanelCodeGraphique.getInstance().repaint();
		}

		Fenetre.getInstance().getGlassPane().remove(comp);
		Fenetre.getInstance().getGlassPane().repaint();
	}

	public static void checkSurvolWidget(Widget comp) {
	}
}

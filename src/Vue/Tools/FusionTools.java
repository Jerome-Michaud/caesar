/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Tools;

import Vue.Interface.GlassPane;
import Vue.Interface.PanelCodeGraphique;
import Vue.Widget.Widget;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bastien
 */
public class FusionTools {    
    
    public static final int MARGE_AIMENT = 10;
    
    public static void checkFusion(Widget comp) {
        PanelCodeGraphique p = PanelCodeGraphique.getInstance();
        Action act = checkSurvolWidget(comp);
        Widget compRecup = act.getComp();
        switch (act.getVal()) {
            case 1:                //Appliquer l'action au dessus du comp récupéré
                /*if (comp.isTop() && !comp.getWidgetsAttaches().contains(compRecup)) {
                    comp.ajouterSuivant(compRecup, comp.getNbSuivants());
                } else {
                    //Normalement on ne rentre jamais dans ce cas
                    System.err.println("Problème : On est rentré dans le cas 1 de checkfusion alors que le comp est pas top !!!");
                }
                comp.repaint();*/
                break;
            case 0:                //Appliquer l'action au dessous du comp récupéré
                /*if (compRecup.isTop()) {
                    compRecup.ajouterSuivant(comp, 0);
                    int indexAj = 1;
                    comp.setTopWidget(compRecup);
                    for (Widget w : comp.getWidgetsAttaches()) {
                        compRecup.ajouterSuivant(w, indexAj++);
                        w.setTopWidget(compRecup);
                        comp.remove(w);
                    }

                } else {
                    Widget top = compRecup.getTopWidget();
                    if (!top.getWidgetsAttaches().contains(comp)) {
                        top.ajouterSuivant(comp, top.getWidgetsAttaches().indexOf(compRecup) + 1);
                    }
                    System.out.println(top.getWidgetsAttaches());
                }
                compRecup.repaint();*/
                break;
        }
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
    }
    
    
    
    

    public static void dessinerLigne(Widget comp) {
        GlassPane g = GlassPane.getInstance();
        Action act = FusionTools.checkSurvolWidget(comp);
        Widget compRecup = act.getComp();
        switch (act.getVal()) {
            case 1:                //Appliquer l'action au dessus du comp
                g.setLinePointOnScreen(new Point((int) compRecup.getLocationOnScreen().getX(), (int) compRecup.getLocationOnScreen().getY() - GlassPane.LINE_WIDTH + 1));
                g.setLineWidth(compRecup.getWidth());
                break;
            case 0:                //Appliquer l'action au dessous du comp
                g.setLinePointOnScreen(new Point((int) compRecup.getLocationOnScreen().getX(), (int) compRecup.getLocationOnScreen().getY() + compRecup.getHeight() + 3));
                g.setLineWidth(compRecup.getWidth());
                break;
            case -1:               //Pas d'action à appliquer

                g.setLinePointOnScreen(null);
                break;
        }
        g.repaint();
    }
}

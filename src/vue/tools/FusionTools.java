package vue.tools;

import vue.ginterface.GlassPane;
import vue.ginterface.PanelCodeGraphique;
import vue.widget.Widget;
import vue.widget.WidgetCompose;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.SwingUtilities;

public class FusionTools {

    public static final int MARGE_AIMENT = 10;

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
                        System.out.println("on est dans un sous zone");
                        
                        List<Widget> l = wComp.getMapZone().get(r);
                        if(l.isEmpty()){
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
                System.out.println(rectComp + "-" + rectCUp);
                Rectangle rectCDown = new Rectangle(pt.x, (int) (pt.y + (size.getHeight() / 2)), (int) size.getWidth(), (int) (size.getHeight() / 2) + MARGE_AIMENT);
                boolean compAtt = (comp.getModele().isAttachableBas() || comp.getModele().isAttachableHaut());
                if (rectCUp.intersects(rectComp) && rectComp.getMinY() < rectCUp.getMinY() + MARGE_AIMENT && widgetRecup.getModele().isAttachableHaut() && compAtt) {
                    System.out.println("survol d'un widget en haut");
                    act = new Action(widgetRecup, 1);
                } else if (rectCDown.intersects(rectComp) && widgetRecup.getModele().isAttachableBas() && compAtt) {
                    System.out.println("survol d'un widget en bas");
                    act = new Action(widgetRecup, 0);
                }
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
                
            case 2 : 
                Rectangle r  = act.getRect();
                Rectangle cpy = new Rectangle(r.x,r.y, r.width, r.height);
                    cpy.translate(act.getTranslate().x,act.getTranslate().y);
                g.setLinePointOnScreen(new Point((int)cpy.x,(int)cpy.getY()+Variables.LINE_STROKE_VALUE));
                g.setLineWidth(r.width);
                break;
            case -1:               //Pas d'action à appliquer
                g.setLinePointOnScreen(null);
                break;
        }
        g.repaint();
    }
}
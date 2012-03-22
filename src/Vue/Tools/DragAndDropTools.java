/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Tools;

import Modeles.Erreur;
import Vue.Interface.*;
import Vue.Widget.IWidget;
import Vue.Widget.ModeleWidget;
import Vue.Widget.Widget;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bastien
 */
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
            Widget compNouv = PanelWidget.getInstance().getFabrique().creerWidgetIf();
            compNouv.setBounds(comp.getBounds());
            PanelWidget.getInstance().add(compNouv);
            composantsDrague = new LinkedList<Widget>();
            composantsDrague.add(comp);
        } else {
            ArborescenceTools arbo = ArborescenceTools.getInstance();
            try {
                //recuperation et detachement des widgets dragués
                composantsDrague = new LinkedList<Widget>(arbo.getSuivants(comp, true));
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\arbo size:" + composantsDrague.size());
                //supression des widgets dans l'arborescence
                arbo.supprimerWidgets(composantsDrague);
                comp.defParent(null);

                //repaint
                PanelCodeGraphique.getInstance().repaint();
                GlassPane.getInstance().repaint();
            } catch (ComposantIntrouvableException ex) {
                Erreur.afficher(ex);
            }
            
        }
        System.out.println("//////////////////////////");
        for (Widget w : composantsDrague) {
            comp.getParent().remove(w);
            GlassPane.getInstance().add(w);
        }
        
        Point p = GlassPane.getInstance().getMousePosition();
        p.x -= ptClick.x;
        p.y -= ptClick.y;
        
        dragGroupeWidget(composantsDrague, p);
    }
    
    public void dragGroupeWidget(List<Widget> lst, Point p) {
        System.out.println("-----------");
        for (Widget w : lst) {
            System.out.println("parent comp drag :" + w.getParent());
            w.setLocation(p.x, p.y);
            p.y += w.getHeight() - ModeleWidget.OFFSET;
        }
        System.out.println("-----------");
    }
    
    public void dragWidget(Widget comp) {
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
            dragGroupeWidget(composantsDrague, p);
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
        
        try {
            if (inter >= decal) {
                System.out.println("Widget déposé dans le panelCodeGraphique " + inter + "-" + comp.getWidth());
                p.add(comp);
                
                SwingUtilities.convertPointFromScreen(pt, p);
                if (inter < comp.getWidth()) {
                    pt.x += (comp.getWidth() - inter) + 3;
                }
                
                
                
                Widget compSurvole = a.getComp();
                System.out.println("comp survol : " + compSurvole);
                
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
                    
                }
                for (Widget w : composantsDrague) {
                    g.remove(w);
                    p.add(w);
                    if (compSurvole == null) {
                        w.defParent((IWidget) p);//gestion du parent suivant element survole

                    } else {
                        w.defParent(compSurvole.parent());
                    }
                }
                
                
                p.repaint();
            } else {
                System.out.println("en dehors");
                arbo.supprimerWidgets(composantsDrague);
                for (Widget w : composantsDrague) {
                    g.remove(w);
                }
            }
            switch (a.getVal()) {
                case 1:         //Au dessus du compSurvole
                    pt = groupeWidgetBounds(arbo.getListe(comp),composantsDrague.size()).getLocation();
                    for(Widget w : composantsDrague){
                        pt.y -= (w.getHeight() - ModeleWidget.OFFSET);
                    }
                    break;
                
                case 0:         //En dessous du compSurvole
                    pt = arbo.getListe(comp).get(0).getLocation();
                    break;
                
            }
            dragGroupeWidget(arbo.getListe(comp), pt);//penser a la conversion
            composantsDrague.clear();
            
        } catch (ComposantIntrouvableException ex) {
            Erreur.afficher(ex);
        }
        g.repaint();
        g.setLinePointOnScreen(null);
    }
    
    private static Rectangle groupeWidgetBounds(List<Widget> lst,int index) {
        if (lst.isEmpty()) {
            return new Rectangle();
        } else {
            Rectangle rect = lst.get(0).getBounds();
            for (int i = index;i < lst.size();i++){
                Widget w = lst.get(i);
                rect = rect.union(w.getBounds());
            }
            return rect;
        }
    }
}

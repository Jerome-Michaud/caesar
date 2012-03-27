package Vue.Widget;

import Vue.Tools.ComposantIntrouvableException;
import Vue.Widget.modele.ModeleWidget;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WidgetCompose extends Widget implements IWidget {

    private HashMap<Rectangle, List<Widget>> mapZone;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("on est dans le paint du widget compose");
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        for (Rectangle r : this.mapZone.keySet()) {
            System.out.println("on draw un rect " + r);
            g2d.drawRect(r.x, r.y, r.width, r.height);

        }

    }

    public WidgetCompose(ModeleWidget comp) {
        super(comp);
        this.mapZone = new HashMap<Rectangle, List<Widget>>();
        for (Rectangle r : comp.getZonesAccroches()) {
            this.mapZone.put(r, new LinkedList<Widget>());
        }
    }

    public boolean ajouterWidget(Rectangle cle, Widget widget) {
        return this.mapZone.get(cle).add(widget);
    }

    public boolean supprimerWidget(Rectangle cle, Widget widget) {
        return this.mapZone.get(cle).remove(widget);
    }

    public HashMap<Rectangle, List<Widget>> getLesFils() {
        return this.mapZone;
    }

    /*
     * public HashMap<Rectangle,List<Widget>> getComposition() { return
     * this.mapZone.; }
     */
    public List<Widget> getWidgetsAssocies(Widget comp) throws ComposantIntrouvableException {
        List<Widget> l = null;
        boolean trouve = false;
        for (List<Widget> lst : this.mapZone.values()) {
            if (lst.contains(comp)) {
                trouve = true;
                l = lst;
                break;
            }
            if (trouve) {
                break;
            }
        }
        if (!trouve) {
            throw new ComposantIntrouvableException();
        }
        return l;
    }

    @Override
    public boolean isComplexe() {
        return true;
    }

    @Override
    public boolean isRacine() {
        return false;
    }

    public HashMap<Rectangle, List<Widget>> getMapZone() {
        return mapZone;
    }

    public void notifyChange() {
        HashMap<Rectangle,Rectangle> mapRect = new HashMap<Rectangle, Rectangle>();
        for (Rectangle r : mapZone.keySet()) {
            int offset = 0;
            Rectangle maxBounds = null;
            System.out.println("##" + r);
            for (Widget w : mapZone.get(r)) {
                if (w.isComplexe()) {
                    ((WidgetCompose) w).notifyChange();
                }
                w.setLocation((int) (this.getLocation().getX() + r.getX()), (int) (this.getLocation().getY() + r.getY() + offset));
                if (maxBounds == null) {
                    maxBounds = new Rectangle(w.getBounds());
                    System.out.println("les bounds :"+maxBounds);
                } else {
                    System.out.println("bounds avant : "+maxBounds);
                    maxBounds = maxBounds.union(w.getBounds());
                    System.out.println("bounds apres : "+maxBounds);
                }
            }
            if (maxBounds != null) {
                int diff = maxBounds.height - r.height - ModeleWidget.OFFSET;
                if (diff < 0-ModeleWidget.OFFSET) {
                    this.getModele().decalageYin(Math.abs(diff), r);
                } else if (diff > 0-ModeleWidget.OFFSET) {
                    this.getModele().decalageYout(diff, r);
                }
            }
            if(maxBounds == null){
                maxBounds = new Rectangle(r);
            }
            Rectangle bnds = new Rectangle(r);
            bnds.height = maxBounds.height;
            mapRect.put(r, bnds);
            this.setForme(false);
        }
        for(Rectangle r : mapRect.keySet()){
            this.mapZone.put(mapRect.get(r), this.mapZone.remove(r));
        }
    }
}

package Vue.Widget;

import Vue.Tools.ComposantIntrouvableException;
import Vue.Tools.Variables;
import Vue.Widget.modele.ModeleWidget;
import instruction.Instruction;
import instruction.InstructionIfElse;
import instruction.InstructionStructure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import modeles.TypeWidget;

public class WidgetCompose extends Widget implements IWidget {

    private HashMap<Rectangle, List<Widget>> mapZone;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        for (Rectangle r : this.mapZone.keySet()) {
            g2d.drawRect(r.x, r.y, r.width, r.height);

        }*/

    }

    public WidgetCompose(ModeleWidget comp) {
        super(comp);
        this.mapZone = new HashMap<Rectangle, List<Widget>>();
        for (Rectangle r : comp.getZonesAccroches()) {
            this.mapZone.put(r, new LinkedList<Widget>());
        }
    }

    /*
     * public boolean ajouterWidget(Rectangle cle, Widget widget) { return
     * this.mapZone.get(cle).add(widget); }
     */
    public boolean supprimerWidget(Rectangle cle, Widget widget) {
        return this.mapZone.get(cle).remove(widget);
    }

    public HashMap<Rectangle, List<Widget>> getMapZone() {
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

    public void notifyChange() {
        HashMap<Rectangle, Rectangle> mapRect = new HashMap<Rectangle, Rectangle>();
        HashMap<Rectangle, Integer> mapDecal = new HashMap<Rectangle, Integer>();
        for (Rectangle r : mapZone.keySet()) {
            int decalY = 0;
            Rectangle maxBounds = null;
            System.err.println("La taille " + mapZone.get(r).size());
            for (Widget w : mapZone.get(r)) {
                if (w.isComplexe()) {
                    ((WidgetCompose) w).notifyChange();
                }
                w.setLocation((int) (this.getLocation().getX() + r.getX()), (int) (this.getLocation().getY() + r.getY() + decalY));
                if (maxBounds == null) {
                    maxBounds = new Rectangle(w.getBounds());
                    decalY += w.getBounds().height - ModeleWidget.OFFSET;
                } else {
                    maxBounds = maxBounds.union(w.getBounds());
                    decalY += w.getBounds().height - ModeleWidget.OFFSET;
                }
            }
            if (maxBounds == null) {
                maxBounds = new Rectangle();
            }
            maxBounds.height -= ModeleWidget.OFFSET;
            maxBounds.height = Math.max(maxBounds.height, Variables.ECART_PAR_DEFAULT);
            int diff = maxBounds.height - r.height;

            //On stocke le décalage qu'on voudra appliquer sur les zones d'accroche du composant
            System.err.println("diff : " + diff);
            if (diff < 0 - ModeleWidget.OFFSET) {
                this.getModele().decalageYin(Math.abs(diff), r);
                decaleZonesEnDessousDe(r.y, diff, mapDecal);
            } else if (diff > 0 - ModeleWidget.OFFSET) {
                this.getModele().decalageYout(diff, r);
                decaleZonesEnDessousDe(r.y, diff, mapDecal);
            }

            Rectangle bnds = new Rectangle(r);
            bnds.height = maxBounds.height;
            //On stocke les nouvelles bounds des zone ou il y a des changements
            mapRect.put(r, bnds);
            this.setForme(false);
        }

        //Une fois sorti de la boucle ...
        // ...On decale les nouvelles bounds qu'on a stocké plus haut si il y a besoin
        for (Rectangle r : mapDecal.keySet()) {
            if (mapRect.get(r) != null) {
                Rectangle rectDecal = new Rectangle(mapRect.get(r));
                rectDecal.y += mapDecal.get(r);
                mapRect.put(r, rectDecal);
            }
        }

        // Et enfin on finit par attribuer a chaque zone ses nouvelles bounds
        for (Rectangle r : mapRect.keySet()) {
            this.mapZone.put(mapRect.get(r), this.mapZone.remove(r));
        }
    }

    private void decaleZonesEnDessousDe(int y, int diff, HashMap<Rectangle, Integer> map) {
        for (Rectangle r : this.mapZone.keySet()) {
            if (r.y > y) {
                map.put(r, diff);
            }
        }
    }

    /**
     * Met à jour l'arborescence des instructions
     */
    public void applyChangeModele() {
        /*
         * Testé le type du modele widget courant
         */
        if (this.getModele().getType() == TypeWidget.IFELSE) {
            /*
             * Cas du if...else
             */
            InstructionIfElse structInst = (InstructionIfElse) this.getModele().getElementProgramme();
            /*
             * Récupéré clé mapZone du if et du else
             */
            /*
             * clé du if <=> rectangle supérieur
             */
            /*
             * clé du else <=> rectangle inféreur
             */
            /*
             * Suppression des instructions du if et du else dans l'arbre des
             * instruction
             */
            /*
             * Récupérer les instructions des widgets du if
             */
            /*
             * les ajouté à l'arbre des instructions
             */
            List<Widget> widgets = recupeAllWidgetCorps(1);
            structInst.removeEnfantsIf();
            for (Widget widget : widgets) {
                Instruction inst = (Instruction) widget.getElementProgramme();
                structInst.insererFinIf(inst);
            }
            /*
             * Récupérer les instructions des widgets du else
             */
            /*
             * les ajouté à l'arbre des instructions
             */
            widgets = recupeAllWidgetCorps(0);
            structInst.removeEnfantsElse();
            for (Widget widget : widgets) {
                Instruction inst = (Instruction) widget.getElementProgramme();
                structInst.insererFinElse(inst);
            }

        } else {
            /*
             * Cas des instructions structures autre que IfElse
             */
            this.applyChangeStructInst();
        }
    }

    private List<Widget> recupeAllWidgetCorps(int i) {
        /*
         * Récupérer la clé du corps
         */
        Set<Rectangle> keys = this.mapZone.keySet();
        /*
         * Récupérer les widgets du contenue
         */
        Object[] rects = keys.toArray();
        List<Widget> widgets = this.mapZone.get(rects[i]);
        return widgets;
    }

    private void applyChangeStructInst() {
        /*
         * Cas de la tâche
         */
        InstructionStructure structInst = (InstructionStructure) this.getModele().getElementProgramme();
        /*
         * Récupération des widgets fils
         */
        List<Widget> widgets = recupeAllWidgetCorps(0);
        /*
         * Suppression des enfants de la tâche
         */
        structInst.removeEnfants();
        /*
         * Ajout de tous les enfants nouveaux et anciens
         */
        for (Widget widget : widgets) {
            Instruction inst = (Instruction) widget.getElementProgramme();
            structInst.insererFin(inst);
        }
    }
}
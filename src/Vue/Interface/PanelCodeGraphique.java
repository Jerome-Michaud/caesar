package Vue.Interface;

import Vue.Widget.Widget;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelCodeGraphique extends JPanel {
    private static PanelCodeGraphique instance = new PanelCodeGraphique();
    private List<Widget> listComposants;
    private Point linePoint;
    public static final int LINE_WIDTH = 5;
    private int lineWidth;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        if(linePoint != null){
            g2d.setStroke(new BasicStroke(LINE_WIDTH));
            g2d.drawLine(linePoint.x, linePoint.y, linePoint.x+lineWidth, linePoint.y);
        }
    }

    private PanelCodeGraphique() {
        this.listComposants = new LinkedList<Widget>();
        this.setMinimumSize(new Dimension(400, 600));
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Code graphique"));
        this.linePoint = null;
        this.lineWidth = 0;
    }

    public static PanelCodeGraphique getInstance() {
        return instance;
    }

    public boolean ajouterComposant(Widget comp){
        return listComposants.add(comp);
    }

    public boolean supprimerComposant(Widget comp){
        return listComposants.remove(comp);
    }

    public List<Widget> getListComposants() {
        return listComposants;
    }

    public void setLinePoint(Point linePoint) {
        this.linePoint = linePoint;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }
}

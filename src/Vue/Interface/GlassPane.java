/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Interface;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bastien
 */
public class GlassPane extends JPanel {

    private static final GlassPane instance = new GlassPane();
    private Point linePoint;
    public static final int LINE_WIDTH = 5;
    private int lineWidth;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (linePoint != null) {
            g2d.setStroke(new BasicStroke(LINE_WIDTH));
            g2d.drawLine(linePoint.x, linePoint.y, linePoint.x + lineWidth, linePoint.y);
        }
    }

    private GlassPane() {
        this.linePoint = null;
        this.lineWidth = 0;
    }

    public static GlassPane getInstance() {
        return instance;
    }

    public void setLinePointOnScreen(Point linePoint) {
        if (linePoint != null) {
            SwingUtilities.convertPointFromScreen(linePoint, this);
        }
        this.linePoint = linePoint;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }
}

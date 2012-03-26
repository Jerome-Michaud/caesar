package Vue.Widget;

import Modeles.TypeWidget;
import Vue.Interface.GlassPane;
import Vue.Interface.PanelCodeGraphique;
import Vue.Interface.PanelWidget;
import Vue.Tools.DragAndDropTools;
import Vue.Widget.modele.ModeleWidget;
import instruction.IElementProgramme;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

public class Widget extends JComponent {

    public static final float TAUX_TRANSFERT_PANEL = (float) 0.6;
    private Point ptClick;
    private boolean draggable = false;
    private ModeleWidget modele;
    private Font font;
    private IWidget parent;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(this.modele.getCouleur());
        g2d.fillPolygon(this.modele.getForme());
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(this.modele.getForme());
        g2d.setColor(Color.WHITE);
        if (this.modele.isConditionHaute()) {
            g2d.drawString(this.modele.getMessage(), 60, 17);
        } else {
            g2d.drawString(this.modele.getMessage(), 60, this.getHeight() - 14);
        }
        super.paintComponent(g);
    }

    public Widget(ModeleWidget modele) {
        this.font = new Font("TimesRoman ", Font.PLAIN, 12);
        this.modele = modele;
        this.setFont(this.font);
        this.setFocusable(true);
        this.setOpaque(true);
        this.setForme();
        
        initListeners();
        
        this.parent = null;
    }

    private void repaintAll(MouseEvent e) {
        PanelWidget.getInstance().repaint();
        PanelCodeGraphique.getInstance().repaint();
        GlassPane.getInstance().repaint();
    }

    public void setForme() {
        int maxX = 0;
        for (Integer i : this.modele.getForme().xpoints) {
            maxX = Math.max(maxX, i);
        }

        int maxY = 0;
        for (Integer i : this.modele.getForme().ypoints) {
            maxY = Math.max(maxY, i);
        }

        this.setBounds(0, 0, maxX + 1, maxY + 1);
        this.setPreferredSize(new Dimension(maxX, maxY));
    }

  

    public ModeleWidget getModele() {
        return this.modele;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public void setPtClick(Point ptClick) {
        this.ptClick = ptClick;
    }

    public Point getPtClick() {
        return this.ptClick;
    }

    public boolean isComplexe() {
        return false;
    }

    public IWidget parent() {
        return parent;
    }

    public void defParent(IWidget parent) {
        this.parent = parent;
    }

    public TypeWidget getType() {
        return this.modele.getType();
    }
	
	public IElementProgramme getElementProgramme() {
		return this.modele.getElementProgramme();
	}

    public void initListeners() {
        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                DragAndDropTools.getInstance().clickWidget((Widget) e.getComponent(), e.getPoint());
                System.out.println("clic");
                repaintAll(e);
            }

            public void mouseReleased(MouseEvent e) {
                DragAndDropTools.getInstance().dropWidget();
            }
        });
		
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                DragAndDropTools.getInstance().dragWidget((Widget) e.getComponent());
            }
        });
    }
}
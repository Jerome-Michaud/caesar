package Vue.Widget;

import Vue.Interface.Fenetre;
import Vue.Interface.PanelCodeGraphique;
import Vue.Interface.PanelWidget;
import Vue.Tools.DragAndDropTools;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Widget extends JPanel {
    public static final float TAUX_TRANSFERT_PANEL = (float)0.6;
    private Point ptClick;
    private boolean draggable = false;
    private ModeleWidget modele;
    private Font font;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.modele.getCouleur());
	g2d.fillPolygon(this.modele.getForme());
        g2d.setColor(Color.BLACK);
	g2d.drawPolygon(this.modele.getForme());
	g2d.setColor(Color.WHITE);
	g2d.drawString(this.modele.getMessage(), 55, 17);
	super.paintComponent(g);
    }
    
    public Widget(ModeleWidget modele) {
	this.font = new Font("TimesRoman ", Font.PLAIN, 12);
	this.modele = modele;
        this.setFont(this.font);
        this.setFocusable(true);
	this.setOpaque(false);
	this.setForme();
	
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                DragAndDropTools.dragWidget((Widget)e.getComponent());
            }
        });

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                DragAndDropTools.clickWidget((Widget) e.getComponent(), e.getPoint());
                repaintAll(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                DragAndDropTools.dropWidget((Widget)e.getComponent());
            }
        });
    }

    private void repaintAll(MouseEvent e) {
        PanelWidget.getInstance().repaint();
        PanelCodeGraphique.getInstance().repaint();
        Fenetre.getInstance().getGlassPane().repaint();
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
    
    public void decalageXout(int a){
        int i;
        for(i=6;i<10;i++){
            this.modele.getForme().xpoints[i]=this.modele.getForme().xpoints[i]+a;
        }
        this.setForme();
    }
    
    public void decalageXin(int a){
        int i;
        for(i=6;i<10;i++){
            this.modele.getForme().xpoints[i]=this.modele.getForme().xpoints[i]-a;
        }
        this.setForme();
    }
    
    public void decalageYout(int b){
        int i;
        for(i=8;i<16;i++){
            this.modele.getForme().ypoints[i]=this.modele.getForme().ypoints[i]+b;
        }
        this.setForme();
    }
    
    public void decalageYin(int b){
        int i;
        for(i=8;i<16;i++){
            this.modele.getForme().ypoints[i]=this.modele.getForme().ypoints[i]-b;
        }
        this.setForme();
    }

    public ModeleWidget getGComposant() {
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
    
    public TypeWidget getType() {
	return this.modele.getType();
    }
}
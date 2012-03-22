package Vue.Widget;

import Vue.Interface.GlassPane;
import Vue.Interface.PanelCodeGraphique;
import Vue.Interface.PanelWidget;
import Vue.Tools.DragAndDropTools;
import Vue.Widget.modele.ModeleWidget;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

public class Widget extends JComponent implements IWidget {

	public static final float TAUX_TRANSFERT_PANEL = (float) 0.6;
	private Point ptClick;
	private boolean draggable = false;
	private ModeleWidget composant;
	private Font font;
	private IWidget parent;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(this.composant.getCouleur());
		g2d.fillPolygon(this.composant.getForme());
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(this.composant.getForme());
		g2d.setColor(Color.WHITE);
		g2d.drawString(this.composant.getMessage(), 55, 17);
		super.paintComponent(g);
	}

	public Widget(ModeleWidget modele) {
		this.font = new Font("TimesRoman ", Font.PLAIN, 12);
		this.composant = modele;
		this.setFont(this.font);
		this.setFocusable(true);
		this.setOpaque(true);
		this.setForme();

		this.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				DragAndDropTools.getInstance().dragWidget((Widget) e.getComponent());
			}
		});

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				DragAndDropTools.getInstance().clickWidget((Widget) e.getComponent(), e.getPoint());
				repaintAll(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				DragAndDropTools.getInstance().dropWidget();
			}
		});
		this.parent = null;
	}

	private void repaintAll(MouseEvent e) {
		PanelWidget.getInstance().repaint();
		PanelCodeGraphique.getInstance().repaint();
		GlassPane.getInstance().repaint();
	}

	public void setForme() {
		int maxX = 0;
		for (Integer i : this.composant.getForme().xpoints) {
			maxX = Math.max(maxX, i);
		}

		int maxY = 0;
		for (Integer i : this.composant.getForme().ypoints) {
			maxY = Math.max(maxY, i);
		}

		this.setBounds(0, 0, maxX + 1, maxY + 1);
		this.setPreferredSize(new Dimension(maxX, maxY));
	}

	public void decalageXout(int a) {
		int i;
		for (i = 6; i < 10; i++) {
			this.composant.getForme().xpoints[i] = this.composant.getForme().xpoints[i] + a;
		}
		this.setForme();
	}

	public void decalageXin(int a) {
		int i;
		for (i = 6; i < 10; i++) {
			this.composant.getForme().xpoints[i] = this.composant.getForme().xpoints[i] - a;
		}
		this.setForme();
	}

	public void decalageYout(int b) {
		int i;
		for (i = 8; i < 16; i++) {
			this.composant.getForme().ypoints[i] = this.composant.getForme().ypoints[i] + b;
		}
		this.setForme();
	}

	public void decalageYin(int b) {
		int i;
		for (i = 8; i < 16; i++) {
			this.composant.getForme().ypoints[i] = this.composant.getForme().ypoints[i] - b;
		}
		this.setForme();
	}

	public ModeleWidget getGComposant() {
		return this.composant;
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

	public boolean isRacine() {
		return false;
	}
}
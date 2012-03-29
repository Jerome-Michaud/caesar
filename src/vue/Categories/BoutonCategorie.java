package vue.Categories;

import vue.Interface.PanelTypeWidget;
import vue.Interface.PanelWidget;
import vue.Widget.Widget;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;

public abstract class BoutonCategorie extends JComponent {

	private List<Widget> lesWidgets;
	private ModeleCategorie modele;
	private Font font;
	private Color fond;
	private Point defaultPos;
	private boolean active = false;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.modele.getCouleur());
		g2d.fillPolygon(this.modele.getFormeCouleur());
		g2d.setColor(this.fond);
		g2d.fillPolygon(this.modele.getFormeTexte());
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(this.modele.getFormeCouleur());
		g2d.drawPolygon(this.modele.getFormeTexte());
		g2d.setColor(Color.WHITE);
		g2d.setFont(this.font);
		g2d.drawString(this.modele.getMessage(), 15, 17);
		super.paintComponent(g);
	}

	public BoutonCategorie(ModeleCategorie modele) {
		this.font = new Font("TimesRoman", Font.PLAIN, 12);
		this.modele = modele;
		this.fond = Color.LIGHT_GRAY;
		this.setFont(this.font);
		this.setFocusable(true);
		this.setOpaque(false);
		this.setForme();
		this.lesWidgets = new LinkedList<Widget>();

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				sourisEntree();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				sourisSortie();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				sourisRelachee();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				sourisAppuyee();
			}
		});
	}

	public void setForme() {
		int maxX = 0;
		for (Integer i : this.modele.getFormeTexte().xpoints) {
			maxX = Math.max(maxX, i);
		}

		int maxY = 0;
		for (Integer i : this.modele.getFormeTexte().ypoints) {
			maxY = Math.max(maxY, i);
		}

		this.setBounds(0, 0, maxX + 1, maxY + 1);
		this.setPreferredSize(new Dimension(maxX, maxY));
	}

	private void sourisEntree() {
		if (!active) {
			this.fond = new Color(141, 141, 141);
			this.repaint();
		}
	}

	private void sourisSortie() {
		if (!active) {
			this.fond = Color.LIGHT_GRAY;
			this.repaint();
		}
	}

	private void sourisRelachee() {
		this.setLocation(this.defaultPos);
		
		if (!active) {

			for (BoutonCategorie b : PanelTypeWidget.getInstance().getLesCategories()) {
				b.font = new Font("TimesRoman", Font.PLAIN, 12);
				b.fond = Color.LIGHT_GRAY;
				b.active = false;
				b.repaint();
			}
			this.font = new Font("TimesRoman", Font.BOLD, 12);
			this.active = true;
			this.fond = Color.DARK_GRAY;
			PanelWidget.getInstance().setLesWidgets(this.lesWidgets);
		}
	}

	private void sourisAppuyee() {
		this.defaultPos = new Point(this.getLocation());
		Point p = this.getLocation();
		p.x++;
		p.y++;
		this.setLocation(p);
	}

	public void setActive(boolean b) {
		this.active = b;
	}

	public List<Widget> getLesWidgets() {
		return this.lesWidgets;
	}

	protected void ajouterUnWidget(Widget w) {
		this.lesWidgets.add(w);
	}
}
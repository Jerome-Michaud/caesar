package Vue.Categories;

import java.awt.*;
import javax.swing.JComponent;

public class BoutonCategorie extends JComponent {

	private ModeleCategorie modele;
	private Font fontActivee, fontDesactivee;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.modele.getCouleur());
		g2d.fillPolygon(this.modele.getFormeCouleur());
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillPolygon(this.modele.getFormeTexte());
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(this.modele.getFormeCouleur());
		g2d.drawPolygon(this.modele.getFormeTexte());
		g2d.setColor(Color.WHITE);
		g2d.drawString(this.modele.getMessage(), 15, 17);
		super.paintComponent(g);
	}

	public BoutonCategorie(ModeleCategorie modele) {
		this.fontActivee = new Font("TimesRoman ", Font.BOLD, 12);
		this.fontDesactivee = new Font("TimesRoman ", Font.PLAIN, 12);
		this.modele = modele;
		this.setFont(this.fontDesactivee);
		this.setFocusable(true);
		this.setOpaque(false);
		this.setForme();
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
}

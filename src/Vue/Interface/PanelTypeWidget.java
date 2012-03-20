package Vue.Interface;

import Vue.Categories.BoutonCategorie;
import Vue.Categories.ModeleCategorie;
import Vue.Tools.Variables;
import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelTypeWidget extends JPanel {
	private static final PanelTypeWidget instance = new PanelTypeWidget();
	private List<BoutonCategorie> lesCategories;
	
	private PanelTypeWidget() {
		this.setBorder(BorderFactory.createTitledBorder("Catégories"));
		
		this.lesCategories = new LinkedList<BoutonCategorie>();
		this.lesCategories.add(new BoutonCategorie(new ModeleCategorie("Instructions", Color.BLUE)));
		this.lesCategories.add(new BoutonCategorie(new ModeleCategorie("Contrôle", Color.YELLOW)));
		this.lesCategories.add(new BoutonCategorie(new ModeleCategorie("Moteur", Color.GREEN)));
		this.lesCategories.add(new BoutonCategorie(new ModeleCategorie("Affichage", Color.RED)));
		this.lesCategories.add(new BoutonCategorie(new ModeleCategorie("I/O", Color.ORANGE)));
		this.lesCategories.add(new BoutonCategorie(new ModeleCategorie("Temps", Color.CYAN)));
		
		this.setLayout(null);
		int i = 0, x = 10, y = 26;
		do {
			BoutonCategorie b = this.lesCategories.get(i);
			b.setLocation(x, y);
			this.add(b);
			if (i % 2 == 0) {
				x += 10 + b.getWidth();
			}
			else {
				x = 10;
				y += b.getHeight() + 10;
			}
			i++;
		} while (i < this.lesCategories.size());
		
		int nb = this.lesCategories.size() / 2;
		nb = 30 + nb * (Variables.TAILLE_CATEGORIE_Y + 10);
		
		this.setPreferredSize(new Dimension(Variables.xMax, nb));
	}

	public static PanelTypeWidget getInstance() {
		return instance;
	}
}
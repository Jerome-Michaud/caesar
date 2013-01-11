package jscratch.vue.ginterface;

import jscratch.vue.categories.BoutonCategorie;
import vue.tools.Variables;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import jscratch.modeles.DicoBoutonsCategories;

/**
 * Panel où sont entreposés les boutons des différentes catégories disponibles.
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelTypeWidget extends JPanel {

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 */
	private static final PanelTypeWidget instance = new PanelTypeWidget();
	private List<BoutonCategorie> lesCategories;

	private PanelTypeWidget() {
		this.setBorder(BorderFactory.createTitledBorder("Catégories"));

		this.lesCategories = new LinkedList<BoutonCategorie>();
		this.lesCategories.addAll(DicoBoutonsCategories.getInstance().getBoutons());

		this.setLayout(null);
		int i = 0, x = 10, y = 26;
		do {
			BoutonCategorie b = this.lesCategories.get(i);
			b.setLocation(x, y);
			this.add(b);
			if (i % 2 == 0) {
				x += 10 + b.getWidth();
			} else {
				x = 10;
				y += b.getHeight() + 10;
			}
			i++;
		} while (i < this.lesCategories.size());

		int nb = this.lesCategories.size() / 2 + this.lesCategories.size() % 2;
		nb = 30 + nb * (Variables.TAILLE_CATEGORIE_Y + 10);

		this.setPreferredSize(new Dimension(Variables.X_MAX_INSTRUCTION, nb));
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	protected static PanelTypeWidget getInstance() {
		return instance;
	}

	/**
	 * @since 1.0
	 *
	 * @return Les boutons des différentes catégories.
	 */
	public List<BoutonCategorie> getLesCategories() {
		return this.lesCategories;
	}

	/**
	 *
	 * @return le bouton de la categorie sélectionnée ou null si aucune n'est sélectionnée.
	 */
	public BoutonCategorie getCurrentCategorie() {
		for (BoutonCategorie bc : this.getLesCategories()) {
			if (bc.isActive()) {
				return bc;
			}
		}
		return null;


	}
}
package jscratch.vue.ginterface.principales.panels;

import jscratch.vue.categories.boutons.BoutonCategorie;
import jscratch.vue.categories.boutons.BoutonCategorieStructure;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import jscratch.dictionnaires.DicoBoutonsCategories;
import jscratch.parametrages.properties.VariableProperties;
import nxtim.instruction.Categorie;

/**
 * Panel où sont entreposés les boutons des différentes catégories disponibles.
 *
 * @since 1.0
 * @version 1.0
 */
public final class PanelTypeWidget extends JPanel {

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
		nb = 30 + nb * (VariableProperties.TAILLE_CATEGORIE_Y + 10);

		this.setPreferredSize(new Dimension(VariableProperties.X_MAX_INSTRUCTION, nb));
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	public static PanelTypeWidget getInstance() {
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
	 * Permet de connaître la catégorie active.
	 * 
	 * @return la categorie sélectionnée ou null si aucune n'est sélectionnée.
	 */
	public Categorie getCurrentCategorie() {
		for (BoutonCategorie bc : this.getLesCategories()) {
			if (bc.isActive()) {
				return bc.getCategorie();
			}
		}
		return null;
	}
	
	/**
	 * Supression de la tache principale
	 */
	public void supprimerTachePrincipale() {
		for (BoutonCategorie bc : lesCategories) {
			if (bc.getCategorie() == Categorie.STRUCTURES) {
				((BoutonCategorieStructure) bc).supprimerTachePrincipale();				
				
				break;
			}
		}		
	}
	
	/**
	 * Ajout de la tache principale
	 */
	public void ajouterTachePrincipale() {
		for (BoutonCategorie bc : lesCategories) {
			if (bc.getCategorie() == Categorie.STRUCTURES) {
				((BoutonCategorieStructure) bc).ajouterTachePrincipale();
				
				break;
			}
		}
	}
}
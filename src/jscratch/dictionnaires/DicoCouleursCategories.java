package jscratch.dictionnaires;

import java.awt.Color;
import java.util.HashMap;
import nxtim.instruction.Categorie;

/**
 * Permet de stocker les couleurs des catégories.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class DicoCouleursCategories {

	/**
	 * L'instance de <code>DicoCouleursCategories</code>.
	 */
	private static DicoCouleursCategories instance = null;
	/**
	 * Le dico.
	 */
	private HashMap<Categorie, Color> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 * 
	 * @since 1.0
	 */
	private DicoCouleursCategories() {
		this.dico = new HashMap<Categorie, Color>();
		
		this.dico.put(Categorie.STRUCTURES, new Color(230, 126, 77));
		this.dico.put(Categorie.MOTEUR, new Color(133, 205, 68));
		this.dico.put(Categorie.EXPRESSION, new Color(204, 51, 0));
		this.dico.put(Categorie.CAPTEURS, new Color(102, 51, 204));
		this.dico.put(Categorie.TEMPS, new Color(0, 179, 214));
		this.dico.put(Categorie.VARIABLES, new Color(212, 82, 144));
	}
	
	/**
	 * Permet d'avoir l'instance unique de <code>DicoBoutonsCategories</code>.
	 * 
	 * @since 1.0
	 * 
	 * @return l'instance unique de <code>DicoBoutonsCategories</code>
	 */
	public static DicoCouleursCategories getInstance() {
		if (instance == null) {
			instance = new DicoCouleursCategories();
		}
		return instance;
	}
	
	/**
	 * Permet de récupérer la couleur d'une catégorie.
	 * 
	 * @since 1.0
	 * 
	 * @return  la couleur de la catégorie
	 */
	public Color getCouleur(Categorie categorie) {
		return this.dico.get(categorie);
	}
}
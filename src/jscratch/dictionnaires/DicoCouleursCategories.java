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
		
		this.dico.put(Categorie.STRUCTURES, new Color(245, 112, 30));
		this.dico.put(Categorie.MOTEURS,  new Color(136, 193, 0));
		this.dico.put(Categorie.EXPRESSIONS, new Color(229, 64, 40));
		this.dico.put(Categorie.CAPTEURS, new Color(148, 61, 138));
		this.dico.put(Categorie.TEMPS, new Color(0, 161, 203));
		this.dico.put(Categorie.VARIABLES, new Color(233, 78, 119));
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
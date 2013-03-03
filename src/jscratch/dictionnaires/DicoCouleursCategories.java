package jscratch.dictionnaires;

import java.awt.Color;
import java.util.HashMap;
import jscratch.parametrages.properties.VariableProperties;
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
		
		this.dico.put(Categorie.STRUCTURES, VariableProperties.COULEUR_STRUCTURES);
		this.dico.put(Categorie.MOTEURS,  VariableProperties.COULEUR_MOTEURS);
		this.dico.put(Categorie.EXPRESSIONS, VariableProperties.COULEUR_EXPRESSIONS);
		this.dico.put(Categorie.CAPTEURS, VariableProperties.COULEUR_CAPTEURS);
		this.dico.put(Categorie.TEMPS, VariableProperties.COULEUR_TEMPS);
		this.dico.put(Categorie.VARIABLES, VariableProperties.COULEUR_VARIABLES);
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
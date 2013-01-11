package modeles;

import java.awt.Color;
import java.util.HashMap;
import nxtim.instruction.Categorie;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public class DicoCouleursCategories {

	private static DicoCouleursCategories instance = null;
	private HashMap<Categorie, Color> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 */
	private DicoCouleursCategories() {
		this.dico = new HashMap<Categorie, Color>();
		
		this.dico.put(Categorie.INSTRUCTION,new Color(0, 107, 242));
		this.dico.put(Categorie.CONTROLE, new Color(230, 126, 77));
		this.dico.put(Categorie.MOTEUR, new Color(133, 205, 68));
		this.dico.put(Categorie.AFFICHAGE, new Color(204, 51, 0));
		this.dico.put(Categorie.CAPTEURS, new Color(102, 51, 204));
		this.dico.put(Categorie.TEMPS, new Color(0, 179, 214));
		this.dico.put(Categorie.VARIABLES, new Color(212, 82, 144));
		this.dico.put(Categorie.EXPRESSION, new Color(255, 189, 0));
	}
	
	/**
	 * Permet d'avoir l'instance unique de <code>DicoBoutonsCategories</code>.
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
	 * @return  la couleur de la catégorie
	 */
	public Color getCouleur(Categorie categorie) {
		return this.dico.get(categorie);
	}
}
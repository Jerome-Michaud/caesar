package jscratch.dictionnaires;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import nxtim.instruction.Categorie;
import jscratch.vue.categories.boutons.BoutonCategorie;
import jscratch.vue.categories.boutons.BoutonCategorieCapteur;
import jscratch.vue.categories.boutons.BoutonCategorieStructure;
import jscratch.vue.categories.boutons.BoutonCategorieExpression;
import jscratch.vue.categories.boutons.BoutonCategorieMoteur;
import jscratch.vue.categories.boutons.BoutonCategorieTemps;
import jscratch.vue.categories.boutons.BoutonCategorieVariable;

/**
 * Permet de socker les boutons des catégories.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class DicoBoutonsCategories {

	/**
	 * L'instance de <code>DicoBoutonsCategories</code>.
	 */
	private static DicoBoutonsCategories instance = null;
	/**
	 * Le dico.
	 */
	private HashMap<Categorie, BoutonCategorie> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 * 
	 * @since 1.0
	 */
	private DicoBoutonsCategories() {
		this.dico = new LinkedHashMap<Categorie, BoutonCategorie>();
		
		this.dico.put(Categorie.STRUCTURES, new BoutonCategorieStructure());
		this.dico.put(Categorie.MOTEURS, new BoutonCategorieMoteur());
		this.dico.put(Categorie.CAPTEURS, new BoutonCategorieCapteur());
		this.dico.put(Categorie.TEMPS, new BoutonCategorieTemps());
		this.dico.put(Categorie.VARIABLES, new BoutonCategorieVariable());
		this.dico.put(Categorie.EXPRESSIONS, new BoutonCategorieExpression());
	}
	
	/**
	 * Permet d'avoir l'instance unique de <code>DicoBoutonsCategories</code>.
	 * 
	 * @since 1.0
	 * 
	 * @return l'instance unique de <code>DicoBoutonsCategories</code>
	 */
	public static DicoBoutonsCategories getInstance() {
		if (instance == null) {
			instance = new DicoBoutonsCategories();
		}
		return instance;
	}
	
	/**
	 * Permet de récupérer le dictionnaire des boutons catégorie.
	 * 
	 * @since 1.0
	 * 
	 * @return  le dictionnaire des boutons
	 */
	public HashMap<Categorie, BoutonCategorie> getDico() {
		return this.dico;
	}
	
	/**
	 * Perme de récupérer les boutons dans l'ordre où ils doivent être ajoutés dans l'interface.
	 * 
	 * @since 1.0
	 * 
	 * @return la liste des boutons
	 */
	public List<BoutonCategorie> getBoutons() {
		List<BoutonCategorie> l = new LinkedList<BoutonCategorie>();
		l.addAll(this.dico.values());
		
		return l;
	}
	
	/**
	 * Permet de récupérer la liste des catégories importantes, dans l'ordre d'ajout dans l'interface.
	 * 
	 * @since 1.0
	 * 
	 * @return la liste des categories (non vides est importantes)
	 */
	public List<Categorie> getCategories() {
		List<Categorie> l = new LinkedList<Categorie>();
		
		for (Categorie c : this.dico.keySet()) {
			if (!DicoWidgetsCategories.getInstance().getWidgets(c, false).isEmpty() && c != Categorie.EXPRESSIONS) {
				l.add(c);
			}
		}
		
		return l;
	}
}
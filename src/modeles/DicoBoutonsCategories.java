package modeles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import nxtim.instruction.Categorie;
import vue.categories.BoutonCategorie;
import vue.categories.BoutonCategorieAffichage;
import vue.categories.BoutonCategorieCapteur;
import vue.categories.BoutonCategorieControle;
import vue.categories.BoutonCategorieExpression;
import vue.categories.BoutonCategorieInstruction;
import vue.categories.BoutonCategorieMoteur;
import vue.categories.BoutonCategorieTemps;
import vue.categories.BoutonCategorieVariable;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public class DicoBoutonsCategories {

	private static DicoBoutonsCategories instance = null;
	private List<Categorie> ordre;
	private HashMap<Categorie, BoutonCategorie> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 */
	private DicoBoutonsCategories() {
		this.dico = new HashMap<Categorie, BoutonCategorie>();
		
		this.dico.put(Categorie.INSTRUCTION,new BoutonCategorieInstruction());
		this.dico.put(Categorie.CONTROLE, new BoutonCategorieControle());
		this.dico.put(Categorie.MOTEUR, new BoutonCategorieMoteur());
		this.dico.put(Categorie.AFFICHAGE, new BoutonCategorieAffichage());
		this.dico.put(Categorie.CAPTEURS, new BoutonCategorieCapteur());
		this.dico.put(Categorie.TEMPS, new BoutonCategorieTemps());
		this.dico.put(Categorie.VARIABLES, new BoutonCategorieVariable());
		this.dico.put(Categorie.EXPRESSION, new BoutonCategorieExpression());
		
		this.ordre = new LinkedList<Categorie>();
		this.ordre.add(Categorie.INSTRUCTION);
		this.ordre.add(Categorie.CONTROLE);
		this.ordre.add(Categorie.MOTEUR);
		this.ordre.add(Categorie.AFFICHAGE);
		this.ordre.add(Categorie.CAPTEURS);
		this.ordre.add(Categorie.TEMPS);
		this.ordre.add(Categorie.VARIABLES);
		this.ordre.add(Categorie.EXPRESSION);
	}
	
	/**
	 * Permet d'avoir l'instance unique de <code>DicoBoutonsCategories</code>.
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
	 * @return  le dictionnaire des boutons
	 */
	public HashMap<Categorie, BoutonCategorie> getDico() {
		return this.dico;
	}
	
	public List<BoutonCategorie> getBoutons() {
		List<BoutonCategorie> l = new LinkedList<BoutonCategorie>();
		
		for (Categorie c : this.ordre) {
			l.add(this.dico.get(c));
		}
		
		
		return l;
	}
}
package jscratch.dictionnaires;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import jscratch.helpers.PropertiesHelper;
import nxtim.instruction.Categorie;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableModifiable;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.TypeModeleWidget;
import jscratch.vue.widgets.modeles.VariableWidget;

/**
 * Permet de stocker les widgets des différentes catégories.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class DicoWidgetsCategories {

	/**
	 * L'instance de <code>DicoWidgetsCategories</code>.
	 */
	private static DicoWidgetsCategories instance = null;
	/**
	 * Le dico.
	 */
	private LinkedHashMap<Categorie, HashMap<Widget, Boolean>> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 * 
	 * @since 1.0
	 */
	private DicoWidgetsCategories() {
		this.dico = new LinkedHashMap<Categorie, HashMap<Widget, Boolean>>();
		
		this.dico.put(Categorie.STRUCTURES, new LinkedHashMap<Widget, Boolean>());
		this.dico.put(Categorie.MOTEURS, new LinkedHashMap<Widget, Boolean>());
		this.dico.put(Categorie.CAPTEURS, new LinkedHashMap<Widget, Boolean>());
		this.dico.put(Categorie.TEMPS, new LinkedHashMap<Widget, Boolean>());
		this.dico.put(Categorie.VARIABLES, new LinkedHashMap<Widget, Boolean>());
		this.dico.put(Categorie.EXPRESSIONS, new LinkedHashMap<Widget, Boolean>());
	}
	
	/**
	 * Permet d'avoir l'instance unique de <code>DicoBoutonsCategories</code>.
	 * 
	 * @since 1.0
	 * 
	 * @return l'instance unique de <code>DicoBoutonsCategories</code>
	 */
	public static DicoWidgetsCategories getInstance() {
		if (instance == null) {
			instance = new DicoWidgetsCategories();
		}
		return instance;
	}
	
	/**
	 * Permet de récupérer les widgets d'une catégorie.
	 * 
	 * @since 1.0
	 * 
	 * @param categorie 
	 * @return  les widgets
	 */
	public List<Widget> getWidgets(final Categorie categorie, final boolean tri) {
		List<Widget> l = new LinkedList<Widget>();
		Set<Widget> s = this.dico.get(categorie).keySet();
		
		for (Widget w : s) {
			if (!tri || this.dico.get(categorie).get(w)) {
				l.add(w);
			}
		}
		
		return l;
	}

	/**
	 * Permet d'ajouter un widget à la catégorie.
	 * 
	 * @since 1.0
	 * 
	 * @param c la catégorie
	 * @param w le widget
	 */
	public void ajouterWidget(Categorie c, Widget w) {
		this.dico.get(c).put(w, true);
		w.getModele().setCategorie(c);
		w.getModele().setCouleur(DicoCouleursCategories.getInstance().getCouleur(c));
	}
	
	/**
	 * Permet de supprimer un widget à la catégorie.
	 * 
	 * @since 1.0
	 * 
	 * @param c la catégorie
	 * @param w le widget
	 */
	public void supprimerWidget(Categorie c, Widget w) {
		this.dico.get(c).remove(w);
	}
	
	public void remplacerWidgetDansCategorie(Categorie c, Widget oldWidget,Widget newWidget){
		HashMap<Widget,Boolean> oldMap = this.dico.get(c);
		HashMap<Widget,Boolean> newMap = new LinkedHashMap<Widget, Boolean>();
		for(Widget w : oldMap.keySet()){
			boolean val = oldMap.get(w);
			if(w.equals(oldWidget)){
				newMap.put(newWidget, val);
			}else{
				newMap.put(w,val);
			}
		}
		
		dico.put(c, newMap);
	}
	
	/**
	 * Permet d'ajouter une variable.
	 * 
	 * @since 1.0
	 * 
	 * @param var la variable à ajouter
	 */
	public void updateWidgetsVariables() {
		Variable[] vars = DicoVariables.getInstance().getLesvariables();
		this.dico.get(Categorie.VARIABLES).clear();
		ajouterWidget(Categorie.VARIABLES, GUI.getPanelWidget().getFabrique().creerWidgetVariableSetValue());
		
		// Permet d'afficher ou non le widget de valeur
		nettoyer(Categorie.VARIABLES);
		
		for (Variable var : vars) {
			Widget w = GUI.getPanelWidget().getFabrique().creerWidgetVariable((VariableModifiable) var);
			w.getModele().setCategorie(Categorie.VARIABLES);
			w.getModele().setCouleur(DicoCouleursCategories.getInstance().getCouleur(Categorie.VARIABLES));
			this.dico.get(Categorie.VARIABLES).put(w, true);
		}
	}

	/**
	 * Permet de supprimer une variable.
	 * 
	 * @since 1.0
	 * 
	 * @param variable la variable à supprimer
	 */
	public void supprimerWidgetVariable(String variable) {
		HashMap<Widget, Boolean> l = this.dico.get(Categorie.VARIABLES);
		
		for (int i = 0;i < l.size();i++) {
			Widget w = (Widget)l.keySet().toArray()[i];
			
			if (w.getModele().getType() == TypeModeleWidget.VARIABLE && variable.equals(((VariableWidget)w.getModele()).getNomVariable())) {
				l.remove(w);
				break;
			}
		}
	}

	/**
	 * Permet de nettoyer toutes les listes de widgets en fonction des properties.
	 * 
	 * @since 1.0
	 */
	public void nettoyer() {
		for (Categorie c : this.dico.keySet()) {
			nettoyer(c);
		}
	}
	
	/**
	 * Permet de nettoyer la liste des widgets en fonction des properties.
	 * 
	 * @since 1.0
	 * 
	 * @param c la catégorie à nettoyer
	 */
	private void nettoyer(Categorie c) {
		HashMap<Widget, Boolean> categorie = this.dico.get(c);
		for (Widget w : categorie.keySet()) {
			Boolean b = Boolean.valueOf(PropertiesHelper.getInstance().get("user.widget.afficher." + w.getType().toString()));
			categorie.put(w, b);
		}
	}
}

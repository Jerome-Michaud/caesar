package jscratch.dictionnaires;

import java.util.Collection;
import java.util.HashMap;
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
 *
 * @since 1.0
 * @version 1.0
 */
public class DicoWidgetsCategories {

	private static DicoWidgetsCategories instance = null;
	private HashMap<Categorie, HashMap<Widget, Boolean>> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 */
	private DicoWidgetsCategories() {
		this.dico = new HashMap<Categorie, HashMap<Widget, Boolean>>();
		
		this.dico.put(Categorie.STRUCTURES, new HashMap<Widget, Boolean>());
		this.dico.put(Categorie.MOTEUR, new HashMap<Widget, Boolean>());
		this.dico.put(Categorie.CAPTEURS, new HashMap<Widget, Boolean>());
		this.dico.put(Categorie.TEMPS, new HashMap<Widget, Boolean>());
		this.dico.put(Categorie.VARIABLES, new HashMap<Widget, Boolean>());
		this.dico.put(Categorie.EXPRESSION, new HashMap<Widget, Boolean>());
	}
	
	/**
	 * Permet d'avoir l'instance unique de <code>DicoBoutonsCategories</code>.
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
	 * @param c la catégorie
	 * @param w le widget
	 */
	public void supprimerWidget(Categorie c, Widget w) {
		this.dico.get(c).remove(w);
	}
	
	/**
	 * Permet d'ajouter une variable.
	 * 
	 * @param var la variable à ajouter
	 */
	public void updateWidgetsVariables() {
		Variable[] vars = DicoVariables.getInstance().getLesvariables();
		List<Widget> widgetsVar = DicoWidgetsCategories.getInstance().getWidgets(Categorie.VARIABLES, true);
		
		// Suppression des widgets variables
		for (int i = 0;i < widgetsVar.size();i++) {
			if (!widgetsVar.get(i).getType().equals(TypeModeleWidget.SETVALUEVARIABLE)) {
				widgetsVar.remove(widgetsVar.get(i));
			}
		}
		
		for (Variable var : vars) {
			Widget w = GUI.getPanelWidget().getFabrique().creerWidgetVariable((VariableModifiable) var);
			w.getModele().setCategorie(Categorie.VARIABLES);
			w.getModele().setCouleur(DicoCouleursCategories.getInstance().getCouleur(Categorie.VARIABLES));
			widgetsVar.add(w);
		}
	}

	/**
	 * Permet de supprimer une variable.
	 * 
	 * @param variable la variable à supprimer
	 */
	public void supprimerWidgetVariable(String variable) {
		List<Widget> l = (List<Widget>)this.dico.get(Categorie.VARIABLES);
		
		for (int i = 0;i < l.size();i++) {
			if (l.get(i).getModele() instanceof VariableWidget) {
				if (variable.equals(((VariableWidget)l.get(i).getModele()).getNomVariable())) {
					l.remove(l.get(i));
					break;
				}
			}
		}
	}

	/**
	 * Permet de nettoyer la liste des widgets en fonction des properties.
	 */
	public void nettoyer() {
		Collection<HashMap<Widget, Boolean>> categories = this.dico.values();
		for (HashMap<Widget, Boolean> h : categories) {
			for (Widget w : h.keySet()) {
				Boolean b = Boolean.valueOf(PropertiesHelper.getInstance().get("user.widget.afficher." + w.getType().toString()));
				h.put(w, b);
			}
		}
	}

	/**
	 * Permet de supprimer tous les widgets présents dans toutes les catégories.
	 */
	public void reset() {
		for (HashMap<Widget, Boolean> h : this.dico.values()) {
			h.clear();
		}
	}
}

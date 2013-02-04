package jscratch.dictionnaires;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public class DicoWidgetsCategories {

	private static DicoWidgetsCategories instance = null;
	private HashMap<Categorie, List<Widget>> dico;
	private boolean nettoye = false;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 */
	private DicoWidgetsCategories() {
		this.dico = new HashMap<Categorie, List<Widget>>();
		
		this.dico.put(Categorie.STRUCTURES, new LinkedList<Widget>());
		this.dico.put(Categorie.MOTEUR, new LinkedList<Widget>());
		this.dico.put(Categorie.CAPTEURS, new LinkedList<Widget>());
		this.dico.put(Categorie.TEMPS, new LinkedList<Widget>());
		this.dico.put(Categorie.VARIABLES, new LinkedList<Widget>());
		this.dico.put(Categorie.EXPRESSION, new LinkedList<Widget>());
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
	 * @param tri la liste renvoyée est une COPIE dans le cas ou le paramètre est à <code>true</code>, sinon, c'est l'originale.
	 * @return  les widgets
	 */
	public List<Widget> getWidgets(final Categorie categorie, final boolean tri) {
		if (!this.nettoye && tri) {
			nettoyer();
		}
		return this.dico.get(categorie);
	}

	/**
	 * Permet d'ajouter un widget à la catégorie.
	 * 
	 * @param c la catégorie
	 * @param w le widget
	 */
	public void ajouterWidget(Categorie c, Widget w) {
		this.dico.get(c).add(w);
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
	private void nettoyer() {
		Collection<List<Widget>> categories = this.dico.values();
		for (List<Widget> l : categories) {
			for (int i = 0;i < l.size();i++) {
				if (!Boolean.valueOf(PropertiesHelper.getInstance().get("user.widget.afficher." + l.get(i).getType().toString()))) {
					l.remove(l.get(i));
				}
			}
		}
	}
}
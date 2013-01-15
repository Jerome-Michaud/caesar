package jscratch.modeles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import nxtim.instruction.Categorie;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableModifiable;
import jscratch.vue.ginterface.GUI;
import jscratch.vue.widget.Widget;
import jscratch.vue.widget.modele.VariableWidget;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public class DicoWidgetsCategories {

	private static DicoWidgetsCategories instance = null;
	private HashMap<Categorie, List<Widget>> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 */
	private DicoWidgetsCategories() {
		this.dico = new HashMap<Categorie, List<Widget>>();
		
		this.dico.put(Categorie.INSTRUCTION, new LinkedList<Widget>());
		this.dico.put(Categorie.CONTROLE, new LinkedList<Widget>());
		this.dico.put(Categorie.MOTEUR, new LinkedList<Widget>());
		this.dico.put(Categorie.AFFICHAGE, new LinkedList<Widget>());
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
	 * @return  les widgets
	 */
	public List<Widget> getWidgets(Categorie categorie) {
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
	public void ajouterWidgetVariable(Variable var) {
		List<Widget> l = (List<Widget>)this.dico.get(Categorie.VARIABLES);
		Widget w = GUI.getPanelWidget().getFabrique().creerWidgetVariable((VariableModifiable) var);
		w.getModele().setCategorie(Categorie.VARIABLES);
		w.getModele().setCouleur(DicoCouleursCategories.getInstance().getCouleur(Categorie.VARIABLES));
		l.add(w);
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
}
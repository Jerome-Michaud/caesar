/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
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
		Variable[] vars = DicoVariables.getInstance().getLesVariables();
		this.dico.get(Categorie.VARIABLES).clear();
		ajouterWidget(Categorie.VARIABLES, GUI.getPanelWidget().getFabrique().creerWidgetVariableSetValue());
		ajouterWidget(Categorie.VARIABLES, GUI.getPanelWidget().getFabrique().creerWidgetDeclarerVariable());
		
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
	
	/**
	 * Permet de cacher un widget dans la catégorie
	 * @param c la catégorie
	 * @param w le widget
	 */
	public void cacherWidget(Categorie c, Widget w) {
		this.dico.get(c).put(w, false);	
	}
	
	/**
	 * Permet d'afficher un widget dans la catégorie
	 * @param c la catégorie
	 * @param w le widget
	 */
	public void afficherWidget(Categorie c, Widget w) {
		this.dico.get(c).put(w, true);
	}
}

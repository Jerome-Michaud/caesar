package vue.tools;

import vue.ginterface.PanelCodeGraphique;
import vue.widget.Widget;
import vue.widget.WidgetCompose;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe implémentant le design pattern Singleton permettant de gérer l'arborescence modélisant
 * l'arborescence des widgets (compositions des widgets complexes, groupe de widgets) au sens graphique du terme.
 */
public final class ArborescenceTools {

	/**
	 * Liste de liste de widgets représentant chaques groupes de widget présents à l'écran.
	 */
	private List<List<Widget>> arborescence;
	/**
	 * Instance statique unique de la classe.
	 */
	private static ArborescenceTools instance = new ArborescenceTools();

	/**
	 * Constructeur privé de la classe initialisant l'arborescence.
	 */
	private ArborescenceTools() {
		this.arborescence = new LinkedList<List<Widget>>();
	}

	/**
	 * Méthode statique permettant de récupérer l'instance unique de la classe.
	 *
	 * @return L'instance unique de la classe
	 */
	public static ArborescenceTools getInstance() {
		return instance;
	}

	/**
	 * Récupération de l'arborescence.
	 *
	 * @return Une liste de liste de widgets modélisant chaque groupe de widgets à l'écran.
	 */
	public List<List<Widget>> getArborescence() {
		return arborescence;
	}

	/**
	 * Méthode permettant de récupérer le widget le plus haut du groupe de widgets associé au widget passé en paramètre.
	 *
	 * @param comp Le widget pour lequel on veut récuperer le widget le plus en haut du groupe
	 * @return Le widget le plus en haut su groupe de widget auquel appartient le widget passé en paramètre.
	 * @throws ComposantIntrouvableException Si le widget passé en paramètre est introuvable dans l'arborescence
	 */
	public Widget getPremier(final Widget comp) throws ComposantIntrouvableException {
		return getListe(comp).get(0);
	}

	/**
	 * Méthode permettant de récuperer la liste de widgets modélisant le groupe auquel appartient le widget passé en paramètre.
	 *
	 * @param comp Le widget pour lequel on veut récuperer le group auquel il appartient
	 * @return Une liste e widget représentant le groupe de widgets qui contient le widget passé en paramètre
	 * @throws ComposantIntrouvableException Si le widget passé en paramètre est introuvable dans l'arborescence
	 */
	public List<Widget> getListe(final Widget comp) throws ComposantIntrouvableException {
		if (comp.parent() == null) {
			List<Widget> l = new LinkedList<Widget>();
			l.add(comp);
			return l;
		}
		else {
			if (!comp.parent().isRacine()) {
				WidgetCompose parent = (WidgetCompose) (comp.parent());
				return parent.getWidgetsAssocies(comp);
			}
			else {
				for (List<Widget> lst : arborescence) {
					if (lst.contains(comp)) {
						return lst;
					}
				} // Ne devrait jamais arriver
				throw new ComposantIntrouvableException("Composant non trouvé dans l'arborescence (getPremier())");
			}
		}
	}

	/**
	 * Méthode permettant de récupérer la position du widget passé en paramètre au sein du groupe de widgets auquel il appartient.
	 *
	 * @param comp L'indice du widget pour lequel on veut récupérer la position au sein de son groupe
	 * @return La position du widget au sein de groupe de widgets
	 * @throws ComposantIntrouvableException Si le widget passé en paramètre est introuvable dans l'arborescence
	 */
	public int getIndex(final Widget comp) throws ComposantIntrouvableException {
		return getListe(comp).indexOf(comp);
	}

	/**
	 * Méthode permettant d'ajouter au groupe du widget passé en paramètre (comp) un autre groupe de widgets.
	 *
	 * @param l La liste de widgets à insérer dans le groupe du widget comp
	 * @param comp Le widget au groupe duquel on veut ajouter la liste de widgets
	 * @param insererApres Permet de définir si on veut ajouter la groupe de widgets avant ou après le widget passé en paramètre
	 * @return Le résultat de l'ajout de la liste de widgets au sein du groupe de widgets de comp
	 * @throws ComposantIntrouvableException Si le widget passé en paramètre est introuvable dans l'arborescence
	 */
	public boolean ajouterWidgets(final List<Widget> l, final Widget comp, final boolean insererApres) throws ComposantIntrouvableException {
		//cas de non survol
		if (comp == null) {
			List<Widget> lst = new LinkedList<Widget>();
			lst.addAll(l);
			return arborescence.add(lst);
		}
		else {
			int index = getIndex(comp);

			if (insererApres) {
				index++;
			}
			return getListe(comp).addAll(index, l);
		}
	}

	/**
	 * Méthode permettant de supprimer une liste de widgets au groupe de widgets associé au premier élément de la liste passée en paramètre.
	 *
	 * @param l La liste de widgets à supprimer du groupe associé au premier élèment de la liste
	 * @return Le résultat de la suppression dans le groupe de widgets
	 * @throws ComposantIntrouvableException Si le widget passé en paramètre est introuvable dans l'arborescence
	 */
	public boolean supprimerWidgets(final List<Widget> l) throws ComposantIntrouvableException {
		return getListe(l.get(0)).removeAll(l);
	}

	/**
	 * Méthode permettant de récupérer les widgets situés après le widget passé en paramètre au sein de son groupe.
	 *
	 * @param comp Le widget pour lequel on veut récupérer ses suivants au sein de son groupe
	 * @param inclutComp Permet de définir si l'on souhaite ou non intégrer le widget passé en paramètre à la liste retournée
	 * @return La liste des widgets situés après dans le groupe de widgets de comp
	 * @throws ComposantIntrouvableException Si le widget passé en paramètre est introuvable dans l'arborescence
	 */
	public List<Widget> getSuivants(final Widget comp, final boolean inclutComp) throws ComposantIntrouvableException {
		int indexDebut = getIndex(comp);
		if (!inclutComp) {
			indexDebut++;
		}
		List<Widget> l = getListe(comp);
		return l.subList(indexDebut, l.size());

	}

	/**
	 * Méthode permettant de récupérer les widgets situés après le widget passé en paramètre au sein de son groupe.
	 *
	 * @param comp Le widget pour lequel on veut récupérer ses suivants au sein de son groupe
	 * @return La liste des widgets situés après dans le groupe de widgets de comp
	 * @throws ComposantIntrouvableException Si le widget passé en paramètre est introuvable dans l'arborescence
	 */
	public List<Widget> getSuivants(final Widget comp) throws ComposantIntrouvableException {
		return getSuivants(comp, false);
	}

	/**
	 * Méthode permettant d'initialiser l'arborescence à vide au moment du lancement du programme, ou à une
	 * autre arborescence complètement nouvelle au moment du chargement d'un projet sauvegardé.
	 *
	 * @param l La liste de liste de widgets symbolisant la nouvelle arborescence à attribuer au programme
	 * @param initListeners Valeur booléenne indiquant si on veut initialiser les listeners de chaque widget
	 * (cas du chargement d'une projet sauvegardé) ou non (cas du lancement du programme)
	 */
	public void initArborescence(final List<List<Widget>> l, final boolean initListeners) {
		this.arborescence = l;
		for (List<Widget> ls : l) {
			setArborescence(ls, initListeners);
		}
	}

	/**
	 * Méthode récursive permettant d'associer à l'arborescence graphique du programme chaque widget.<br.>
	 * Cette méthode est appelée récursivement lorsque le widget qui doit être ajouté à l'arborescence est complexe,
	 * afin d'ajouter à l'arborescence ses widgets fils.
	 *
	 * @param liste la liste des widgets à ajouter dans l'arborescence
	 * @param initListener Valeur booléenne indiquant si on veut initialiser les listeners de chaque widget
	 * (cas du chargement d'une projet sauvegardé) ou non (cas du lancement du programme)
	 */
	public void setArborescence(final List<Widget> liste, final boolean initListener) {
		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		p.removeAll();

		for (Widget w : liste) {
			p.add(w);
			if (initListener) {
				w.initListeners();
			}
			if (w.isComplexe()) {
				for (List<Widget> lst : ((WidgetCompose) w).getMapZone().values()) {
					setArborescence(lst, initListener);
				}
			}
		}
		PanelCodeGraphique.getInstance().repaint();
	}
}
package vue.tools;

import vue.ginterface.PanelCodeGraphique;
import vue.widget.Widget;
import vue.widget.WidgetCompose;

import java.util.LinkedList;
import java.util.List;

public class ArborescenceTools {

	private List<List<Widget>> arborescence;
	private static ArborescenceTools instance = new ArborescenceTools();

	private ArborescenceTools() {
		this.arborescence = new LinkedList<List<Widget>>();
	}

	public static ArborescenceTools getInstance() {
		return instance;
	}

	public List<List<Widget>> getArborescence() {
		return arborescence;
	}

	public Widget getPremier(Widget comp) throws ComposantIntrouvableException {
		return getListe(comp).get(0);
	}

	public List<Widget> getListe(Widget comp) throws ComposantIntrouvableException {
		if (comp.parent() == null) {
			List<Widget> l = new LinkedList<Widget>();
			l.add(comp);
			return l;
		} else {
			if (!comp.parent().isRacine()) {
				WidgetCompose parent = (WidgetCompose) (comp.parent());
				return parent.getWidgetsAssocies(comp);
			} else {
				for (List<Widget> lst : arborescence) {
					if (lst.contains(comp)) {
						return lst;
					}
				}// Ne devrait jamais arriver
				throw new ComposantIntrouvableException("Composant non trouvé dans l'arborescence (getPremier())");
			}
		}
	}

	public int getIndex(Widget comp) throws ComposantIntrouvableException {
		return getListe(comp).indexOf(comp);
	}

	public boolean ajouterWidgets(List<Widget> l, Widget comp, boolean insererApres) throws ComposantIntrouvableException {
		//cas de non survol
		if (comp == null) {
			List<Widget> lst = new LinkedList<Widget>();
			lst.addAll(l);
			return arborescence.add(lst);
		} else {
			int index = getIndex(comp);

			if (insererApres) {
				index++;
			}
			return getListe(comp).addAll(index, l);
		}
	}

	public boolean supprimerWidgets(List<Widget> l) throws ComposantIntrouvableException {
		return getListe(l.get(0)).removeAll(l);
	}

	public List<Widget> getSuivants(Widget comp, boolean inclutComp) throws ComposantIntrouvableException {
		int indexDebut = getIndex(comp);
		if (!inclutComp) {
			indexDebut++;
		}
		List<Widget> l = getListe(comp);
		return l.subList(indexDebut, l.size());

	}

	public List<Widget> getSuivants(Widget comp) throws ComposantIntrouvableException {
		return getSuivants(comp, false);
	}

	public void initArborescence(List<List<Widget>> l, boolean initListeners) {
		this.arborescence = l;
		for (List<Widget> ls : l) {
			setArborescence(ls, initListeners);
		}
	}

	public void setArborescence(List<Widget> liste, boolean initListener) {

		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		p.removeAll();


		for (Widget w : liste) {
			p.add(w);
			if (initListener) {
				w.initListeners();
			}
			if (w.isComplexe()) {
				for (List<Widget> lst : ((WidgetCompose)w).getMapZone().values()) {
					setArborescence(lst, initListener);
				}
			}
		}
		PanelCodeGraphique.getInstance().repaint();
	}
}

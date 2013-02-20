package jscratch.vue.arborescence;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import javax.swing.SwingUtilities;

import nxtim.instruction.Categorie;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.exceptions.ComposantIntrouvableException;
import jscratch.exceptions.NonClonableException;
import jscratch.helpers.ErreurHelper;
import jscratch.traduction.LanceurTraduction;
import jscratch.vue.arborescence.actions.Action;
import jscratch.vue.categories.boutons.BoutonCategorie;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.principales.panels.GlassPane;
import jscratch.vue.ginterface.principales.panels.PanelCodeGraphique;
import jscratch.vue.ginterface.principales.panels.PanelTypeWidget;
import jscratch.vue.ginterface.principales.panels.PanelWidget;
import jscratch.vue.widgets.IWidget;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.WidgetCompose;
import jscratch.vue.widgets.modeles.ModeleWidget;
import jscratch.vue.widgets.modeles.TypeModeleWidget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import jscratch.vue.widgets.modeles.zones.Zone;

/**
 * Classe implémentant le design pattern Singleton permettant de gérer le
 * système de drag & drop.
 *
 * @since 1.0
 * @version 1.0
 */
public final class DragAndDropTools extends Observable {

	/**
	 * List de widgets contenant les widgets en cours de draggage.
	 */
	private List<Widget> composantsDrague;
	/**
	 * Instance statique unique de la Classe.
	 */
	private static DragAndDropTools instance = new DragAndDropTools();

	/**
	 * Constructeur privé de la classe initialisant la liste de widgets à vide.
	 */
	private DragAndDropTools() {
		this.composantsDrague = new LinkedList<Widget>();
		this.addObserver(GUI.getGlassPane());
		this.addObserver(GUI.getPanelCodeGraphique());
		this.addObserver(GUI.getPanelWidget());
	}

	/**
	 * Méthode statique permettant de récupérer l'instance unique de la classe.
	 *
	 * @return L'instance unique de la classe.
	 */
	public static DragAndDropTools getInstance() {
		return instance;
	}

	/**
	 * Méthode appelée lors du clic sur un widget. Cette méthode va déplacer le
	 * widget cliqué ainsi que tous les widgets attachés sous lui sur le
	 * GlassPane et enlever ces derniers du PanelCodeGraphique.
	 *
	 * @param comp Le composant cliqué
	 * @param ptClick Le point où a eu lieu le clique au sein du widget
	 */
	public void clickWidget(Widget comp, Point ptClick) {
		comp.setPtClick(ptClick);
		ArborescenceTools arbo = ArborescenceTools.getInstance();
		if (!comp.isDraggable()) {
			comp.setDraggable(true);
			Widget compNouv;
			
			// Si c'est la tache main, on supprime le widget du panel
			if (comp.getType() == TypeModeleWidget.TACHE) {
				PanelTypeWidget.getInstance().supprimerTachePrincipale();
			}
			else { // sinon on remplace par un nouveau widget
				try {
					PanelWidget pw = GUI.getPanelWidget();
					compNouv = pw.getFabrique().cloner(comp);
					compNouv.setBounds(comp.getBounds());
					pw.getPanelDeWidget().add(compNouv);
					int ind = pw.getIndex(comp);
					pw.supprimerWidget(comp);
					pw.ajouterWidget(compNouv, ind);
					DicoWidgetsCategories.getInstance().remplacerWidgetDansCategorie(GUI.getPanelTypeWidget().getCurrentCategorie(), comp, compNouv);
				} catch (NonClonableException ex) {
					ErreurHelper.afficher(ex);
				}
			}
			composantsDrague = new LinkedList<Widget>();
			composantsDrague.add(comp);
			
		} else {
			try {
				//recuperation et detachement des widgets dragués
				composantsDrague = new LinkedList<Widget>(arbo.getSuivants(comp, true));

				//supression des widgets dans l'arborescence
				arbo.supprimerWidgets(composantsDrague);

				if ((comp != null) && (comp.parent() != null) && (!comp.parent().isRacine())) {
					((Widget) comp.parent()).applyChangeModele();
				}

				comp.defParent(null);
			} catch (ComposantIntrouvableException ex) {
				ErreurHelper.afficher(ex);
			}
		}

		for (Widget w : composantsDrague) {
			passerSurAutrePanel(w, GUI.getGlassPane());
		}

		Point p = GUI.getGlassPane().getMousePosition();
		p.x -= ptClick.x;
		p.y -= ptClick.y;

		dragGroupeWidget(composantsDrague, p);

		arbo.updateWidgets();

		updatePanelGraphiqueSize(arbo.getArborescence());
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Méthode récursive permettant de passer un widget d'un conteneur à
	 * l'autre. Si le widget passé en paramètre est de type complexe, cette
	 * méthode est de nouveau appelée pour chacun de ses fils.
	 *
	 * @param wi Le widget à passer sur un autre Panel
	 * @param destination Le panel de destination du widget
	 */
	public void passerSurAutrePanel(Widget wi, Container destination) {
		if (wi.isComplexe()) {
			for (List<Widget> lw : ((WidgetCompose) wi).getMapZone().values()) {
				for (Widget w : lw) {
					passerSurAutrePanel(w, destination);
				}
			}
		}
		Point p = wi.getLocationOnScreen();
		SwingUtilities.convertPointFromScreen(p, destination);
		wi.setLocation(p);
		wi.getParent().remove(wi);
		destination.add(wi);
	}

	/**
	 * Méthode permettant de déplacer un groupe de widgets selon un point
	 * particulier.
	 *
	 * @param lst La liste de widgets à déplacer
	 * @param p Le Point à partir duquel il faut placer le widget
	 */
	public void dragGroupeWidget(List<Widget> lst, Point p) {
		for (Widget w : lst) {
			w.setLocation(p.x, p.y);
			if (w.isComplexe()) {
				WidgetCompose wComp = (WidgetCompose) w;
				wComp.notifyChange();
			}
			p.y += w.getHeight() - ModeleWidget.OFFSET;
		}
	}

	/**
	 * Méthode appelée lors du drag de la souris. Cette méthode va déplacer sur
	 * le GlassPane les widgets en cours de drag.
	 *
	 * @param comp Le widget où a eu lieu l'événement souris d'origine
	 */
	public void dragWidget(Widget comp) {
		if (comp.isDraggable()) {
			Point ptClick = comp.getPtClick();
			Point p = MouseInfo.getPointerInfo().getLocation();
			Point diff = new Point((int)(GUI.getZoneUtilisateur().getLocationOnScreen().getX() - GUI.getFenetre().getViewport().getLocationOnScreen().getX() + 5),(int)(GUI.getZoneUtilisateur().getLocationOnScreen().getY() - GUI.getFenetre().getViewport().getLocationOnScreen().getY() + 5));
			Rectangle recZoneUtil = new Rectangle((int)(GUI.getZoneUtilisateur().getLocationOnScreen().getX() - diff.getX()), (int)(GUI.getZoneUtilisateur().getLocationOnScreen().getY() - diff.getY()), GUI.getZoneUtilisateur().getWidth(), GUI.getZoneUtilisateur().getHeight());
			Rectangle boundsGroup = groupeWidgetBounds(composantsDrague, 0, null);
			if (boundsGroup == null) {
				boundsGroup = new Rectangle();
			}

			Rectangle recWid = new Rectangle(new Point((int) (MouseInfo.getPointerInfo().getLocation().x - ptClick.getX() - diff.getX()), (int) (MouseInfo.getPointerInfo().getLocation().y - ptClick.getY()- diff.getY())), new Dimension((int) boundsGroup.getWidth(), (int) boundsGroup.getHeight()));
			recZoneUtil.setBounds(recZoneUtil.getBounds().x, recZoneUtil.getBounds().y, recZoneUtil.getBounds().width, recZoneUtil.getBounds().height);

			if (!recZoneUtil.contains(recWid)) {
				boolean noX = false;
				if (recWid.getMinX() <= recZoneUtil.getMinX()) {
					// A gauche
					p.x = (int) recZoneUtil.getMinX();
					p.y -= ptClick.y + diff.getY();
					noX = true;
				} else if (recWid.getMaxX() > recZoneUtil.getMaxX()) {
					// A droite
					p.x = (int) recZoneUtil.getMaxX() - recWid.width;
					p.y -= ptClick.y + diff.getY();
					noX = true;
				}

				if (recWid.getMinY()<= recZoneUtil.getMinY()) {
					// En haut
					p.y = (int) recZoneUtil.getMinY();
					if (!noX) {
						p.x -= ptClick.x + diff.getX();
					}
				} else if (recWid.getMaxY() >= recZoneUtil.getMaxY()) {
					// En bas
					p.y = (int) recZoneUtil.getMaxY() - recWid.height;
					if (!noX) {
						p.x -= ptClick.x + diff.getX();
					}
				}
			} else {
				p.x -= ptClick.x + diff.getX();
				p.y -= ptClick.y + diff.getY();
			}
			p.x -= GUI.getFenetre().getLocation().getX();
			p.y -= GUI.getFenetre().getLocation().getY();
			dragGroupeWidget(composantsDrague, p);

			this.setChanged();
			this.notifyObservers();
			int decal = (int) (Widget.TAUX_TRANSFERT_PANEL * comp.getWidth());
			int inter = (int) (boundsGroup.getMaxX() - GUI.getPanelCodeGraphique().getScroll().getBounds().getMinX());
			GlassPane g = GUI.getGlassPane();
			if (inter < decal) {
				Point ptDel = new Point(comp.getLocation());
				ptDel.translate(-20, -20);
				g.setDeleteIconPosition(ptDel);
			} else {
				g.setDeleteIconPosition(null);
			}
			FusionTools.dessinerIndicateursFusion(comp);

		}
	}

	/**
	 * Méthode appelée lors du relâchement de la souris après avoir dragué des
	 * composants.
	 */
	public void dropWidget() {
		Widget comp = composantsDrague.get(0);

		Action a = FusionTools.checkSurvolWidgetV2(comp);
		PanelCodeGraphique p = GUI.getPanelCodeGraphique();
		GlassPane g = GUI.getGlassPane();
		Rectangle r = (Rectangle) comp.getBounds().clone();

		Point pt = comp.getLocationOnScreen();

		int decal = (int) (Widget.TAUX_TRANSFERT_PANEL * comp.getWidth());
		int inter = (int) (r.getMaxX() - p.getScroll().getBounds().getMinX());
		ArborescenceTools arbo = ArborescenceTools.getInstance();
		boolean complexe = false;
		Widget compSurvole = null;
		try {
			if (inter >= decal) {
				p.add(comp);

				SwingUtilities.convertPointFromScreen(pt, p);
				if (inter < comp.getWidth()) {
					pt.x += (comp.getWidth() - inter) + (GUI.getZoneUtilisateur().getLocationOnScreen().getX() - GUI.getFenetre().getViewport().getLocationOnScreen().getX() + 5);
			
				}

				compSurvole = a.getComp();

				if (a.getVal() == 3) {
					Zone z = compSurvole.getModele().getLesZonesSaisies().get(a.getZoneIndex());
					((ChampTexte) z).setWidgetContenu(composantsDrague.get(0));
				} else {
					switch (a.getVal()) {
						case 1:
							//Au dessus du compSurvole
							arbo.ajouterWidgets(composantsDrague, compSurvole, false);
							break;

						case 0:
							//En dessous du compSurvole
							arbo.ajouterWidgets(composantsDrague, compSurvole, true);
							break;

						case -1:
							//Aucun survol
							arbo.ajouterWidgets(composantsDrague, compSurvole, true);
							break;

						case 2:
							//Survol d'une zone d'accroche
							WidgetCompose wComp = (WidgetCompose) (a.getComp());
							List<Widget> lst = wComp.getMapZone().get(a.getRect());
							lst.addAll(composantsDrague);
							break;

					}

					for (Widget w : composantsDrague) {

						passerSurAutrePanel(w, p);

						if (compSurvole == null) {
							w.defParent((IWidget) p);//gestion du parent suivant element survole
						} else {
							//Survol d'une zone d'accroche
							if (a.getVal() == 2) {
								complexe = true;
								w.defParent((WidgetCompose) compSurvole);
							} else {
								w.defParent(compSurvole.parent());
							}
						}
					}

					if (compSurvole != null && compSurvole.isComplexe()) {
						//((WidgetCompose) compSurvole).applyChangeModele();
						if (a.getVal() == 2) {
							((WidgetCompose) compSurvole).applyChangeModele();
						} else {
							if (compSurvole.parent() != null && !compSurvole.parent().isRacine()) {
								((WidgetCompose) compSurvole.parent()).applyChangeModele();
							}
						}
					} else if (compSurvole != null && !compSurvole.isComplexe() && compSurvole.parent() != null && !compSurvole.parent().isRacine()) {
						((WidgetCompose) compSurvole.parent()).applyChangeModele();
					}
				}
			} else {
				arbo.supprimerWidgets(composantsDrague);
				for (Widget w : composantsDrague) {
					deleteWidgetsFromGlassPane(w);
				}
			}
			switch (a.getVal()) {
				case 1:
					//Au dessus du compSurvole
					Rectangle bnds = groupeWidgetBounds(arbo.getListe(comp), composantsDrague.size(), null);
					if (bnds == null) {
						bnds = new Rectangle();
					}
					pt = bnds.getLocation();
					for (Widget w : composantsDrague) {
						pt.y -= (w.getHeight() - ModeleWidget.OFFSET);
					}
					break;

				case 0:
					//En dessous du compSurvole
					pt = arbo.getListe(comp).get(0).getLocation();
					break;

			}
			if (complexe) {
				dragGroupeWidget(arbo.getSuivants((Widget) (comp.parent()), true), ((Widget) comp.parent()).getLocation());
			} else {
				dragGroupeWidget(arbo.getListe(comp), pt);
			}
			composantsDrague.clear();

		} catch (ComposantIntrouvableException ex) {
			ErreurHelper.afficher(ex);
		}
		arbo.updateWidgets();

		updatePanelGraphiqueSize(arbo.getArborescence());

		this.setChanged();
		this.notifyObservers();

		g.setPointLigneSurEcran(null);
		g.setRectFusion(null);
		g.setDeleteIconPosition(null);

		if (compSurvole != null) {
			compSurvole.getModele().applyChangeModele();
		}
		
		// Suppression de la tache principale de la liste des widgets
		if (comp.getType() == TypeModeleWidget.TACHE) {
			for (BoutonCategorie bc : PanelTypeWidget.getInstance().getLesCategories()) {
				if (bc.getCategorie() == Categorie.STRUCTURES) {
					GUI.getPanelWidget().setLesWidgets(bc.getNbColonnes());
					break;
				}
			}
		}		
		
		LanceurTraduction.getInstance().lancerTraduction();
	}

	/**
	 * Méthode récursive permettant de supprimer un widget du GlassPane. Si le
	 * widget passé en paramètre est de type complexe, cette méthode est de
	 * nouveau appelée pour chacun de ses fils.
	 *
	 * @param comp le widget à supprimer
	 */
	private void deleteWidgetsFromGlassPane(Widget comp) {		
		if (comp.isComplexe()) {
			for (List<Widget> lw : ((WidgetCompose) comp).getMapZone().values()) {
				for (Widget w : lw) {
					deleteWidgetsFromGlassPane(w);
				}
			}
		}
		
		if (comp.getType() == TypeModeleWidget.TACHE) {
			((WidgetCompose) comp).clean();
			PanelTypeWidget.getInstance().ajouterTachePrincipale();			
		}
		
		GUI.getGlassPane().remove(comp);
	}

	/**
	 * Méthode permettant de calculer les Dimensions e position d'un groupe de
	 * widgets.
	 *
	 * @param lst Le groupe de widgets pour lesquels on veut recupérer les
	 * dimensions et positions
	 * @param index L'index à partir duquel on veut commencer à calculer les
	 * dimensions et positions du groupe
	 * @param rect Le rectangle utilisé pendant les appels récursifs
	 * @return Le Rectangle regroupant les positions et dimensions du goupe de
	 * widgets passé en paramètre ou null si la listede widgets est vide
	 */
	private static Rectangle groupeWidgetBounds(List<Widget> lst, int index, Rectangle rect) {
		for (int i = index; i < lst.size(); i++) {
			Widget w = lst.get(i);
			if (w.isComplexe()) {
				WidgetCompose comp = (WidgetCompose) w;
				for (List<Widget> l : comp.getMapZone().values()) {
					rect = groupeWidgetBounds(l, 0, rect);
				}
			}
			if (rect == null) {
				rect = w.getBounds();
			} else {
				rect = rect.union(w.getBounds());
			}
		}
		return rect;
	}

	private void updatePanelGraphiqueSize(List<List<Widget>> arborescence) {
		PanelCodeGraphique p = PanelCodeGraphique.getInstance();
		Rectangle bounds = null;
		for (List<Widget> l : arborescence) {
			if (!l.isEmpty()) {
				Rectangle boundsGroup = groupeWidgetBounds(l, 0, null);
				if (bounds == null) {
					bounds = boundsGroup;
				} else {
					bounds = bounds.union(boundsGroup);
				}
			}
		}
		if (bounds != null) {
			p.setPreferredSize(new Dimension((int) (bounds.getX() + bounds.getWidth()), (int) (bounds.getY() + bounds.getHeight())));
			p.getScroll().validate();
		}
	}
}

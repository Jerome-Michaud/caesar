package jscratch.vue.arborescence;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import jscratch.exceptions.ComposantIntrouvableException;
import jscratch.exceptions.NonClonableException;
import jscratch.helpers.ErreurHelper;
import jscratch.traduction.LanceurTraduction;
import jscratch.vue.arborescence.actions.Action;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.principales.panels.GlassPane;
import jscratch.vue.ginterface.principales.panels.PanelCodeGraphique;
import jscratch.vue.ginterface.principales.panels.PanelWidget;
import jscratch.vue.widgets.IWidget;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.WidgetCompose;
import jscratch.vue.widgets.modeles.ModeleWidget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import jscratch.vue.widgets.modeles.zones.Zone;

/**
 * Classe implémentant le design pattern Singleton permettant de gérer le
 * système de drag & drop.
 *
 * @since 1.0
 * @version 1.0
 */
public class DragAndDropTools extends Observable {

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
		if (!comp.isDraggable()) {
			comp.setDraggable(true);
			Widget compNouv;
			
			try {
				compNouv = GUI.getPanelWidget().getFabrique().cloner(comp);
				compNouv.setBounds(comp.getBounds());
				PanelWidget pw = GUI.getPanelWidget();
				pw.add(compNouv);
				int ind = pw.getIndex(comp);
				pw.supprimerWidget(comp);
				pw.ajouterWidget(compNouv, ind);
			} catch (NonClonableException ex) {
				ErreurHelper.afficher(ex);
			}
			composantsDrague = new LinkedList<Widget>();
			composantsDrague.add(comp);
		} else {
			ArborescenceTools arbo = ArborescenceTools.getInstance();
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
		
		ArborescenceTools.getInstance().updateWidgets();
		
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
	public void passerSurAutrePanel(Widget wi, JPanel destination) {
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
				((WidgetCompose) w).notifyChange();
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
			Rectangle recZoneUtil = new Rectangle(GUI.getZoneUtilisateur().getLocationOnScreen(), new Dimension(GUI.getZoneUtilisateur().getWidth(), GUI.getZoneUtilisateur().getHeight()));
			Rectangle boundsGroup = groupeWidgetBounds(composantsDrague, 0);
			
			Rectangle recWid = new Rectangle(new Point((int) (MouseInfo.getPointerInfo().getLocation().x - ptClick.getX()), (int) (MouseInfo.getPointerInfo().getLocation().y - ptClick.getY())), new Dimension((int) boundsGroup.getWidth(), (int) boundsGroup.getHeight()));
			recZoneUtil.setBounds(recZoneUtil.getBounds().x + 4, recZoneUtil.getBounds().y + 20, recZoneUtil.getBounds().width - 12, recZoneUtil.getBounds().height - 20 - 9);
			
			if (!recZoneUtil.contains(recWid)) {
				boolean noX = false;
				if (recWid.getMinX() <= recZoneUtil.getMinX()) {
					// A gauche
					p.x = (int) recZoneUtil.getMinX() + 4;
					p.y -= ptClick.y;
					noX = true;
				} else if (recWid.getMaxX() > recZoneUtil.getMaxX()) {
					// A droite
					p.x = (int) recZoneUtil.getMaxX() - recWid.width - 4;
					p.y -= ptClick.y;
					noX = true;
				}
				
				if (recWid.getMinY() <= recZoneUtil.getMinY()) {
					// En haut
					p.y = (int) recZoneUtil.getMinY() + 4;
					if (!noX) {
						p.x -= ptClick.x;
					}
				} else if (recWid.getMaxY() >= recZoneUtil.getMaxY()) {
					// En bas
					p.y = (int) recZoneUtil.getMaxY() - recWid.height - 4;
					if (!noX) {
						p.x -= ptClick.x;
					}
				}
			} else {
				p.x -= ptClick.x + 4;
				p.y -= ptClick.y + 4;
			}
			p.x -= GUI.getFenetre().getLocation().getX();
			p.y -= GUI.getFenetre().getLocation().getY();
			dragGroupeWidget(composantsDrague, p);
			
			this.setChanged();
			this.notifyObservers();
			int decal = (int) (Widget.TAUX_TRANSFERT_PANEL * comp.getWidth());
			int inter = (int) (boundsGroup.getMaxX() - GUI.getPanelCodeGraphique().getBounds().getMinX());
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
		int inter = (int) (r.getMaxX() - p.getBounds().getMinX());
		ArborescenceTools arbo = ArborescenceTools.getInstance();
		boolean complexe = false;
		Widget compSurvole = null;
		try {
			if (inter >= decal) {
				p.add(comp);
				
				SwingUtilities.convertPointFromScreen(pt, p);
				if (inter < comp.getWidth()) {
					pt.x += (comp.getWidth() - inter) + 3;
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
					pt = groupeWidgetBounds(arbo.getListe(comp), composantsDrague.size()).getLocation();
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
		
		this.setChanged();
		this.notifyObservers();
		
		g.setPointLigneSurEcran(null);
		g.setRectFusion(null);
		g.setDeleteIconPosition(null);
		
		if (compSurvole != null) {
			compSurvole.getModele().applyChangeModele();
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
	 * @return Le Rectangle regroupant les positions et dimensions du goupe de
	 * widgets passé en paramètre
	 */
	private static Rectangle groupeWidgetBounds(List<Widget> lst, int index) {
		if (lst.isEmpty()) {
			return new Rectangle();
		} else {
			Rectangle rect = lst.get(0).getBounds();
			for (int i = index; i < lst.size(); i++) {
				Widget w = lst.get(i);
				rect = rect.union(w.getBounds());
			}
			return rect;
		}
	}
}

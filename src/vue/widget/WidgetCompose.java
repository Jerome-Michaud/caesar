package vue.widget;


import instruction.Instruction;
import instruction.InstructionIfElse;
import instruction.InstructionStructure;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import modeles.TypeWidget;
import vue.tools.ComposantIntrouvableException;
import vue.tools.Variables;
import vue.widget.modele.ModeleWidget;

/**
 * Classe héritant de Widget et implémentant IWidget permettant de représenter un Widget de type Complexe.
 */
public class WidgetCompose extends Widget implements IWidget {

	/**
	 * HashMap stockant les zones d'accroches du composant complexe et les widgets qui y sont insérés.
	 */
	private HashMap<Rectangle, List<Widget>> mapZone;

	/**
	 * Méthode redéfinie en phase de test afin laisser apparaître les zones d'accroches.
	 *
	 * @param g l'objet <code>Graphics</code> de l'appel
	 */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);

	}

	/**
	 * Constructeur du Widget Compose faisant appel au constructeur de sa classe mère (<code>Widget</code>).
	 *
	 * @param comp le modèle du widget à créer
	 */
	public WidgetCompose(final ModeleWidget comp) {
		super(comp);
		this.mapZone = new HashMap<Rectangle, List<Widget>>();
		for (Rectangle r : comp.getZonesAccroches()) {
			this.mapZone.put(r, new LinkedList<Widget>());
		}
	}

	/**
	 * Méthode permettant de supprimer un widget au sein d'une zone d'accroche.
	 *
	 * @param cle la clé de la HashMap où supprimer le widget
	 * @param widget le widget à supprimer de la zone
	 * @return un booléen attestant de la suppression ou non du widget au sein de la HashMap.
	 */
	public boolean supprimerWidget(final Rectangle cle, final Widget widget) {
		return this.mapZone.get(cle).remove(widget);
	}

	/**
	 * Méthode retournant la HashMap représentant les zones d'accroche du composant.
	 *
	 * @return la HashMap représentant les zones d'accroches du composant
	 */
	public HashMap<Rectangle, List<Widget>> getMapZone() {
		return this.mapZone;
	}

	/*
	 * public HashMap<Rectangle,List<Widget>> getComposition() { return
	 * this.mapZone.; }
	 */
	/**
	 * Méthode permettant de rechercher, au sein de toutes les zones d'accroches
	 * du composant, un composant en particulier et ainsi retourner la liste de Widgets de la zone d'accroche à laquelle ce composant appartient.
	 *
	 * @param comp le composant à rechercher au sein des zones d'accroche du composant complexe
	 * @return la liste de widgets de la zone d'accroche qui contient comp
	 * @throws ComposantIntrouvableException si le Widget n'est pas trouvé dans aucune des zones d'accroches du composant complexe
	 */
	public List<Widget> getWidgetsAssocies(final Widget comp) throws ComposantIntrouvableException {
		List<Widget> l = null;
		boolean trouve = false;
		for (List<Widget> lst : this.mapZone.values()) {
			if (lst.contains(comp)) {
				trouve = true;
				l = lst;
				break;
			}
			if (trouve) {
				break;
			}
		}
		if (!trouve) {
			throw new ComposantIntrouvableException();
		}
		return l;
	}

	@Override
	public boolean isComplexe() {
		return true;
	}

	@Override
	public boolean isRacine() {
		return false;
	}

	/**
	 * Méthode permettant de recalculer les positions et dimensions de chaque zones d'accroches du composant complexe.
	 */
	public void notifyChange() {
		HashMap<Rectangle, Rectangle> mapRect = new HashMap<Rectangle, Rectangle>();
		HashMap<Rectangle, Integer> mapDecal = new HashMap<Rectangle, Integer>();
		
		for (Rectangle r : mapZone.keySet()) {
			int decalY = 0;
			Rectangle maxBounds = null;
			
			//Redimensionnement les zones d'accroches
			for (Widget w : mapZone.get(r)) {
				//Widget parent = (Widget)w.parent();
				if (w.isComplexe()) {
					((WidgetCompose) w).notifyChange();
				}
				
				w.setLocation((int) (this.getLocation().getX() + r.getX()), (int) (this.getLocation().getY() + r.getY() + decalY));
				if (maxBounds == null) {
					maxBounds = new Rectangle(w.getBounds());
					decalY += w.getBounds().height - ModeleWidget.OFFSET;
				}
				else {
					maxBounds = maxBounds.union(w.getBounds());
					decalY += w.getBounds().height - ModeleWidget.OFFSET;
				}
			}
			
			if (maxBounds == null) {
				maxBounds = new Rectangle();
			}
			maxBounds.height -= ModeleWidget.OFFSET;
			maxBounds.height = Math.max(maxBounds.height, Variables.ECART_PAR_DEFAULT);
			int diff = maxBounds.height - r.height;

			//On stocke le décalage qu'on voudra appliquer sur les zones d'accroche du composant
			if (diff < 0 - ModeleWidget.OFFSET) {
				this.getModele().decalageYin(Math.abs(diff), r);
				decaleZonesEnDessousDe(r.y, diff, mapDecal);
			}
			else if (diff > 0 - ModeleWidget.OFFSET) {
				this.getModele().decalageYout(diff, r);
				decaleZonesEnDessousDe(r.y, diff, mapDecal);
			}

			Rectangle bnds = new Rectangle(r);
			bnds.height = maxBounds.height;
			//On stocke les nouvelles bounds des zone ou il y a des changements
			mapRect.put(r, bnds);
			this.setForme(false);
		}

		//Une fois sorti de la boucle ...
		// ...On decale les nouvelles bounds qu'on a stocké plus haut si il y a besoin
		for (Rectangle r : mapDecal.keySet()) {
			if (mapRect.get(r) != null) {
				Rectangle rectDecal = new Rectangle(mapRect.get(r));
				rectDecal.y += mapDecal.get(r);
				mapRect.put(r, rectDecal);
			}
		}

		// Et enfin on finit par attribuer a chaque zone ses nouvelles bounds
		for (Rectangle r : mapRect.keySet()) {
			this.mapZone.put(mapRect.get(r), this.mapZone.remove(r));
		}
	}

	/**
	 * Méthode permettant de décaler toutes les zones d'accroches situées en dessous d'un certaine zone d'accroche.
	 *
	 * @param y la position en Y de la zone d'accroche qui a été agrandie
	 * @param diff la valeur de laquelle il faut décaler chaque zone d'accroche en dessous de y
	 * @param map la Hashmap dans laquelle il faut rechercher les zones à décaler
	 */
	private void decaleZonesEnDessousDe(int y, int diff, HashMap<Rectangle, Integer> map) {
		for (Rectangle r : this.mapZone.keySet()) {
			if (r.y > y) {
				map.put(r, diff);
			}
		}
	}

	@Override
	public void applyChangeModele() {
		// Testé le type du modele widget courant
		if (this.getModele().getType() == TypeWidget.IFELSE) {
			// Cas du if...else
			InstructionIfElse structInst = (InstructionIfElse) this.getModele().getElementProgramme();
			// Récupéré clé mapZone du if et du else clé du if <=> rectangle supérieur clé du else <=> rectangle inféreur
			// Suppression des instructions du if et du else dans l'arbre des instruction
			// Récupérer les instructions des widgets du if les ajouté à l'arbre des instructions
			List<Widget> widgets = recupeAllWidgetCorps(1);
			structInst.removeEnfantsIf();
			for (Widget widget : widgets) {
				Instruction inst = (Instruction) widget.getElementProgramme();
				structInst.insererFinIf(inst);
			}
			// Récupérer les instructions des widgets du else les ajouté à l'arbre des instructions
			widgets = recupeAllWidgetCorps(0);
			structInst.removeEnfantsElse();
			for (Widget widget : widgets) {
				Instruction inst = (Instruction) widget.getElementProgramme();
				structInst.insererFinElse(inst);
			}

		}
		else {
			// Cas des instructions structures autre que IfElse
			this.applyChangeStructInst();
		}
	}

	/**
	 * Méthode permettant de récupérer tous les widgets d'une zone d'accroche.
	 *
	 * @param i l'index de la zone à récupérer
	 * @return la liste des widgets situés à l'index i
	 */
	private List<Widget> recupeAllWidgetCorps(int i) {
		// Récupérer la clé du corps
		Set<Rectangle> keys = this.mapZone.keySet();
		// Récupérer les widgets du contenue
		Object[] rects = keys.toArray();
		List<Widget> widgets = this.mapZone.get(rects[i]);
		return widgets;
	}

	/**
	 * Méthode permettant d'appliquer les changements à la structure du composant.
	 */
	private void applyChangeStructInst() {
		// Cas de la tâche
		InstructionStructure structInst = (InstructionStructure) this.getModele().getElementProgramme();
		// Récupération des widgets fils
		List<Widget> widgets = recupeAllWidgetCorps(0);
		// Suppression des enfants de la tâche
		structInst.removeEnfants();
		// Ajout de tous les enfants nouveaux et anciens
		for (Widget widget : widgets) {
			Instruction inst = (Instruction) widget.getElementProgramme();
			structInst.insererFin(inst);
		}
	}
}
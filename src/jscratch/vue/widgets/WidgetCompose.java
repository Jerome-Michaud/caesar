/*
Copyright (C) Université du Maine (2013)

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier.

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
package jscratch.vue.widgets;

import java.awt.Rectangle;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import jscratch.comparateurs.ComparateurRectangleY;
import jscratch.vue.widgets.modeles.TypeModeleWidget;
import jscratch.parametrages.properties.VariableProperties;
import jscratch.exceptions.ComposantIntrouvableException;
import nxtim.instruction.Instruction;
import nxtim.instruction.InstructionIfElse;
import nxtim.instruction.InstructionStructure;
import org.jdom2.Attribute;
import org.jdom2.Element;
import jscratch.vue.widgets.modeles.ModeleWidget;

/**
 * Classe héritant de Widget et implémentant IWidget permettant de représenter un Widget de type Complexe.
 */
public class WidgetCompose extends Widget implements IWidget {

	/**
	 * HashMap stockant les zones d'accroches du composant complexe et les widgets qui y sont insérés.
	 */
	private LinkedHashMap<Rectangle, List<Widget>> mapZone;

	/**
	 * Méthode redéfinie en phase de test afin laisser apparaître les zones d'accroches.
	 *
	 * @param g l'objet <code>Graphics</code> de l'appel
	 */
	/*@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		for(Rectangle r : mapZone.keySet()){
			g.drawRect((int)r.getX(),(int) r.getY(), (int)r.getWidth(),(int)r.getHeight());
		}
	}*/

	/**
	 * Constructeur du Widget Compose faisant appel au constructeur de sa classe mère (
	 * <code>Widget</code>).
	 *
	 * @param comp le modèle du widget à créer
	 */
	public WidgetCompose(final ModeleWidget comp) {
		super(comp);
		this.mapZone = new LinkedHashMap<Rectangle, List<Widget>>();
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
				w.setLocation((int) (this.getLocation().getX() + r.getX()), (int) (this.getLocation().getY() + r.getY() + decalY));
				if (w.isComplexe()) {
					((WidgetCompose) w).notifyChange();
				}
				if (maxBounds == null) {
					maxBounds = new Rectangle(w.getBounds());
					decalY += w.getBounds().height - ModeleWidget.OFFSET;
				} else {
					maxBounds = maxBounds.union(w.getBounds());
					decalY += w.getBounds().height - ModeleWidget.OFFSET;
				}

				// Correction du décalage de 1px pour que les widgets soient bien positionnés les uns par rapport aux autres
				decalY -= 1;
			}

			if (maxBounds == null) {
				maxBounds = new Rectangle();
			}
			maxBounds.height -= ModeleWidget.OFFSET;
			maxBounds.height = Math.max(maxBounds.height, VariableProperties.ECART_PAR_DEFAULT);
			int diff = maxBounds.height - r.height;

			//On stocke le décalage qu'on voudra appliquer sur les zones d'accroche du composant
			this.getModele().decalageY(diff, r);
			decaleZonesEnDessousDe(r.y, diff, mapDecal);
			this.getModele().decalerComposantsSuivantsY(r.y, diff);

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

		//Remise dans l'ordre de la Hashmap des zones d'accroche
		if (mapZone.keySet().size() > 1) {
			LinkedList<Rectangle> collRect = new LinkedList<Rectangle>(mapZone.keySet());
			Collections.sort(collRect, new ComparateurRectangleY());
			LinkedHashMap<Rectangle, List<Widget>> newMap = new LinkedHashMap<Rectangle, List<Widget>>();
			for (Rectangle rect : collRect) {
				newMap.put(rect, mapZone.get(rect));
			}
			this.mapZone = newMap;
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
				for(Widget w : mapZone.get(r)){
					w.setLocation(w.getX(), w.getY()+diff);
				}
			}
		}
	}

	@Override
	public void applyChangeModele() {
		this.getModele().applyChangeModele();
		// Tester le type du modele widget courant
		if (this.getModele().getType() == TypeModeleWidget.IFELSE) {
			// Cas du if...else
			InstructionIfElse structInst = (InstructionIfElse) this.getModele().getElementProgramme();
			// Récupérer clé mapZone du if et du else clé du if <=> rectangle supérieur clé du else <=> rectangle inféreur
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

		} else {
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

	@Override
	public Element toXml() {
		Element widget = super.toXml();
		widget.setName("widgetcompose");

		// Gestion des widgets internes
		int i = 0;
		for (Rectangle zone : this.mapZone.keySet()) {
			Element accroche = new Element("accroche");
			accroche.setAttribute(new Attribute("id", String.valueOf(i)));
			i++;

			for (Widget widgetInterne : this.mapZone.get(zone)) {
				accroche.addContent(widgetInterne.toXml());
			}
			widget.addContent(accroche);
		}
		return widget;
	}

    /**
     * Supprime tous les widgets contenus
     */
    public void clean() {
    	for (List<Widget> l : mapZone.values()) {
    		l.clear();
    	}
    }
}

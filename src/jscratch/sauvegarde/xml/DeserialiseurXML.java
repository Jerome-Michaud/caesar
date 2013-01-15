package jscratch.sauvegarde.xml;

import java.util.LinkedList;
import java.util.List;
import jscratch.modeles.DicoVariables;
import jscratch.modeles.DicoWidgetsCategories;
import jscratch.vue.ginterface.GUI;
import jscratch.vue.tools.NonChargeableException;
import jscratch.vue.widget.FabriqueInstructions;
import jscratch.vue.widget.IWidget;
import jscratch.vue.widget.Widget;
import jscratch.vue.widget.WidgetCompose;
import jscratch.vue.widget.modele.zones.Zone;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableModifiable;
import org.jdom2.Document;
import org.jdom2.Element;

public class DeserialiseurXML {

	/**
	 * Default constructor of <code>ChargeurXML</code>.
	 */
	private DeserialiseurXML() { }
	
	/**
	 * Permet de charger l'arborescence et le dictionnaire à partir d'un document XML.
	 * 
	 * @param docXml le document XML à parser
	 * @return L'arborescence à injecter dans le programme
	 * @throws NonChargeableException Si un des composants n'est pas chargeable (non définit dans la fabrique)
	 */
	public static List<List<Widget>> load(final Document docXml) throws NonChargeableException {
		List<List<Widget>> arbo = new LinkedList<List<Widget>>();
		
		// Chargement du dictionnaire
		Element dictionnaire = docXml.getRootElement().getChild("dictionnaire");
		for (Element variable : dictionnaire.getChildren()) {
			Variable var = new VariableModifiable(TypeVariable.fromString(variable.getAttributeValue("type")), variable.getAttributeValue("nom"), "");
			DicoVariables.getInstance().ajouter(var);
			DicoWidgetsCategories.getInstance().ajouterWidgetVariable(var);
		}
		
		// Chargement de l'arborescence
		List<Element> groupesXml = docXml.getRootElement().getChild("arborescence").getChildren("groupe");
		
		for (Element groupe : groupesXml) {
			List l = new LinkedList<Widget>();
			for (Element widgetXml : groupe.getChildren()) {
				Widget w = deserializeWidget(widgetXml, GUI.getPanelCodeGraphique());
				l.add(w);
			}
			arbo.add(l);
		}
		return arbo;
	}
	
	private static Widget deserializeWidget(Element widget, IWidget parent) throws NonChargeableException {
		String classe = widget.getAttributeValue("classe");
		String categorie = widget.getAttributeValue("categorie");
		Element coordonneesXml = widget.getChild("coordonnees");
		List<Element> attributsXml = widget.getChild("attributs").getChildren();
		List<Element> accrochesXml = widget.getChildren("accroche");

		// Récupération d'un objet Widget correspondant à la classe
		FabriqueInstructions fabrique = new FabriqueInstructions();
		
		Widget w = fabrique.creerWidget(classe, categorie);
		w.setDraggable(true);
		w.defParent(parent);
		w.applyChangeModele();
				
		// Remplissage des coordonnées
		if (coordonneesXml != null) {
			w.setLocation(Integer.parseInt(coordonneesXml.getAttributeValue("x")), Integer.parseInt(coordonneesXml.getAttributeValue("y")));
		}
		else {
			w.setLocation(0, 0);
		}
		
	
		// Remplissage des zones
		List<Zone> lesZones = w.getModele().getLesZonesSaisies();
		for (int i = 0; i < lesZones.size(); i++) {
			lesZones.get(i).setValeur(attributsXml.get(i).getAttributeValue("valeur"));
		}

		// Remplissage des zones d'accroche
		if (w.isComplexe()) {
			WidgetCompose wComp = (WidgetCompose) w;
			int i = 0;
			for (List<Widget> accroche : wComp.getMapZone().values()) {
				Element accrocheXml = accrochesXml.get(i);
				for (Element widgetXml : accrocheXml.getChildren()) {
					Widget wid = deserializeWidget(widgetXml, wComp);
					accroche.add(wid);
				}
				i++;
			}
			wComp.notifyChange();
		}

		return w;
	}
}
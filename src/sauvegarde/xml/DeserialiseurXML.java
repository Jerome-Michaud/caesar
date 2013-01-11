package sauvegarde.xml;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import modeles.Erreur;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import vue.tools.NonChargeableException;
import vue.widget.FabriqueInstructions;
import vue.widget.Widget;
import vue.widget.WidgetCompose;
import vue.widget.modele.zones.Zone;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
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
		List<List<Widget>> arbo = null;
		
		// Chargement du dictionnaire
		
		
		// Chargement de l'arborescence
		
		
		return arbo;
	}
	
	private static Widget deserializeWidget(Element widget) throws NonChargeableException {
		String classe = widget.getAttributeValue("classe");
		Element coordonnees = widget.getChild("coordonnees");
		List<Element> attributs = widget.getChild("attributs").getChildren();
		List<Element> accroches = widget.getChildren("accroche");

		FabriqueInstructions fabrique = new FabriqueInstructions();
		Widget w = fabrique.creerWidget(classe);

		// Remplissage des zones
		List<Zone> lesZones = w.getModele().getLesZonesSaisies();
		for (int i = 0; i < lesZones.size(); i++) {
			lesZones.get(i).setValeur(attributs.get(i).getText());
		}

		// Remplissage des zones d'accroche
		if (w.isComplexe()) {
			WidgetCompose wComp = (WidgetCompose) w;
			int i = 0;
			for (List<Widget> accroche : wComp.getMapZone().values()) {
				//accroches.get(i).
				i++;
			}
		}

		return w;
	}
}
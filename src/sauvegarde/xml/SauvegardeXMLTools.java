package sauvegarde.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeles.Erreur;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import sauvegarde.SauvegardeTools;
import vue.tools.ArborescenceTools;
import vue.tools.NonChargeableException;
import vue.widget.FabriqueInstructions;
import vue.widget.Widget;
import vue.widget.WidgetCompose;
import vue.widget.modele.zones.Zone;

/**
 *
 * @author Quentin
 */
public class SauvegardeXMLTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardeBinaireTools
	 */
	private static SauvegardeXMLTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 */
	private SauvegardeXMLTools() {
	}

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardeBinaireTools.
	 *
	 * @return l'instance unique de SauvegardeBBinaireTools
	 */
	public static SauvegardeXMLTools getInstance() {
		if (instance == null) {
			instance = new SauvegardeXMLTools();
		}
		return instance;
	}

	@Override
	public void save(String path) {
		serializeArborescence(path);
	}

	@Override
	public void load(String path) {
		try {
			deserializeArborescence(path);
		} catch (NonChargeableException ex) {
			Logger.getLogger(SauvegardeXMLTools.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Permet la sérialisation de l'arborescence des widgets.
	 *
	 * @param path Le chemin où sauvegarder le l'arborescence
	 */
	private void serializeArborescence(final String path) {
		List<List<Widget>> arbo = ArborescenceTools.getInstance().getArborescence();

		Document docXml = new Document(new Element("arborescence"));

		for (List<Widget> liste : arbo) {
			Element groupe = new Element("groupe");
			for (Widget widget : liste) {
				groupe.addContent(widget.toXml());
			}
			docXml.getRootElement().addContent(groupe);
		}

		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			FileOutputStream fo = new FileOutputStream(fichier);
			sortie.output(docXml, fo);
			fo.close();
		} catch (IOException ex) {
			Erreur.afficher(ex, "La sauvegarde n'a pas pu être effectuée corectement");
		}
	}

	/**
	 * Desérialise une arborescence précédemment sauvegardée.
	 *
	 * @param path Le chemin d'accès à l'arborscence sauvegardée
	 */
	private void deserializeArborescence(final String path) throws NonChargeableException {
		try {
			LinkedList<List<Widget>> arbos = null;
			Document docXml = null;
			File fichier = new File(path);
			if (fichier.exists()) {
				try {
					SAXBuilder sxb = new SAXBuilder();
					docXml = sxb.build(fichier);
					List<Element> lesGroupes = docXml.getRootElement().getChildren();

					for (Element groupe : lesGroupes) {
						for (Element widget : groupe.getChildren()) {
							deserializeWidget(widget);
						}
					}
					// Déserialiser




				} catch (JDOMException ex) {
					Erreur.afficher(ex, "Le fichier fournit n'est pas correct");
				}

				//ArborescenceTools.getInstance().initArborescence(arbos, true);
			}
		} catch (IOException ex) {
			Erreur.afficher(ex, "La sauvegarde n'a pas pu être chargée corectement");
		}
	}

	private Widget deserializeWidget(Element widget) throws NonChargeableException {
		String classe = widget.getAttributeValue("class");
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

		// Remplissage des 
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

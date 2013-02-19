package jscratch.sauvegarde.xml.arborescence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import jscratch.dictionnaires.DicoTraces;
import jscratch.helpers.ErreurHelper;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.exceptions.NonChargeableException;
import jscratch.traces.fabriques.FabriqueTrace;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.widgets.Widget;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @since 1.0
 * @version 1.0
 */
public final class SauvegardeArborescenceXMLTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardeBinaireTools
	 */
	private static SauvegardeArborescenceXMLTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 */
	private SauvegardeArborescenceXMLTools() { }

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardeBinaireTools.
	 *
	 * @return l'instance unique de SauvegardeBBinaireTools
	 */
	public static SauvegardeArborescenceXMLTools getInstance() {
		if (instance == null) {
			instance = new SauvegardeArborescenceXMLTools();
		}
		return instance;
	}

	@Override
	public File save(String path) {
		return serializeArborescence(path);
	}

	@Override
	public void load(String path) {
		try {
			deserializeArborescence(path);
			ArborescenceTools.getInstance().updateWidgets();
			GUI.getPanelCodeGraphique().repaint();
		} catch (NonChargeableException ex) {
			ErreurHelper.afficher(ex);
		}
	}

	/**
	 * Permet la sérialisation de l'arborescence des widgets.
	 *
	 * @param path Le chemin où sauvegarder le l'arborescence
	 */
	private File serializeArborescence(final String path) {
		Document doc = SerialiseurArborescenceXML.save();
		
		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			FileOutputStream fo = new FileOutputStream(fichier);
			sortie.output(doc, fo);
			fo.close();
			
			DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceSauvegarde(fichier));
			
			return fichier;
		} catch (IOException ex) {
			ErreurHelper.afficher(ex, "La sauvegarde n'a pas pu être effectuée corectement");
		}
		return null;
	}

	/**
	 * Desérialise une arborescence précédemment sauvegardée.
	 *
	 * @param path Le chemin d'accès à l'arborscence sauvegardée
	 */
	private void deserializeArborescence(final String path) throws NonChargeableException {
		try {
			File fichier = new File(path);
			if (fichier.exists()) {
				try {
					SAXBuilder sxb = new SAXBuilder();
					List<List<Widget>> l = DeserialiseurArborescenceXML.load(sxb.build(fichier));
					ArborescenceTools.getInstance().initArborescence(l, false);
					
					DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceChargement(fichier));
					
				} catch (JDOMException ex) {
					ErreurHelper.afficher(ex, "Le fichier fournit n'est pas correct");
				}
			}
		} catch (IOException ex) {
			ErreurHelper.afficher(ex, "La sauvegarde n'a pas pu être chargée correctement");
		}
	}
}
package jscratch.sauvegarde.xml.traces;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import jscratch.dictionnaires.DicoTraces;
import jscratch.helpers.ErreurHelper;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.traces.fabriques.FabriqueTrace;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @since 1.0
 * @version 1.0
 */
public final class SauvegardeTracesXMLTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardeBinaireTools
	 */
	private static SauvegardeTracesXMLTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 */
	private SauvegardeTracesXMLTools() { }

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardeBinaireTools.
	 *
	 * @return l'instance unique de SauvegardeBBinaireTools
	 */
	public static SauvegardeTracesXMLTools getInstance() {
		if (instance == null) {
			instance = new SauvegardeTracesXMLTools();
		}
		return instance;
	}

	@Override
	public File save(String path) {
		Document doc = SerialiseurtTracesXML.save();
		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			FileOutputStream fo = new FileOutputStream(fichier);
			sortie.output(doc, fo);
			fo.close();
			return fichier;
		} catch (IOException ex) {
			ErreurHelper.afficher(ex, "La sauvegarde n'a pas pu être effectuée corectement");
		}
		return null;
	}

	@Override
	public void load(String path) { }
}
package jscratch.sauvegarde.xml.traces;

import java.io.File;
import jscratch.sauvegarde.SauvegardeTools;
import org.jdom2.Document;

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
		return null;
	}

	@Override
	public void load(String path) { }
}
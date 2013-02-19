package jscratch.sauvegarde.xml.traces;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import jscratch.dictionnaires.DicoTraces;
import jscratch.helpers.ErreurHelper;
import jscratch.helpers.SessionHelper;
import jscratch.traces.Trace;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @since 1.0
 * @version 1.0
 */
public class SerialiseurtTracesXML {

	protected static final String TRACES = "traces";
	protected static final String LOGIN = "login";
	protected static final String DATE = "date";
	
	/**
	 * Constructeur privé de <code>ExportTraces</code>.
	 */
    private SerialiseurtTracesXML() { }

	/**
	 * Permet de sauvegarder les traces au format <code>XML</code>.
	 * 
	 * @since 1.0
	 * 
	 * @return le document <code>XML</code>
	 */
	public static Document save() {
		Element traces = new Element(TRACES);
		traces.setAttribute(LOGIN, SessionHelper.getUtilisateur());
		traces.setAttribute(DATE, SessionHelper.formatDate(new Date()));
		
		for (Trace t : DicoTraces.getInstance().getLesTraces()) {
			traces.addContent(t.toXml());
		}
		
		return new Document(traces);
	}
 }
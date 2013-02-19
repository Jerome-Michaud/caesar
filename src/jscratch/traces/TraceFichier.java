package jscratch.traces;

import java.io.File;
import java.io.IOException;
import jscratch.exceptions.IncompatibleTypeForTrace;
import jscratch.helpers.ErreurHelper;
import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceFichier extends Trace {

	/**
	 * Le fichier.
	 */
	private File fichier;
		
	/**
	 * Default constructor of <code>TraceSauvegarde</code>.
	 */
	public TraceFichier(final TypeTrace type, final File fichier) throws IncompatibleTypeForTrace {
		super(type);
		
		if (type.isTraceFichier()) {
			throw new IncompatibleTypeForTrace("Le type choisi pour cet objet n'est pas compatible (FICHIER_SAUVEGARDE ou FICHIER_CHARGEMENT ou ROBOT_ENVOI)");
		}
		
		this.fichier = fichier;
	}

	@Override
	public Element toXml() {
		Element thisXml = super.toXml();
		
		try {
			String nomFichier = this.fichier.getCanonicalPath();
		
			thisXml.setAttribute(NOMFICHIER, fichier.getAbsolutePath());
		
			thisXml.setAttribute(FORMATFICHIER, nomFichier.substring(nomFichier.indexOf(".")));
		
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
		return thisXml;
	}
}
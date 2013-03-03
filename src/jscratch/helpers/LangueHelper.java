package jscratch.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import jscratch.parametrages.langue.VariableLangue;

/**
 * Permet de gérer facilement les fichiers properties.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class LangueHelper {

	/**
	 * Unique instance of <code>LangueHelper</code>.
	 */
	private static LangueHelper instance = null;

	/**
	 * Les fichier lang.
	 */
	private Properties langue = null;
	
	/**
	 * Private constructor of <code>LangueHelper</code>.
	 * 
	 * @since 1.0
	 */
    private LangueHelper() {
		try {
			this.langue = new Properties();
			//File fichier = new File("lang" + File.separator + Locale.getDefault() + ".lang");
			File fichier = new File("lang" + File.separator + Locale.ENGLISH + ".lang");
			if (fichier.exists()) {
				this.langue.load(new InputStreamReader(new FileInputStream(fichier), "UTF8"));
			}
		} catch (FileNotFoundException ex) {
			ErreurHelper.afficher(ex);
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
	}
	
	/**
	 * Accessor for <code>LangueHelper</code>.
	 *
	 * @since 1.0
	 * 
	 * @return unique instance of <code>LangueHelper</code>
	 */
    public static LangueHelper getInstance() {
        if (instance == null) {
			instance = new LangueHelper();
		}
		return instance;
    }
		
	/**
	 * Récupère la valeur d'un propriété.
	 * 
	 * @since 1.0
	 * 
	 * @param cle la clé
	 * @return la valeur de la propriété
	 */
	public String get(final VariableLangue cle) {
		String valeur = this.langue.getProperty(cle.toString());
		if (valeur == null) {
			Logger.getLogger(LangueHelper.class.toString()).log(Level.WARNING, "La clé ''{0}'' n''a pas été trouvée dans le fichier de langue", new Object[] {cle.toString()});
		}
		return valeur;
	}
 }
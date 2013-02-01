package jscratch.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @since 1.0
 * @version 1.0
 */
public class PropertiesHelper {

	/**
	 * Unique instance of <code>PropertiesHelper</code>.
	 */
	private static PropertiesHelper instance = null;

	private SortedProperties properties = null, propertiesDistant = null;
	
	/**
	 * Private constructor of <code>PropertiesHelper</code>.
	 */
    private PropertiesHelper() {
		try {
			File fichier = new File("properties.properties");
			if (fichier.exists()) {
				this.properties = new SortedProperties();
				this.properties.load(new FileInputStream(fichier));
				
				File fichierdistant = new File(this.properties.getProperty("user.chemin.properties.distant"));
				if (fichierdistant.exists()) {
					this.propertiesDistant = new SortedProperties();
					this.propertiesDistant.load(new FileInputStream(fichierdistant));
				}
			}
		} catch (FileNotFoundException ex) {
			ErreurHelper.afficher(ex);
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
	}

	/**
	 * Accessor for <code>PropertiesHelper</code>.
	 *
	 * @return unique instance of <code>PropertiesHelper</code>
	 */
    public static PropertiesHelper getInstance() {
        if (instance == null) {
			instance = new PropertiesHelper();
		}
		return instance;
    }
	
	/**
	 * Récupère la valeur d'un propriété.
	 * 
	 * @param cle la clé
	 * @return la valeur de la propriété
	 */
	public String get(final String cle) {
		String valeur = this.propertiesDistant.getProperty(cle);
		if (valeur == null) {
			Logger.getLogger(PropertiesHelper.class.toString()).log(Level.WARNING, "La clé ''{0}'' n''a pas été trouvée", new Object[] {cle});
		}
		return valeur;
	}
	
	/**
	 * Récupère la valeur d'un propriété. Si la clé n'est pas trouvé, elle est ajoutée si le deuxième paramètre est à <code>true</code>.
	 * 
	 * @param cle la clé
	 * @param ajout <code>true</code>, si la clé doit être ajoutée si elle n'est pas trouvée
	 * @return la valeur de la propriété
	 */
	public String get(final String cle, final boolean ajout) {
		String valeur = this.propertiesDistant.getProperty(cle);
		if (!ajout) {
			return get(cle);
		}
		else if (valeur == null || valeur.isEmpty()) {
			Logger.getLogger(PropertiesHelper.class.toString()).log(Level.WARNING, "La clé ''{0}'' n''a pas été trouvée mais ajoutée sans valeur", new Object[] {cle});
			this.propertiesDistant.put(cle, "");
		}
		return valeur;
	}
	
	/**
	 * Change la valeur de la propriété.
	 * 
	 * @param cle la clé de la propriété à changer
	 * @param valeur la nouvelle valeur de cette propriété
	 */
	public void set(final String cle, final String valeur) {
		this.propertiesDistant.setProperty(cle, valeur);
	}
	
	/**
	 * Sauvegarde les modifications apportées au fichier properties.
	 */
	public void sauvegarder() {
		try {
			File fichier = new File(PropertiesHelper.getInstance().get("user.chemin.properties.distant"));
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			this.propertiesDistant.store(new FileWriter(fichier), "");
			this.properties.store(new FileWriter(new File("properties.properties")), "");
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
	}
	
	private class SortedProperties extends Properties {
		
		@Override
		public synchronized Enumeration keys() {
			Enumeration keysEnum = super.keys();
			Vector keyList = new Vector();
			while (keysEnum.hasMoreElements()) {
				keyList.add(keysEnum.nextElement());
			}
			Collections.sort(keyList);
			return keyList.elements();
		}
	}
 }
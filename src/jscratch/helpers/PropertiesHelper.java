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
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Permet de gérer facilement les fichiers properties.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class PropertiesHelper {

	/**
	 * Unique instance of <code>PropertiesHelper</code>.
	 */
	private static PropertiesHelper instance = null;

	/**
	 * Les fichier properties.
	 */
	private SortedProperties properties = null, propertiesDistant = null;
	
	/**
	 * Private constructor of <code>PropertiesHelper</code>.
	 * 
	 * @since 1.0
	 */
    private PropertiesHelper() {
		try {
			File fichier = new File("properties.properties");
			if (fichier.exists()) {
				this.properties = new SortedProperties();
				this.properties.load(new InputStreamReader(new FileInputStream(fichier), "UTF8"));
				
				File fichierdistant = new File(this.properties.getProperty("user.chemin.properties.distant"));
				if (fichierdistant.exists()) {
					this.propertiesDistant = new SortedProperties();
					this.propertiesDistant.load(new InputStreamReader(new FileInputStream(fichierdistant), "UTF8"));
				}
			}
		} catch (FileNotFoundException ex) {
			ErreurHelper.afficher(ex);
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
	}
	
	/**
	 * Permet de charger un autre properties.
	 * 
	 * @since 1.0
	 * 
	 * @param fichier le fichier à charger
	 */
	public void reset(final File fichier) {
		if (fichier.exists()) {
			try {
				this.propertiesDistant = new SortedProperties();
				this.propertiesDistant.load(new InputStreamReader(new FileInputStream(fichier), "UTF8"));
			} catch (IOException ex) {
				ErreurHelper.afficher(ex);
			}
		}
	}

	/**
	 * Accessor for <code>PropertiesHelper</code>.
	 *
	 * @since 1.0
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
	 * Perrmet de connaître le nombre de clés dans le properties.
	 * 
	 * @since 1.0
	 * 
	 * @return la nombre de clé
	 */
	public int size() {
		return this.propertiesDistant.size();
	}
	
	/**
	 * Récupère la valeur d'un propriété.
	 * 
	 * @since 1.0
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
	 * @since 1.0
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
	 * @since 1.0
	 * 
	 * @param cle la clé de la propriété à changer
	 * @param valeur la nouvelle valeur de cette propriété
	 */
	public void set(final String cle, final String valeur) {
		this.propertiesDistant.setProperty(cle, valeur);
	}
	
	/**
	 * Sauvegarde les modifications apportées au fichier properties.
	 * 
	 * @since 1.0
	 */
	public void sauvegarder() {
		try {
			File fichier = new File(PropertiesHelper.getInstance().get("user.chemin.properties.distant"));
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			this.propertiesDistant.store(new OutputStreamWriter(new FileOutputStream(fichier), "UTF8"), "");
			this.properties.store(new OutputStreamWriter(new FileOutputStream(new File("properties.properties")), "UTF8"), "");
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
	}
	
	/**
	 * Classe supplémentaire qui permet d'avoir un properties avec les clés triées par ordre alphabétique.
	 * 
	 * @since 1.0
	 */
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
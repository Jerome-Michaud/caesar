/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import jscratch.Environnement;

/**
 * Permet de gérer facilement les fichiers properties.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class PropertiesHelper {
	private static final String PROPERTIES_FILE = "properties.properties";
	private static final String DISTANT_PROPERTIES_KEY = "user.chemin.properties.distant";
	private static final String ENCODING = "UTF8";
	private static final String COMMENT_FILE_PROPERTIES = "Ce fichier a été généré par CAESAR";
	
	/**
	 * Unique instance of <code>PropertiesHelper</code>.
	 */
	private static PropertiesHelper instance = null;

	/**
	 * Le fichier properties.
	 */
	private SortedProperties properties = null;
	
	/**
	 * Private constructor of <code>PropertiesHelper</code>.
	 * 
	 * @since 1.0
	 */
    private PropertiesHelper() {
    	InputStreamReader reader = null;
		try {
			File fichier = new File(Environnement.getDataDir(), PROPERTIES_FILE);
			// Creer le fichier de propriétés par défaut s'il n'exista pas
			if (!fichier.exists()) {
				creerFichierProperties();
			}
			this.properties = new SortedProperties();
			// Initialisation avec les valeurs par défaut pour être sûr que les valeurs obligatoires soient présentes
			setToDefaultObligatoryProperties(this.properties);
			reader = new InputStreamReader(new FileInputStream(fichier), ENCODING);
			this.properties.load(reader);
			reader.close();
			reader = null;
			
			String fichierProp = this.properties.getProperty(DISTANT_PROPERTIES_KEY);
			if(fichierProp != null) {
				File fichierdistant = new File(fichierProp);
				// Si le chemin du fichier distant est
				if(!fichierdistant.isAbsolute()) {
					fichierdistant = new File(Environnement.getDataDir(), fichierProp);
				}
				if (fichierdistant.exists()) {
					reader = new InputStreamReader(new FileInputStream(fichierdistant), ENCODING);
					this.properties.clear();
					this.properties.load(reader);
					reader.close();
				} else {
					System.err.println("Fichier " + fichierdistant.getAbsolutePath() + " introuvable !");
				}
			} else {
				System.err.println("Manque la propriété '" + DISTANT_PROPERTIES_KEY + "' dans le fichier " + PROPERTIES_FILE + ".");
			}
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
            InputStreamReader reader = null;
			try {
				this.properties = new SortedProperties();
				reader = new InputStreamReader(new FileInputStream(fichier), ENCODING);
				this.properties.load(reader);
			} catch (IOException ex) {
				ErreurHelper.afficher(ex);
			} finally {
				if(reader != null) {
					try {
						reader.close();
					} catch(IOException ioe) {
						ErreurHelper.afficher(ioe);
					}
				}
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
    public static synchronized PropertiesHelper getInstance() {
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
		return this.properties.size();
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
		String valeur = this.properties.getProperty(cle);
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
		String valeur = this.properties.getProperty(cle);
		if (!ajout) {
			return get(cle);
		}
		else if (valeur == null || valeur.isEmpty()) {
			Logger.getLogger(PropertiesHelper.class.toString()).log(Level.WARNING, "La clé ''{0}'' n''a pas été trouvée mais ajoutée sans valeur", new Object[] {cle});
			this.properties.put(cle, "");
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
		this.properties.setProperty(cle, valeur);
	}
	
	/**
	 * Sauvegarde les modifications apportées au fichier properties.
	 * 
	 * @since 1.0
	 */
	public void sauvegarder() {
		Writer writer = null;
        InputStreamReader reader = null;
		try {
			String distantProperties = PropertiesHelper.getInstance().get(DISTANT_PROPERTIES_KEY);
			// Le fichier utilisé est celui définit par la clé DISTANT_PROPERTIES_KEY si elle existe, sinon c'est PROPERTIES_FILE
			File fichier = new File(Environnement.getDataDir(), PROPERTIES_FILE);
			if(distantProperties != null) {
				File fichierDistant = new File(distantProperties);
				// Mise à jour du chemin du properties distant dans le properties local
				reader = new InputStreamReader(new FileInputStream(fichier), ENCODING);
				final SortedProperties prop = new SortedProperties();
				prop.load(reader);
				prop.setProperty(DISTANT_PROPERTIES_KEY, PropertiesHelper.getInstance().get(DISTANT_PROPERTIES_KEY));
				writer = new OutputStreamWriter(new FileOutputStream(fichier), ENCODING);
				prop.store(writer, COMMENT_FILE_PROPERTIES);
				writer.close();
				writer = null;
				// Mise à jour des propriétés dans le fichier distant
				writer = new OutputStreamWriter(new FileOutputStream(fichierDistant), ENCODING);
				this.properties.remove(DISTANT_PROPERTIES_KEY); // Pour ne pas stocker la propriétés de chemin distant
				this.properties.store(writer, COMMENT_FILE_PROPERTIES);
				this.properties.setProperty(DISTANT_PROPERTIES_KEY, prop.getProperty(DISTANT_PROPERTIES_KEY));
			} else {
				writer = new OutputStreamWriter(new FileOutputStream(fichier), ENCODING);
				this.properties.store(writer, COMMENT_FILE_PROPERTIES);
			}
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
				if(writer != null) {
					writer.close();
				}
			} catch(IOException e) {
				ErreurHelper.afficher(e);
			}
		}
	}
	
	/**
	 * Modifie un ensemble de propriétés en celui par des propriétés obligatoires par défaut.
	 * @param props l'ensemble de propriétés à changer
	 */
	private void setToDefaultObligatoryProperties(SortedProperties props) {
		props.clear();
		props.setProperty("taille.categorie.x", "110");
		props.setProperty("taille.categorie.y", "25");
		props.setProperty("marge.aiment", "10");
		props.setProperty("linestroke.value", "5");
		props.setProperty("taux.transfert", "0.6");
		props.setProperty("ecart.defaut", "15");
		props.setProperty("user.chemin.compilateur", "nbc.exe");
		props.setProperty("user.categorie.afficher.nombrewidget", "true");
		props.setProperty("user.couleur.Structures", "-692194");
		props.setProperty("user.couleur.Moteurs", "-7814912");
		props.setProperty("user.couleur.Expressions", "-692194");
		props.setProperty("user.couleur.Capteurs", "-7062134");
		props.setProperty("user.couleur.Temps", "-16735797");
		props.setProperty("user.couleur.Variables", "-1487241");
	}
	
	/**
	 * Modifie un ensemble de propriétés en celui des propriétés par défaut.
	 * @param props l'ensemble de propriétés à changer
	 */
	private void setToDefaultProperties(SortedProperties props) {
		setToDefaultObligatoryProperties(props);
		props.setProperty("user.interface.afficher.categories", "true");
		props.setProperty("user.widget.afficher.Attendre", "true");
		props.setProperty("user.widget.afficher.AffecterA", "true");
		props.setProperty("user.widget.afficher.Capteur", "true");
		props.setProperty("user.widget.afficher.ConfigurationCapteurs", "true");
		props.setProperty("user.widget.afficher.DeclarerVariable", "true");
		props.setProperty("user.widget.afficher.ExpressionArithmetique", "true");
		props.setProperty("user.widget.afficher.ExpressionIncrementation", "true");
		props.setProperty("user.widget.afficher.ExpressionLogique", "true");
		props.setProperty("user.widget.afficher.FaireTantQue", "true");
		props.setProperty("user.widget.afficher.MoteurArret", "true");
		props.setProperty("user.widget.afficher.MoteurMarche", "true");
		props.setProperty("user.widget.afficher.MoteurNombreRotation", "true");
		props.setProperty("user.widget.afficher.MoteurRAZ", "true");
		props.setProperty("user.widget.afficher.Repeter", "true");
		props.setProperty("user.widget.afficher.Si", "true");
		props.setProperty("user.widget.afficher.SiSinon", "true");
		props.setProperty("user.widget.afficher.Tache", "true");
		props.setProperty("user.widget.afficher.TantQue", "true");
		props.setProperty("user.widget.afficher.TempsCourant", "true");
		props.setProperty("user.widget.afficher.Variable", "true");
		props.setProperty("user.widget.afficher.Negation", "true");
	}
	
	/**
	 * Créer le fichier properties par défaut.
	 */
	private void creerFichierProperties() {
		File fichier = new File(Environnement.getDataDir(), PROPERTIES_FILE);
		SortedProperties props = new SortedProperties();
		setToDefaultProperties(props);

		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(fichier), ENCODING);
			props.store(writer, COMMENT_FILE_PROPERTIES);
		} catch (IOException e) {
			ErreurHelper.afficher(e);
		} finally {
			if(writer != null) {
				try {
					writer.close();
				} catch(IOException e) {
					ErreurHelper.afficher(e);
				}
			}
		}
	}
	
	/**
	 * Classe supplémentaire qui permet d'avoir un properties avec les clés triées par ordre alphabétique.
	 * 
	 * @since 1.0
	 */
	private class SortedProperties extends Properties {
		
		private static final long serialVersionUID = 1L;

		/**
		 * {@inheritDoc}
		 */
		@Override
		public synchronized Enumeration<Object> keys() {
			Enumeration<Object> keysEnum = super.keys();
			Vector<Object> keyList = new Vector<Object>();
			while (keysEnum.hasMoreElements()) {
				keyList.add(keysEnum.nextElement());
			}
			keyList.sort(null);
			return keyList.elements();
		}
	}
 }
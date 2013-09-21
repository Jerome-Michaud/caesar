/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

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
			
			// Mise à jour du chemin du properties distant dans le properties local
			this.properties.setProperty("user.chemin.properties.distant", PropertiesHelper.getInstance().get("user.chemin.properties.distant"));
			
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
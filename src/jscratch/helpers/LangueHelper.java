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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Properties;
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
			File fichier = new File("lang" + File.separator + Locale.getDefault().getLanguage() + ".lang");
			//File fichier = new File("lang" + File.separator + Locale.ENGLISH + ".lang");
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
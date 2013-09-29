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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.principales.selecteur.SelecteurFichier;
import jscratch.vue.ginterface.principales.selecteur.TypeSelecteur;

/**
 * @since 1.0
 * @version 1.0
 */
public final class SessionHelper {

	private static DateFormat formatJour = new SimpleDateFormat("dd/MM/yyyy");
	private static DateFormat formatHeure = new SimpleDateFormat("HH:mm:ss");
	/**
	 * Constructeur privé de <code>SessionHelper</code>.
	 */
    private SessionHelper() { }
	
	/**
	 * Permet d'avoir le login de l'utilisateur en cours.
	 * 
	 * @since 1.0
	 * 
	 * @return le login de l'utilisateur
	 */
	public static String getUtilisateur() {
		return System.getProperty("user.name");
	}
	
	/**
	 * Permet d'avoir la date de la session.
	 * 
	 * @since 1.0
	 * 
	 * @param date la date à formater
	 * @return la date au format DD/MM/YYYY
	 */
	public static String formatDate(final Date date) {
		return formatJour.format(date);
	}
	
	/**
	 * Permet d'avoir l'heure actuelle.
	 * 
	 * @since 1.0
	 * 
	 * @param date la date à formater
	 * @return l'heure au format HH:mm:ss
	 */
	public static String formatHeure(final Date date) {
		return formatHeure.format(date);
	}
	
	/**
	 * Permet d'éxécuter les actions avant de fermer l'application.
	 */
	public static void quitter() {
		if (Boolean.parseBoolean(PropertiesHelper.getInstance().get("user.trace.active"))) {
			new SelecteurFichier(TypeSelecteur.TRACES).sauvegarde();
		}
		
		System.exit(0);
	}
 }

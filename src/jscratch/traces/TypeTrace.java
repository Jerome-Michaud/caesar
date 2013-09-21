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
package jscratch.traces;

/**
 * Définit les différentes traces possible dans l'application.
 * 
 * @since 1.0
 * @version 1.0
 */
public enum TypeTrace {

	WIDGET_AJOUT, WIDGET_SUPPRESSION, WIDGET_DEPLACEMENT, WIDGET_MODIFICATION, 
	
	CATEGORIE_CHANGEMENT, 
	
	SIMULATEUR_BOUTONS, 
	
	ROBOT_ENVOI,
	
	PROPERTIES_CHARGEMENT, 
	
	FICHIER_CHARGEMENT, FICHIER_SAUVEGARDE;

	@Override
	public String toString() {
		switch(this) {
			case WIDGET_AJOUT:return "AJOUT";
			case WIDGET_DEPLACEMENT: return "DEPLACEMENT";
			case WIDGET_MODIFICATION: return "MODIFICATION";
			case WIDGET_SUPPRESSION: return "SUPPRESSION";
				
			case CATEGORIE_CHANGEMENT: return "CHANGEMENTCATEGORIE";
				
			case ROBOT_ENVOI: return "ROBOTENVOI";
				
			case SIMULATEUR_BOUTONS: return "SIMULATEURBOUTONS";
				
			case PROPERTIES_CHARGEMENT: return "PROPERTIESCHANGEMENT";
				
			case FICHIER_CHARGEMENT: return "CHARGEMENT";
			case FICHIER_SAUVEGARDE: return "SAUVEGARDE";	
				
			default: return "INCONNU";
		}
	}
	
	/**
	 * Permet de connaître la partie importante de la clé pour le properties.
	 * 
	 * @return le morceau de la cle
	 */
	public String toProperties() {
		switch(this) {
			case WIDGET_AJOUT:return "widget.ajout";
			case WIDGET_DEPLACEMENT: return "widget.deplacement";
			case WIDGET_MODIFICATION: return "widget.modification";
			case WIDGET_SUPPRESSION: return "widget.suppression";
				
			case CATEGORIE_CHANGEMENT: return "categorie.changement";
				
			case ROBOT_ENVOI: return "robot.transfert";
				
			case SIMULATEUR_BOUTONS: return "simulateur.boutons";
				
			case PROPERTIES_CHARGEMENT: return "properties.changement";
				
			case FICHIER_CHARGEMENT: return "fichier.chargement";
			case FICHIER_SAUVEGARDE: return "fichier.sauvegarde";
			default: return "inconnu";
		}
	}

	/**
	 * Permet de savoit si le type est compatible avec la <code>TraceFichier</code>.
	 * 
	 * @return <code>true</code> si compatible, <code>false</code> sinon
	 */
	public boolean isTraceFichier() {
		switch(this) {
			case ROBOT_ENVOI: return true;
			case PROPERTIES_CHARGEMENT: return true;
			case FICHIER_CHARGEMENT: return true;
			case FICHIER_SAUVEGARDE: return true;
			default: return false;
		}
	}
}
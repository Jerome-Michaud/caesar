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
package jscratch.sauvegarde.properties;

import java.io.File;
import jscratch.dictionnaires.DicoBoutonsCategories;
import jscratch.dictionnaires.DicoTraces;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.helpers.PropertiesHelper;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.traces.fabriques.FabriqueTrace;
import jscratch.vue.categories.boutons.BoutonCategorie;
import jscratch.vue.ginterface.principales.GUI;

/**
 * Permet de gérer le chargement des fichier properties.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class SauvegardePropertiesTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardePropertiesTools.
	 * 
	 * @since 1.0
	 */
	private static SauvegardePropertiesTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 * 
	 * @since 1.0
	 */
	private SauvegardePropertiesTools() { }

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardePropertiesTools.
	 *
	 * @since 1.0
	 * 
	 * @return l'instance unique de SauvegardePropertiesTools
	 */
	public static SauvegardePropertiesTools getInstance() {
		if (instance == null) {
			instance = new SauvegardePropertiesTools();
		}
		return instance;
	}

	@Override
	public void load(String path) {
		File fichier = new File(path);
		
		DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceChargementProperties(fichier));
		
		PropertiesHelper.getInstance().reset(fichier);
		
		// Suppression des widgets
		DicoWidgetsCategories.getInstance().nettoyer();
		
		if (GUI.getPanelTypeWidget().getCurrentCategorie() != null) {
			BoutonCategorie b = DicoBoutonsCategories.getInstance().getDico().get(GUI.getPanelTypeWidget().getCurrentCategorie());
			GUI.getPanelWidget().setLesWidgets(b.getNbColonnes());
		}
		
		// Mise à jour de l'interface
		GUI.getZoneUtilisateur().reset();
	}

	@Override
	public File save(String path) {
		return null;
	}
 }
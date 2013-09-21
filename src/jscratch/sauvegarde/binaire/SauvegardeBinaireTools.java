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
package jscratch.sauvegarde.binaire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import jscratch.dictionnaires.DicoTraces;
import jscratch.helpers.ErreurHelper;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.traces.fabriques.FabriqueTrace;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.widgets.Widget;

/**
 * Classe regroupant différents outils destinés à la sauvegarde et au chargement de projets JScratch
 *
 * @since 1.0
 * @version 1.0
 */
public final class SauvegardeBinaireTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardeBinaireTools
	 */
	private static SauvegardeBinaireTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 */
	private SauvegardeBinaireTools() { }

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardeBinaireTools.
	 *
	 * @since 1.0
	 * 
	 * @return l'instance unique de SauvegardeBBinaireTools
	 */
	public static SauvegardeBinaireTools getInstance() {
		if (instance == null) {
			instance = new SauvegardeBinaireTools();
		}
		return instance;
	}

	@Override
	public File save(final String path) {
		return serializeArborescence(path);
	}

	@Override
	public void load(final String path) {
		deserializeArborescence(path);
		GUI.getPanelCodeGraphique().repaint();
	}

	/**
	 * Permet la sérialisation de l'arborescence des widgets.
	 *
	 * @since 1.0
	 *
	 * @param path Le chemin où sauvegarder le l'arborescence
	 */
	private File serializeArborescence(final String path) {
		try {
			File fichier = new File(path);
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
			oos.writeObject(ArborescenceTools.getInstance().getArborescence());
			oos.flush();
			oos.close();
			
			DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceSauvegarde(fichier));
			
			return fichier;
		} catch (Exception e) {
			ErreurHelper.afficher(e);
		}
		
		return null;
	}

	/**
	 * Desérialise une arborescence précédemment sauvegardée.
	 *
	 * @since 1.0
	 *
	 * @param path Le chemin d'accès à l'arborscence sauvegardée
	 */
	private void deserializeArborescence(final String path) {
		try {
			FileInputStream fichier = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fichier);
			LinkedList<List<Widget>> arbos = (LinkedList<List<Widget>>) ois.readObject();
			ArborescenceTools.getInstance().initArborescence(arbos, true);
		} catch (Exception e) {
			ErreurHelper.afficher(e);
		}
	}
}
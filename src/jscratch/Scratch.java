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
package jscratch;

import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jscratch.dictionnaires.DicoBoutonsCategories;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.helpers.ErreurHelper;
import jscratch.helpers.LangueHelper;
import jscratch.parametrages.langue.VariableLangue;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.parametrages.ParametrageUI;

public class Scratch {

	/**
	 * Permet le lancement du programme
	 *
	 * @since 1.0
	 *
	 * @param args les paramètres du programme.
	 */
	public static void main(String[] args) {
		try {
			//Cle du lookandfeel
			String[] li = {"Licensee=Bastien Andru", "LicenseRegistrationNumber=NCBA120326", "Product=Synthetica", "LicenseType=Non Commercial", "ExpireDate=--.--.----", "MaxVersion=2.999.999"};
			UIManager.put("Synthetica.license.info", li);
			UIManager.put("Synthetica.license.key", "5DE6EB11-524B1D59-CD2B3EC7-3243D187-6EA8B694");

			// Cle des addons
			String[] li2 = {"Licensee=Bastien Andru", "LicenseRegistrationNumber=NCBA130131", "Product=SyntheticaAddons", "LicenseType=Non Commercial", "ExpireDate=--.--.----", "MaxVersion=1.999.999"};
			UIManager.put("SyntheticaAddons.license.info", li2);
			UIManager.put("SyntheticaAddons.license.key", "664973DE-55A50F80-8176ABB3-2BAFF4B7-5F2EEDB2");

			try {
				// ajout de l'anti-aliasing sur le texte
				System.setProperty("swing.aatext", "true");
				// Changement du look and feel
				SyntheticaLookAndFeel.setWindowsDecorated(false);
				UIManager.put("Synthetica.window.decoration", false);
				UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
			} catch (UnsupportedLookAndFeelException ex) {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				ErreurHelper.afficher(ex);
			}
		} catch (Exception ex) {
			ErreurHelper.afficher(ex);
		}

		// Interface de paramétrage
		if (args.length > 0 && "param".equals(args[0])) {
			ParametrageUI.getInstance();
		} // Interface utilisateur
		else {
			DicoBoutonsCategories.getInstance();
			DicoWidgetsCategories.getInstance().nettoyer();

			GUI.getFenetre();
		}
	}
}

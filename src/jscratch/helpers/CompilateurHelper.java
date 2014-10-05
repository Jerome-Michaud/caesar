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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import jscratch.parametrages.properties.VariableProperties;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.principales.selecteur.SelecteurFichier;
import jscratch.vue.ginterface.principales.selecteur.TypeSelecteur;

/**
 * Permet de faire le lien avec le compilateur.
 *
 * @since 1.0
 * @version 1.0
 */
public final class CompilateurHelper {

	/**
	 * Permet de compiler un fichier nxc.
	 *
	 * @param exec Booleen definissant si le programme doit etre executé ou non apres l'envoi au robot
	 *
	 * @since 1.0
	 *
	 * @param path l'url du fichier à compiler
	 */
	public static void exporter(final String path, boolean exec) {
		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}

			String os = System.getProperty("os.name").toLowerCase();
			List<String> cmd = new LinkedList<String>();

			// Choix du compilateur selon le système hôte
			if (os.contains("windows")) {
				cmd.add(VariableProperties.CHEMIN_ACCES_NBC_WIN);
			} else if (os.contains("mac")) {
				cmd.add(VariableProperties.CHEMIN_ACCES_NBC_MAC);
			} else if (os.contains("linux")) {
				cmd.add(VariableProperties.CHEMIN_ACCES_NBC_LINUX);
			} else {
				throw new IOException();
			}

			if (exec) {
				cmd.add("-r"); // Chargement puis exécution
			} else {
				cmd.add("-d"); // Chargement uniquement
			}
			cmd.add("-S=usb"); // Connexion USB
			cmd.add(fichier.getAbsolutePath()); // Fichier à compiler

			GUI.getPanelCompilateur().ecrireDateEtHeure();
			ProcessBuilder pb = new ProcessBuilder(cmd);
			Process p = pb.start();
			AfficheurFlux fluxSortie = new AfficheurFlux(p.getInputStream());
			AfficheurFlux fluxErreur = new AfficheurFlux(p.getErrorStream());
			new Thread(fluxSortie).start();
			new Thread(fluxErreur).start();
			try {
				p.waitFor();
			} catch (InterruptedException ex) {
				ErreurHelper.afficher(ex);
			}
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
	}

	/**
	 * Permet d'exporter le code actuel (sauvegarde + compilation).
	 *
	 * @param exec Booleen definissant si le programme doit etre executé ou non apres l'envoi au robot
	 * @since 1.0
	 */
	public static void exporter(boolean exec) {
		File fichier = new SelecteurFichier(TypeSelecteur.CODE).sauvegarde();
		if (fichier != null) {
			exporter(fichier.getAbsolutePath(), exec);
		}
	}

	static class AfficheurFlux implements Runnable {

		private final InputStream inputStream;

		AfficheurFlux(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		private BufferedReader getBufferedReader(InputStream is) {
			return new BufferedReader(new InputStreamReader(is));
		}

		@Override
		public void run() {
			BufferedReader br = getBufferedReader(inputStream);
			String ligne;
			try {
				while ((ligne = br.readLine()) != null) {
					GUI.getPanelCompilateur().ecrireNouvelleLigneInfo(ligne);
				}
			} catch (IOException e) {
				ErreurHelper.afficher(e);
			}
		}
	}
}
package jscratch.vue.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import jscratch.modeles.Erreur;

/**
 * Classe utilitaire permettant d'écrire les fichiers .NXC correspondant à l'arborescence graphique.
 */
public class CreationCodeTools {

	/**
	 * Constructeur privé de CreationCodeTools.
	 */
	private CreationCodeTools() { }

	/**
	 * Méthode statique permettant d'écrire le code NXC dans à l'endroit précisé en paramètre.
	 *
	 * @param path Le chemin où creer le fichier NXC
	 * @param text Le nom à donner au fihier NXC
	 */
	public static void ecrire(String path, String text) {
		PrintWriter ecri;
		try {
			ecri = new PrintWriter(new FileWriter(path));
			ecri.print(text);
			ecri.flush();
			ecri.close();
		} catch (NullPointerException a) {
			Erreur.afficher(a, "Erreur : pointeur null");
		} catch (IOException a) {
			Erreur.afficher(a, "Problème lors de l'écriture");
		}
	}
}
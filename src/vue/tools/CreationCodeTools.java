package vue.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Classe utilitaire permettant d'écrire les fichiers .NXC correspondant à l'arborescence graphique.
 */
public class CreationCodeTools {
	private CreationCodeTools() {}
	/**
	 * Méthode statique permettant d'écrire le code NXC dans à l'endroit précisé
	 * en paramètre.
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
		}
		catch (NullPointerException a) {
			System.err.println("Erreur : pointeur null");
		}
		catch (IOException a) {
			System.err.println("Problème lors de l'écriture : " + a.getMessage());
		}
	} 
}

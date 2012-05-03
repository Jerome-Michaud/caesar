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
	
	private static CreationCodeTools instance = new CreationCodeTools();
	private static String chemin = "";
	private static String fichier = "code.nxc";

	private CreationCodeTools() {}
	
	public static CreationCodeTools getInstance() {
		return instance;
	}
	
	public void ecrire(String text){
		ecrire(chemin+fichier, text);
	}
	/**
	 * Méthode statique permettant d'écrire le code NXC dans à l'ndroit précié
	 * en paramètre.
	 *
	 * @param path Le chemin où creer le fichier NXC
	 * @param text Le nom à donner au fihier NXC
	 */
	public void ecrire(String path, String text) 
	{
		PrintWriter ecri;
		try {
			ecri = new PrintWriter(new FileWriter(path));
			ecri.print(text);
			ecri.flush();
			ecri.close();
		}//try
		catch (NullPointerException a) {
			System.err.println("Erreur : pointeur null");
		}
		catch (IOException a) {
			System.err.println("Problème d'IO");
		}
	}//ecrire
 
	public String lire (String path) 
	{
		path = chemin+path;
		BufferedReader lect;
		String tmp = "";
		try	{
			lect = new BufferedReader(new FileReader(path)) ;
			while (lect.ready() == true) {
				tmp += lect.readLine(); 
			}//while
		}//try
		catch (NullPointerException a) {
			System.err.println("Erreur : pointeur null");
		}
		catch (IOException a) {
			System.err.println("Problème d'IO");
		}
		return tmp;
	}//lecture 
}//class

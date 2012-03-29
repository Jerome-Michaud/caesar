package vue.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;





public class CreationCodeTools {

	
	private static CreationCodeTools instance = new CreationCodeTools();
	private static String chemin = "";
	private static String fichier = "code.nxc";
	public static void main (String[] args){
		CreationCodeTools plop = CreationCodeTools.getInstance();
		plop.ecrire(chemin+fichier,"salut");
		plop.lire(chemin+fichier);
		
	}

	private CreationCodeTools() {
	}
	
	public static CreationCodeTools getInstance() {
		return instance;
	}
	
	public void ecrire(String text){
		ecrire(chemin+fichier,text);
	}

	
	public void ecrire(String path, String text) 
	{
		PrintWriter ecri ;
		try
		{
			ecri = new PrintWriter(new FileWriter(path));
			ecri.print(text);
			ecri.flush();
			ecri.close();
		}//try
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a)
		{
			System.out.println("Problème d'IO");
		}
	}//ecrire
 
	public String lire (String path) 
	{
		path = chemin+path;
		BufferedReader lect ;
		String tmp = "";
		try
		{
			lect = new BufferedReader(new FileReader(path)) ;
			while (lect.ready()==true) 
			{
				tmp += lect.readLine() ; 
			}//while
		}//try
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a) 
		{
			System.out.println("Problème d'IO");
		}
		return tmp;
	}//lecture 
}//class

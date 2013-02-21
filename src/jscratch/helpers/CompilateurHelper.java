package jscratch.helpers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jscratch.helpers.ErreurHelper;
import jscratch.parametrages.Variables;
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
			if (os.contains("windows")) {
				//cmd = "cmd.exe /c " + Variables.CHEMIN_ACCES_NBC + " -r -usb " + fichier.getAbsolutePath();
				cmd.add(Variables.CHEMIN_ACCES_NBC);
				if (exec) {
					cmd.add("-r");
				}else{
					cmd.add("-d");
				}
				cmd.add("-usb");
				cmd.add(fichier.getAbsolutePath());
			} else {
				//cmd = "./" + Variables.CHEMIN_ACCES_NBC + " -r -usb " + fichier.getAbsolutePath();
			}
			//cmd = "C:\\Users\\Bastien\\Documents\\NetBeansProjects\\jScratchPlusPlus\\compilateur\\nbc.exe -r -usb C:\\Users\\Bastien\\Desktop\\test.nxc";
			//Runtime.getRuntime().exec(cmd);
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
				Logger.getLogger(CompilateurHelper.class.getName()).log(Level.SEVERE, null, ex);
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
			String ligne = "";
			try {
				while ((ligne = br.readLine()) != null) {
					GUI.getPanelCompilateur().ecrireNouvelleLigneInfo(ligne);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
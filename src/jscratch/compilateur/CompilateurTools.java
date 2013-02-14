package jscratch.compilateur;

import java.io.File;
import java.io.IOException;
import jscratch.helpers.ErreurHelper;
import jscratch.parametrages.Variables;
import jscratch.vue.ginterface.principales.selecteur.SelecteurFichier;
import jscratch.vue.ginterface.principales.selecteur.TypeSelecteur;

/**
 * Permet de faire le lien avec le compilateur.
 * 
 * @since 1.0
 * @version 1.0
 */
public class CompilateurTools {

	/**
	 * Unique instance of <code>CompilateurTools</code>.
	 */
	private static CompilateurTools instance = null;

	/**
	 * Private constructor of <code>CompilateurTools</code>.
	 */
    private CompilateurTools() { }

	/**
	 * Accessor for <code>CompilateurTools</code>.
	 *
	 * @since 1.0
	 * 
	 * @return unique instance of <code>CompilateurTools</code>
	 */
    public static CompilateurTools getInstance() {
        if (instance == null) {
			instance = new CompilateurTools();
		}
		return instance;
    }
	
	/**
	 * Permet de compiler un fichier nxc.
	 * 
	 * @since 1.0
	 * 
	 * @param path l'url du fichier à compiler
	 */
	public void exporter(final String path) {
		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			
			String os = System.getProperty("os.name").toLowerCase();
			String cmd;
			if (os.contains("windows")) {
				cmd = "cmd.exe /c start " + Variables.CHEMIN_ACCES_NBC + " -r -usb " + fichier.getAbsolutePath() + " & pause";
			}
			else {
				cmd = "./" + Variables.CHEMIN_ACCES_NBC + " -r -usb " + fichier.getAbsolutePath();
			}
			
			Runtime.getRuntime().exec(cmd);
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
	}
	
	/**
	 * Permet d'exporter le code actuel (sauvegarde + compilation).
	 * 
	 * @since 1.0
	 */
	public void exporter() {
		File fichier = new SelecteurFichier(TypeSelecteur.CODE).sauvegarde();
		if (fichier != null) {
			this.exporter(fichier.getAbsolutePath());
		}
	}
 }
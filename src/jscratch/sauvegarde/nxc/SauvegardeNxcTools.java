package jscratch.sauvegarde.nxc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import jscratch.helpers.ErreurHelper;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.vue.ginterface.principales.GUI;

/**
 * @since 1.0
 * @version 1.0
 */
public final class SauvegardeNxcTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardeTxtTools
	 */
	private static SauvegardeNxcTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 */
	private SauvegardeNxcTools() { }

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardeTxtTools.
	 *
	 * @since 1.0
	 *
	 * @return l'instance unique de SauvegardeTxtTools
	 */
	public static SauvegardeNxcTools getInstance() {
		if (instance == null) {
			instance = new SauvegardeNxcTools();
		}
		return instance;
	}

	@Override
	public void load(String path) { }

	@Override
	public File save(String path) {
		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			FileWriter fw = new FileWriter(fichier);
			fw.append(GUI.getPanelCodeConsole().getText());
			fw.close();
			
			return fichier;
		} catch (IOException ex) {
			ErreurHelper.afficher(ex);
		}
		return null;
	}
 }
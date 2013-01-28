package jscratch.sauvegarde.nxc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import jscratch.modeles.Erreur;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.vue.ginterface.GUI;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public class SauvegardeNxcTools implements SauvegardeTools {

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
	public void save(String path) {
		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			FileWriter fw = new FileWriter(fichier);
			fw.append(GUI.getPanelCodeConsole().getText());
			fw.close();
		} catch (IOException ex) {
			Erreur.afficher(ex);
		}
	}
 }
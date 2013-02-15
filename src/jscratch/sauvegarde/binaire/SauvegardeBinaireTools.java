package jscratch.sauvegarde.binaire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import jscratch.helpers.ErreurHelper;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.widgets.Widget;

/**
 * Classe regroupant différents outils destinés à la sauvegarde et au chargement de projets JScratch
 *
 * @since 1.0
 * @version 1.0
 */
public final class SauvegardeBinaireTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardeBinaireTools
	 */
	private static SauvegardeBinaireTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 */
	private SauvegardeBinaireTools() { }

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardeBinaireTools.
	 *
	 * @since 1.0
	 * 
	 * @return l'instance unique de SauvegardeBBinaireTools
	 */
	public static SauvegardeBinaireTools getInstance() {
		if (instance == null) {
			instance = new SauvegardeBinaireTools();
		}
		return instance;
	}

	@Override
	public File save(final String path) {
		return serializeArborescence(path);
	}

	@Override
	public void load(final String path) {
		deserializeArborescence(path);
		GUI.getPanelCodeGraphique().repaint();
	}

	/**
	 * Permet la sérialisation de l'arborescence des widgets.
	 *
	 * @since 1.0
	 *
	 * @param path Le chemin où sauvegarder le l'arborescence
	 */
	private File serializeArborescence(final String path) {
		try {
			FileOutputStream fichier = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(ArborescenceTools.getInstance().getArborescence());
			oos.flush();
			oos.close();
			
			return new File(path);
		} catch (Exception e) {
			ErreurHelper.afficher(e);
		}
		
		return null;
	}

	/**
	 * Desérialise une arborescence précédemment sauvegardée.
	 *
	 * @since 1.0
	 *
	 * @param path Le chemin d'accès à l'arborscence sauvegardée
	 */
	private void deserializeArborescence(final String path) {
		try {
			FileInputStream fichier = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fichier);
			LinkedList<List<Widget>> arbos = (LinkedList<List<Widget>>) ois.readObject();
			ArborescenceTools.getInstance().initArborescence(arbos, true);
		} catch (Exception e) {
			ErreurHelper.afficher(e);
		}
	}
}
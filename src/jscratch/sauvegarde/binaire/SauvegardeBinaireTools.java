package jscratch.sauvegarde.binaire;

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
 * Classe regroupant différents outils destinés à la sauvegarde et au chargement
 * de projets JScratch
 *
 * @author Andru Bastien
 */
public class SauvegardeBinaireTools implements SauvegardeTools {

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
	 * @return l'instance unique de SauvegardeBBinaireTools
	 */
	public static SauvegardeBinaireTools getInstance() {
		if (instance == null) {
			instance = new SauvegardeBinaireTools();
		}
		return instance;
	}

	@Override
	public void save(final String path) {
		serializeArborescence(path);
	}

	@Override
	public void load(final String path) {
		deserializeArborescence(path);
		GUI.getPanelCodeGraphique().repaint();
	}

	/**
	 * Permet la sérialisation de l'arborescence des widgets.
	 *
	 * @param path Le chemin où sauvegarder le l'arborescence
	 */
	private void serializeArborescence(final String path) {
		try {
			FileOutputStream fichier = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(ArborescenceTools.getInstance().getArborescence());
			oos.flush();
			oos.close();
		} catch (Exception e) {
			ErreurHelper.afficher(e);
		}
	}

	/**
	 * Desérialise une arborescence précédemment sauvegardée.
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

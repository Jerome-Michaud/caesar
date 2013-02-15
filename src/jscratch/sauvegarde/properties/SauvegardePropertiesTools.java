package jscratch.sauvegarde.properties;

import java.io.File;
import jscratch.dictionnaires.DicoBoutonsCategories;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.helpers.PropertiesHelper;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.vue.categories.boutons.BoutonCategorie;
import jscratch.vue.ginterface.principales.GUI;

/**
 * Permet de gérer le chargement des fichier properties.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class SauvegardePropertiesTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardePropertiesTools.
	 * 
	 * @since 1.0
	 */
	private static SauvegardePropertiesTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 * 
	 * @since 1.0
	 */
	private SauvegardePropertiesTools() { }

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardePropertiesTools.
	 *
	 * @since 1.0
	 * 
	 * @return l'instance unique de SauvegardePropertiesTools
	 */
	public static SauvegardePropertiesTools getInstance() {
		if (instance == null) {
			instance = new SauvegardePropertiesTools();
		}
		return instance;
	}

	@Override
	public void load(String path) {
		PropertiesHelper.getInstance().reset(new File(path));
		
		// Suppression des widgets
		DicoWidgetsCategories.getInstance().nettoyer();
		
		if (GUI.getPanelTypeWidget().getCurrentCategorie() != null) {
			BoutonCategorie b = DicoBoutonsCategories.getInstance().getDico().get(GUI.getPanelTypeWidget().getCurrentCategorie());
			GUI.getPanelWidget().setLesWidgets(b.getNbColonnes());
		}
		
		// Mise à jour de l'interface
		GUI.getFenetre().reset();
		GUI.getZoneUtilisateur().reset();
	}

	@Override
	public File save(String path) {
		return null;
	}
 }
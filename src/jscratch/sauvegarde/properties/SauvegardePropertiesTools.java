package jscratch.sauvegarde.properties;

import java.io.File;
import jscratch.dictionnaires.DicoBoutonsCategories;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.helpers.PropertiesHelper;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.vue.categories.boutons.BoutonCategorie;
import jscratch.vue.ginterface.principales.GUI;

/**
 *
 * @since 1.0
 * @version 1.0
 */
public class SauvegardePropertiesTools implements SauvegardeTools {

	/**
	 * L'instance unique de SauvegardePropertiesTools
	 */
	private static SauvegardePropertiesTools instance = null;

	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 */
	private SauvegardePropertiesTools() { }

	/**
	 * Le getter pour récupérer l'instance unique de SauvegardePropertiesTools.
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
		
		// Remise à zéro des widgets
		DicoBoutonsCategories.getInstance().reset();
		
		// Suppression des widgets
		DicoWidgetsCategories.getInstance().nettoyer();
		
		BoutonCategorie b = DicoBoutonsCategories.getInstance().getDico().get(GUI.getPanelTypeWidget().getCurrentCategorie());
		GUI.getPanelWidget().setLesWidgets(b.getNbColonnes());
	}

	@Override
	public void save(String path) { }
 }
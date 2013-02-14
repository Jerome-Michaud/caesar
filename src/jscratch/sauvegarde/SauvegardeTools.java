package jscratch.sauvegarde;

import java.io.File;

/**
 * @since 1.0
 * @version 1.0
 */
public interface SauvegardeTools {

	/**
	 * Permet à l'utilisateur de charger un projet JScratch précédemment sauvegardé.
	 * 
	 * @since 1.0
	 */
	public void load(String path);

	/**
	 * Permet à l'utilisateur de sauvegarder son projet au format JScratch où il veut.
	 * 
	 * @since 1.0
	 */
	public File save(String path);
}

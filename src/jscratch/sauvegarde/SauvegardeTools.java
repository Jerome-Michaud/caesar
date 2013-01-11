package jscratch.sauvegarde;

/**
 *
 * @author Quentin
 */
public interface SauvegardeTools {

	/**
	 * Permet à l'utilisateur de charger un projet JScratch précédemment sauvegardé.
	 */
	public void load(String path);

	/**
	 * Permet à l'utilisateur de sauvegarder son projet au format JScratch où il veut.
	 */
	public void save(String path);
}

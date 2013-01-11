package jscratch.sauvegarde.filtres;

import javax.swing.filechooser.FileFilter;

/**
 * Définit un filtre pour l'application.
 */
public abstract class ApplicationFileFilter extends FileFilter {

	private String EXT;

	/**
	 * Constructeur par défaut de ApplicationFileFilter.
	 *
	 * @param ext l'extension du fichier généré ou accepté
	 */
	public ApplicationFileFilter(String ext) {
		this.EXT = ext;
	}

	/**
	 * récupère l'extension du fichier généré ou accepté.
	 *
	 * @return l'extension du fichier généré ou accepté
	 */
	public String getExtension() {
		return EXT;
	}
}

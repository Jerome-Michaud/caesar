package jscratch.sauvegarde.filtres;

import javax.swing.filechooser.FileFilter;

/**
 * Définit un filtre pour l'application.
 * 
 * @since 1.0
 * @version 1.0
 */
public abstract class ApplicationFileFilter extends FileFilter {

	/**
	 * Extension du filtre et description.
	 */
	private String EXT, DESC;

	/**
	 * Constructeur par défaut de ApplicationFileFilter.
	 *
	 * @param ext l'extension du fichier généré ou accepté
	 * @param desc la description du filtre
	 */
	public ApplicationFileFilter(final String ext, final String desc) {
		this.EXT = ext;
		this.DESC = desc;
	}

	/**
	 * récupère l'extension du fichier généré ou accepté.
	 *
	 * @since 1.0
	 * 
	 * @return l'extension du fichier généré ou accepté
	 */
	public String getExtension() {
		return EXT;
	}

	@Override
	public String getDescription() {
		return DESC;
	}
}
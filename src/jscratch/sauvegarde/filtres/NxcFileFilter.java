package jscratch.sauvegarde.filtres;

import java.io.File;

/**
 * @since 1.0
 * @version 1.0
 */
public final class NxcFileFilter extends ApplicationFileFilter {

	/**
	 * Constructeur par défaut de <code>NxcFileFilter</code>
	 */
	public NxcFileFilter() {
		super("nxc", "Fichier NXC");
	}

	@Override
	public boolean accept(File pathname) {
		if (pathname.isDirectory()) {
			return true;
		}
		String nomFichier = pathname.getName().toLowerCase();
		return nomFichier.endsWith(getExtension());
	}
}
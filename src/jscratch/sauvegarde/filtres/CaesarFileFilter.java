package jscratch.sauvegarde.filtres;

import java.io.File;

/**
 * @since 1.0
 * @version 1.0
 */
public final class CaesarFileFilter extends ApplicationFileFilter {

	/**
	 * Constructeur par défaut de <code>CaesarFileFilter</code>.
	 */
	public CaesarFileFilter() {
		super("csr", "Fichier C.A.E.S.A.R.");
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
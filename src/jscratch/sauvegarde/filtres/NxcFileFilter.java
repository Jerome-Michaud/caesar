package jscratch.sauvegarde.filtres;

import java.io.File;

/**
 * Classe permettant de définir un filtre de fichier sur les extension JSCRATCH (.nxc)
 * pour l'explorateur lors du chargement ou de la sauvegarde du code.
 *
 * @since 1.0
 * @version 1.0
 */
public final class NxcFileFilter extends ApplicationFileFilter {

	/**
	 * Constructeur privé de <code>NxcFileFilter</code>
	 */
	public NxcFileFilter() {
		super("nxc", "Fichier NXC");
	}

	/**
	 * Méthode redéfinissant la méthode accept de FileFilter afin qu'elle
	 * n'accepte que les repertoire ou les fihciers de type JSCRATCH
	 *
	 * @param pathname Le chemin d'accès au fihcier pour lequel il faut tester si doit être affiché ou non
	 * @return Un booléen indiquant s'il faut afficher le fichier ou non dans l'explorateur.
	 */
	@Override
	public boolean accept(File pathname) {
		if (pathname.isDirectory()) {
			return true;
		}
		String nomFichier = pathname.getName().toLowerCase();
		return nomFichier.endsWith(getExtension());
	}
}
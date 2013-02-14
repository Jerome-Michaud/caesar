package jscratch.sauvegarde.filtres;

import java.io.File;

/**
 * Classe permettant de définir un filtre de fichier sur les extension PROPERTIES (.properties)
 * pour l'explorateur lors du chargement ou de la sauvegarde d'un projet.
 *
 * @since 1.0
 * @version 1.0
 */
public class PropertiesFileFilter extends ApplicationFileFilter {

	/**
	 * La description des fichiers de type PROPERTIES à afficher dans
	 * l'explorateur
	 */
	private String descr;

	public PropertiesFileFilter() {
		super("properties");
		this.descr = "Fichier properties";
	}

	/**
	 * Méthode redéfinissant la méthode accept de FileFilter afin qu'elle
	 * n'accepte que les repertoire ou les fihciers de type PROPERTIES
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

	/**
	 * Méthode redéfinissant la méthode getDescription de FileFilter afin
	 * qu'elle retourne la description définie plus haut.
	 *
	 * @return La descrption définie dans le constructeur de la classe.
	 */
	@Override
	public String getDescription() {
		return this.descr;
	}
}

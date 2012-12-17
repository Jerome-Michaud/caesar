package vue.tools.sauvegarde;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Classe permettant de définir un filtre de fichier sur les extension JSCRATCH (.jsc)
 * pour l'explorateur lors du chargement ou de la sauvegarde d'un projet.
 * @author Bastien ANDRU
 */
public class JScratchFileFilter extends FileFilter {
	/**
	 * Constante stockant l'extension à appliquer aux fichiers JSCRATCH.
	 */
    public static final String EXT = "jsc";
    /**
     * La description des fichiers de type JSCRATCH à afficher dans
     * l'explorateur
     */
    private String descr;
    
    public JScratchFileFilter() {
        this.descr = "Fichiers JScratch";
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
        return nomFichier.endsWith(EXT);
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

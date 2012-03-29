/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.Tools;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Bastien
 */
public class JScratchFileFilter extends FileFilter {

    public static final String ext = "jsc";
    private String descr;

    public JScratchFileFilter() {
        this.descr = "Fichiers JScratch";
    }

    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }

        String nomFichier = pathname.getName().toLowerCase();

        return nomFichier.endsWith(this.ext);

    }

    @Override
    public String getDescription() {
        return this.descr;
    }
}
